package bhz.springcloud.feign.hystrix;

import bhz.springcloud.feign.ProviderFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ProviderFeignClientHystrixFallback implements ProviderFeignClient {
    @Override
    public String hello(String s) {
        return "-------------------hello方法的降级策略-----------------";
    }

    @Override
    public String hi() {
        return "-------------------hi方法的降级策略-----------------";
    }
}
