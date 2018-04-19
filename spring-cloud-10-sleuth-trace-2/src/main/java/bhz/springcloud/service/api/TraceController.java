package bhz.springcloud.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TraceController {

    private static final Logger log = LoggerFactory.getLogger(TraceController.class);

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(@RequestParam("s") String s) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> trace-2: hello: {}", s);
        return "hello feign!" + s;
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi(HttpServletRequest request) {
        // 在发送到trace-2之前sleuth会为在该请求的 Header 中增加实现跟踪需要的重要信息，
        // 主要有下面这几个（更多关于头信息的定义我们可以通过查看org.springframework.cloud.sleuth.Span的源码获取）：
        //
        // X-B3-TraceId：一条请求链路（Trace）的唯一标识，必须值
        // X-B3-SpanId：一个工作单元（Span）的唯一标识，必须值
        // X-B3-ParentSpanId:：标识当前工作单元所属的上一个工作单元，Root Span（请求链路的第一个工作单元）的该值为空
        // X-B3-Sampled：是否被抽样输出的标志，1表示需要被输出，0表示不需要被输出
        // X-Span-Name：工作单元的名称
        log.info("===<call trace-2, TraceId={}, SpanId={}>===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        log.info(">>>>>>>>>>>>>>>>>>>>>>> trace-2: hi");
        return "hi feign!";
    }

}
