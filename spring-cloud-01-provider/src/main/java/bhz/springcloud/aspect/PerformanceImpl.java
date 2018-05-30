package bhz.springcloud.aspect;

import org.springframework.stereotype.Component;

/**
 * PerformanceImpl
 *
 * @author zhuxiaohua
 * @date 2018年05月30日 10:56
 */
@Component("performance")
public class PerformanceImpl implements Performance {

    @Override
    public void perform() {
        System.out.println(PerformanceImpl.class.getName());
    }
}
