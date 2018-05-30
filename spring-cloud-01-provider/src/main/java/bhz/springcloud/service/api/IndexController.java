package bhz.springcloud.service.api;

import bhz.springcloud.aspect.Encoreable;
import bhz.springcloud.aspect.Performance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {
    @Resource
    private Performance performance;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/test-aspect", method = {RequestMethod.GET})
    public String aspect(){
        this.performance.perform();
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
        return "test-aspect";
    }
}
