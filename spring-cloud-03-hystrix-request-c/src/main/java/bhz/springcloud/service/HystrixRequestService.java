package bhz.springcloud.service;

import bhz.springcloud.feign.IFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.undertow.util.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixRequestService {

    @Autowired
    private IFeignClient iFeignClient;

    public String callHello() {
        return iFeignClient.hello();
    }


    public String handler() {
        throw new RuntimeException("----------handler---------RuntimeException");
    }


    public String callHi() {
        return iFeignClient.hi();
    }


    public String callDashboard() {
        return iFeignClient.dashboard();
    }

}
