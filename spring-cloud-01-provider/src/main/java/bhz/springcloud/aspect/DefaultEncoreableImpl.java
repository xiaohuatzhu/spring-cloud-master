package bhz.springcloud.aspect;

import org.springframework.stereotype.Component;

/**
 * DefaultEncoreableImpl
 *
 * @author zhuxiaohua
 * @date 2018年05月30日 10:55
 */
@Component
public class DefaultEncoreableImpl implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println(DefaultEncoreableImpl.class.getName());
    }
}
