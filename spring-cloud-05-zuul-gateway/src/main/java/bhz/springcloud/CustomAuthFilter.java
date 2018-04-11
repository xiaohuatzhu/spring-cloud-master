package bhz.springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component //注入到spring容器, 由spring容器管理
public class CustomAuthFilter extends ZuulFilter {

    public static final String TOKEN_VALUE = "123456";

    /**
     * 四种类型:
     * <p>
     * pre: 在请求被路由之前调用
     * routing: 在请求路由之中调用
     * post: 在请求路由之后调用
     * error: 处理请求发生错误时调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 当有多个filter时, 返回值越小(0最高), 越早执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要执行当前filter的开关
     * 如果为false则不执行, 不管其他情况
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体执行filter里面代码的逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        // http 请求 ----> zuul (run方法) ----> RequestContext
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        //请求路径
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        System.out.println("uri=" + uri);
        System.out.println("URL=" + url);

        // 放行
        if ("/luck-service/upload".equals(uri) || "/zuul/luck-service/upload".equals(uri)) {
            return null;
        }

        // token (一般放在 header 中)
        String token = request.getHeader("x-auth-token");
        System.out.println("token=" + token);

        if (StringUtils.isBlank(token)) {
            System.err.println("没有token...校验失败.....");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("------no token--------");
            return null;
        } else {
            // 拿到token, 比如可以去redis中查有没有此token
            if (TOKEN_VALUE.equals(token)) {
                // 获取到的token一般是加密的, 需要解密: userId_orgId_roleId, 然后传到下游
                ctx.addZuulRequestHeader("userInfo", "001");
                ctx.addZuulRequestHeader("otherParam", "someParam");
            } else {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.setResponseBody("------token auth fail--------");
                return null;
            }
        }

        return ctx;
    }
}
