package bhz.springcloud.service.api;

import bhz.springcloud.feign.ProviderFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class FeignConsumerController {

    @Resource
    private ProviderFeignClient providerFeignClient;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(String s) {
        return providerFeignClient.hello(s);
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        return providerFeignClient.hi();
    }

    @RequestMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    String uploadImage(MultipartFile file) throws Exception {
        return providerFeignClient.uploadImage(file);
    }
}
