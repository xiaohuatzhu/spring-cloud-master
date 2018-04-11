package bhz.springcloud.service.api;

import bhz.springcloud.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://client-service/retry", String.class);
        String result = responseEntity.getBody();
        System.err.println("--------------result---->---" + result);
        return "result:" + result;
    }

    @RequestMapping(value = "/retry-hystrix", method = {RequestMethod.GET})
    public String retryHystrix() {
        String result = retryService.callRetry();
        System.err.println("--------------result---->---" + result);
        return "result:" + result;
    }
}
