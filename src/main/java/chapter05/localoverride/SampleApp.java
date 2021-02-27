package chapter05.localoverride;

import chapter05.propertySourcesPlaceholderConfigurer.domain.DataSource;
import chapter05.propertySourcesPlaceholderConfigurer.domain.WebServiceConfiguration;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class SampleApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter05/localoverride/applicationContext.xml");

        log.info(context.getBean(DataSource.class));
        log.info(context.getBean(WebServiceConfiguration.class));
    }
}
