package chapter03.simple;

import chapter03.simple.beans.BankDetails;
import chapter03.simple.beans.CollectionTypesExample;
import chapter03.simple.beans.DataTypesExample;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {
    private static Logger logger = Logger.getLogger(SampleApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter03/simple/applicationContext.xml");

        BankDetails bankDetails = context.getBean(BankDetails.class);
        logger.info(bankDetails);

        context.getBean(DataTypesExample.class);
        logger.info("Created context successfully");

        logger.info(context.getBean(CollectionTypesExample.class));
    }
}
