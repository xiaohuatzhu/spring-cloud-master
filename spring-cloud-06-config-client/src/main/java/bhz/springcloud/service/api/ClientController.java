package bhz.springcloud.service.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope   //动态刷新远程config的值, 更改后访问 localhost:7001/refresh from的值就刷新了
@RestController
public class ClientController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from", method = {RequestMethod.GET})
    public String from() {
        System.err.println("from=" + from);
        return from;
    }

}
