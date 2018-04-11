package bhz.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getByAppName", method = {RequestMethod.GET})
    public String getByAppName() {
        // 调用地址: http:// [请求协议头] provider-service [服务名] /provider [context-path] /hello [调用方法的地址]
        // 建议 如果使用服务名称, 就不需要使用context-path了
        String url = "http://provider-service/provider/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();
        System.out.println("getByAppName--body: " + body);
        return "Success!";
    }

    /**
     * RestTemplate 方式调用(http调用), 与SpringCloud没有任何关系
     * @return
     */
    @RequestMapping(value = "/getByUrl", method = {RequestMethod.GET})
    public String hello() {
        String url = "http://localhost:7001/provider/hello";
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        String body = response.getBody();
        System.out.println("getByUrl--body: " + body);
        return "Success!";
    }
}
