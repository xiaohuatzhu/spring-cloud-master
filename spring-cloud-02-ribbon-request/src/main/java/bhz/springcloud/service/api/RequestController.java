package bhz.springcloud.service.api;

import bhz.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public String get() {
        String id = "001";
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://client-service/getUser?id={1}", User.class, id);
        User user = responseEntity.getBody();
        System.out.println("--------------get---->---" + user);
        return user.toString();
    }

    @RequestMapping(value = "/post", method = {RequestMethod.GET})
    public String post() {
        String id = "002";
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.set("id", id);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://client-service/postUser", map, User.class);
        User user = responseEntity.getBody();
        System.out.println("--------------post---->---" + user);
        return user.toString();
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.GET})
    public String insert() {
        User user = new User("003", "post", 3);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://client-service/insertUser", user, String.class);
        String resp = responseEntity.getBody();
        System.out.println("--------------insert---->---" + user);
        return resp;
    }

    @RequestMapping(value = "/put", method = {RequestMethod.GET})
    public String put() {
        User user = new User("004", "post", 4);
        restTemplate.put("http://client-service/putUser?id={1}", user, "004");
        System.out.println("--------------put---->---" + user);
        return "put";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String delete() {
        User user = new User("004", "post", 4);
        restTemplate.delete("http://client-service/deleteUser?id={1}", "004");
        System.out.println("--------------delete---->---" + user);
        return "delete";
    }
}
