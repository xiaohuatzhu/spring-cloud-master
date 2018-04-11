package bhz.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetryService {

    // 用于hystrix
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 方法: 需要进行重试[远程服务调用失败的情况,再次进行调用]
     *
     * 用的是retry框架, 不是ribbon
     *
     * @throws Exception
     */
    @Retryable(value = {RemoteAccessException.class}, //抛出什么样的异常时进行重试策略的执行
            maxAttempts = 3, //重试次数
            backoff = @Backoff(delay = 5000, multiplier = 5)) //延迟间隔, 多少个执行者
    public void call() throws Exception {
        System.out.println("................调用了call方法................");
        throw new RemoteAccessException("................RPC调用异常................");
    }

    @Recover //做最终失败的补偿
    public void recover(RemoteAccessException e) {
        System.err.println("................最终处理................message: " + e.getMessage());
    }



    @HystrixCommand(fallbackMethod = "callRetryFailback")
    public String callRetry() {
        return restTemplate.getForObject("http://client-service/retry", String.class);
    }

    public String callRetryFailback() {
        System.err.println("callRetryFailback------执行降级策略");
        return "callRetryFailback------执行降级策略";
    }


}
