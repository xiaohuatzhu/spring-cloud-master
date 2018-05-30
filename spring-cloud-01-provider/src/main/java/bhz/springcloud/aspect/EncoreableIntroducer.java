package bhz.springcloud.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * EncoreableIntroducer
 *
 * @author zhuxiaohua
 * @date 2018年05月30日 10:53
 */
@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "bhz.springcloud.aspect.Performance+", defaultImpl = DefaultEncoreableImpl.class)
    public static Encoreable encoreable;

//    @Before("bean(performance) && this(encoreable)")
//    public void beforcePerformance(Encoreable encoreable) {
//        encoreable.performEncore();
//    }
//
//    @Resource
//    private Encoreable encoreable;
//
//    @Before("bean(performance)")
//    public void beforcePerformance() {
//        encoreable.performEncore();
//    }
}
