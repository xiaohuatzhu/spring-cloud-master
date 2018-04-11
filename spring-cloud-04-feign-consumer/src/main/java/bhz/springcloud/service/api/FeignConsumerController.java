package bhz.springcloud.service.api;

import bhz.springcloud.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignConsumerController {

    @Resource
    private ProviderFeignClient providerFeignClient;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(String s){
        return providerFeignClient.hello(s);
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi(){
        return providerFeignClient.hi();
    }
}
