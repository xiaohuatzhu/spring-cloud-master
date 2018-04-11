package bhz.springcloud.feign;

import bhz.springcloud.feign.fallback.IFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "client-service", fallback = IFeignClientFallback.class)
public interface IFeignClient {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello();

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi();

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
    public String dashboard();
}
