package test.goods;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tommy on 17/5/27.
 */
public class BaseTest {
    private static ClassPathXmlApplicationContext context=null;
    public static  <T> T getBean(Class<T> tClass) {
        if (context == null) {
            context=init();
        }
       return context.getBean(tClass);
    }
    private static ClassPathXmlApplicationContext init(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/config/spring.xml");
        context.start();
        return context;
    }
}
