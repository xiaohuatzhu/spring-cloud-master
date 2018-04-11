package bhz.springcloud.service.api;

import bhz.springcloud.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(String id) {
        System.out.println("-------------------client--2---getUser: id=" + id);
        return new User(id, "张三", 23);
    }

    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(String id) {
        System.out.println("-------------------client--2---postUser: id=" + id);
        return new User(id, "张三", 23);
    }

    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
    public String insertUser(@RequestBody User user) {
        System.out.println("-------------------client--2---insertUser: user=" + user);
        return user.getId();
    }

    @RequestMapping(value = "/putUser", method = {RequestMethod.PUT})
    public String putUser(@RequestBody User user, @RequestParam String id) {
        System.out.println("-------------------client--2---putUser: id=" + id + ", user=" + user);
        return user.toString();
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE})
    public String deleteUser(String id) {
        System.out.println("-------------------client--2---deleteUser: id=" + id);
        return id;
    }

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry() {
        System.err.println("client 2 call ............");
        try {
            // 模拟请求超时, 时间大于retry的超时时间
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "client2";
    }
}
