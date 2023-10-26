
import com.atguigu.spring.aop.annotion.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {
    @Test
    public void test1(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("aop-annotation.xml");
//        获取目标对象的代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,2);
        calculator.div(1,1);
        calculator.sub(1,2);
    }
}
