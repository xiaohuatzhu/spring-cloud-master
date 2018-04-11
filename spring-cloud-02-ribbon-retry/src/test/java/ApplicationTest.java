import bhz.springcloud.RetryApplication;
import bhz.springcloud.service.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetryApplication.class)
public class ApplicationTest {

    @Autowired
    private RetryService retryService;

    @Test
    public void testRetry() throws Exception {
        retryService.call();
    }
}
