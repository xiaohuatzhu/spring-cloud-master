package bhz.springcloud.service.api;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class LuckController {

    @RequestMapping(value = "/luck", method = {RequestMethod.GET})
    public String luck() {
        System.out.println("luck zuul ..........");
        return "luck zuul!";
    }

    /**
     * 演示上传文件, 客户端--NGINX--ZULL--服务
     * @return
     */
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public String upload(@RequestParam("file")MultipartFile file) {
        System.out.println("upload start ..........fileName="+file.getOriginalFilename());
        try {
            FileUtils.writeByteArrayToFile(new File("d:/springcloud/"+file.getOriginalFilename()),file.getBytes());
        } catch (IOException e) {
            System.err.println("upload fail ..........fileName="+file.getOriginalFilename());
            return "upload fail!";
        }
        return "upload success!";
    }

}
