package bhz.springcloud.feign;

import bhz.springcloud.feign.hystrix.ProviderFeignClientHystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-provider", fallback = ProviderFeignClientHystrixFallback.class)
public interface ProviderFeignClient {
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(@RequestParam("s")String s);

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi();
}
