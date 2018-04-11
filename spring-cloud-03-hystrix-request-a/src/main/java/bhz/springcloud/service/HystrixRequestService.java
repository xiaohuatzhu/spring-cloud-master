package bhz.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.undertow.util.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixRequestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callHelloFailback")
    public String callHello() {
        return restTemplate.getForObject("http://client-service/hello", String.class);
    }

    public String callHelloFailback() {
        System.err.println("---------------callHelloFailback---执行降级策略--------");
        return "---------------callHelloFailback---执行降级策略--------";
    }

    @HystrixCommand(fallbackMethod = "handlerFailback", ignoreExceptions = BadRequestException.class)
    public String handler() {
        throw new RuntimeException("----------handler---------RuntimeException");
    }

    public String handlerFailback(Throwable e) {
        System.err.println("异常信息:" + e.getMessage());
        return "获取异常信息, 并且可以做相应的降级处理";
    }

    @HystrixCommand(fallbackMethod = "callHiFailback",
            commandKey = "hiKey" /**名称,一般为[方法名+Key]*/
            , commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",/**KEY*/ value = "8000" /**VALUE*/)})
    public String callHi() {
        return restTemplate.getForObject("http://client-service/hi", String.class);
    }

    public String callHiFailback() {
        System.err.println("---------------callHiFailback---执行降级策略--------");
        return "---------------callHiFailback---执行降级策略--------";
    }

    @HystrixCommand(fallbackMethod = "callDashboardFailback")
    public String callDashboard() {
        return restTemplate.getForObject("http://client-service/dashboard", String.class);
    }

    public String callDashboardFailback() {
        System.err.println("---------------callDashboardFailback---执行降级策略--------");
        return "---------------callDashboardFailback---执行降级策略--------";
    }
}
