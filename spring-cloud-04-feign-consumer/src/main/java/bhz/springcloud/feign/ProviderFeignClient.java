package bhz.springcloud.feign;

import bhz.springcloud.config.MultipartSupportConfig;
import bhz.springcloud.feign.hystrix.ProviderFeignClientHystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

/**
 * 对 feign 进行文件上传的支持, 加入:
 * configuration = MultipartSupportConfig.class
 *
 * @author zhuxiaohua
 * @date 16:10 2018/4/19
 */
@FeignClient(name = "feign-provider", fallback = ProviderFeignClientHystrixFallback.class, configuration = MultipartSupportConfig.class)
public interface ProviderFeignClient {
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    String hello(@RequestParam("s") String s);

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    String hi();

    @RequestMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    String uploadImage(MultipartFile file) throws Exception;
}
