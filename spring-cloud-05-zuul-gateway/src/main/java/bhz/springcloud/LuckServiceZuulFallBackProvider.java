package bhz.springcloud;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 指定断熔某个服务, 自定义响应信息内容
 */
@Component
public class LuckServiceZuulFallBackProvider implements ZuulFallbackProvider {
    /**
     * 指定要断熔的服务的名字: appName
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "luck-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            // 自定义响应的状态
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST; //400
            }

            // 自定义响应的状态码
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value(); //400
            }

            // 状态文本信息
            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("service error...".getBytes());
            }

            // response的响应头信息
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
