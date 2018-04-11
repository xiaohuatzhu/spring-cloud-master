package bhz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello(@RequestHeader("userInfo") String userInfo, @RequestHeader("otherParam") String otherParam) {
        System.out.println("hello zuul ..........");
        System.err.println("userInfo=" + userInfo);
        System.err.println("otherParam=" + otherParam);
        return "hello zuul!";
    }

}
