package bhz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("hello hystrix ..........");
        return "hello hystrix!";
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("hi hystrix ..........");
        return "hi hystrix!";
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
    public String dashboard() {
        System.out.println("dashboard hystrix ..........");
        return "dashboard hystrix!";
    }

}
