package bhz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

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

    @RequestMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public String uploadImage(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        OutputStream os = null;
        try {
            String path = "D:\\testFile\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + System.currentTimeMillis() + "-" + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "Success";
    }


}
