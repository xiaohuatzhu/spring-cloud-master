package bhz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(@RequestParam("s") String s) {
        System.out.println("hello feign .........." + s);
        return "hello feign!" + s;
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        System.out.println("hi feign ..........");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hi feign!";
    }

}
