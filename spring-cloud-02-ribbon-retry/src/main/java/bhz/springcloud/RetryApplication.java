package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker       // 启用断路器
@EnableRetry                // 启用Retry框架的重试机制
@SpringBootApplication
@EnableDiscoveryClient         // 启用服务器的配置中心
public class RetryApplication {

    @Bean
    @ConfigurationProperties(prefix = "custom.restTemplate")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(1000);
//        httpComponentsClientHttpRequestFactory.setReadTimeout(3000);
//        httpComponentsClientHttpRequestFactory.setConnectTimeout(1000);
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(httpComponentsClientHttpRequestFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class, args);
    }

}