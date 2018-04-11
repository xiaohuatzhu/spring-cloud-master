package bhz.springcloud.feign.fallback;

import bhz.springcloud.feign.IFeignClient;
import org.springframework.stereotype.Component;

@Component
public class IFeignClientFallback implements IFeignClient {
    @Override
    public String hello() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.hello() 执行降级策略");
        return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.hello() 执行降级策略";
    }

    @Override
    public String hi() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.hi() 执行降级策略");
        return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.hi() 执行降级策略";
    }

    @Override
    public String dashboard() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.dashboard() 执行降级策略");
        return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>IFeignClientFallback.dashboard() 执行降级策略";
    }
}
