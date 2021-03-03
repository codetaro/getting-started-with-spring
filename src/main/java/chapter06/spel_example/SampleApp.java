package chapter06.spel_example;

import chapter06.spel_example.beans.Sample;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class SampleApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter06/spel_example/applicationContext.xml");
        Sample sample = context.getBean(Sample.class);
        log.info(sample);
    }
}
