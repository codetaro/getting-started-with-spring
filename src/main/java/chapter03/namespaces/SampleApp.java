package chapter03.namespaces;

import chapter03.bankapp_inheritance.domain.BankStatement;
import chapter03.namespaces.beans.BankDetails;
import chapter03.simple.beans.CollectionTypesExample;
import chapter03.simple.beans.DataTypesExample;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {
    private static Logger logger = Logger.getLogger(SampleApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter03/namespaces/applicationContext.xml");

        BankDetails bankDetails = context.getBean(BankDetails.class);
        logger.info(bankDetails);

        BankStatement bankStatement = context.getBean(BankStatement.class);
        logger.info(bankStatement);

        logger.info("Created context successfully");
    }
}
