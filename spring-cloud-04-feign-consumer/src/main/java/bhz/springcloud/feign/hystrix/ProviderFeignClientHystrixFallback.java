package bhz.springcloud.feign.hystrix;

import bhz.springcloud.feign.ProviderFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public String uploadImage(MultipartFile file) throws Exception {
        return "-------------------uploadImage 方法的降级策略-----------------";
    }
}
