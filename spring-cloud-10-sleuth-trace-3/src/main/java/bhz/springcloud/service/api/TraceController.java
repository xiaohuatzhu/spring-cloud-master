package bhz.springcloud.service.api;

import bhz.springcloud.feign.ProviderFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TraceController {

    private static final Logger log = LoggerFactory.getLogger(TraceController.class);

    @Resource
    private ProviderFeignClient providerFeignClient;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(String s) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> trace-1: hello: {}", s);
        return providerFeignClient.hello(s);
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> trace-1: hi");
        return providerFeignClient.hi();
    }
}
