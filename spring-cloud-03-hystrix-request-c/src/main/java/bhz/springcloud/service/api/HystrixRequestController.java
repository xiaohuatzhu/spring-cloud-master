package bhz.springcloud.service.api;

import bhz.springcloud.service.HystrixRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixRequestController {

    @Autowired
    private HystrixRequestService hystrixRequestService;

    @RequestMapping(value = "/hystrix-hello", method = {RequestMethod.GET})
    public String hello() {
        return hystrixRequestService.callHello();
    }

    /**
     * 演示忽略指定异常, 不掉failback方法
     *
     * @return
     */
    @RequestMapping(value = "/hystrix-handler", method = {RequestMethod.GET})
    public String handler() {
        return hystrixRequestService.handler();
    }

    /**
     * 演示自定义属性
     *
     * @return
     */
    @RequestMapping(value = "/hystrix-hi", method = {RequestMethod.GET})
    public String hi() {
        return hystrixRequestService.callHi();
    }

    /**
     * 演示dashboard
     *
     * @return
     */
    @RequestMapping(value = "/hystrix-dashboard", method = {RequestMethod.GET})
    public String dashboard() {
        return hystrixRequestService.callDashboard();
    }
}
