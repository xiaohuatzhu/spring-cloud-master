import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonTest
 *
 * @author zhuxiaohua
 * @date 2018年04月02日 10:46
 */
public class CommonTest {

    @Test
    public void testJsonCal() {
        Binding binding = new Binding();

        binding.setVariable("F", 2.5);
        binding.setVariable("T", 30);
        binding.setVariable("A", 100);
        binding.setVariable("P0", 100);

        binding.setVariable("language", "Groovy");

        GroovyShell shell = new GroovyShell(binding);

        Object F1 = shell.evaluate("P1=(1+0.1 * (F/100) * T)*P0; return P1 ");

        Object F2 = shell.evaluate("P1=P0*(0.055*0.20+1.0011)+A; return P1 ");

        System.out.println(F1);
        System.out.println(F2);
    }

    @Test
    public void testList() {

    }
}
