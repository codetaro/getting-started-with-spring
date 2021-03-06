package chapter03.bankapp_factorybean;

import chapter01.bankapp.FixedDepositDetails;
import chapter03.bankapp_factorybean.service.FixedDepositService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter03/bankapp_factorybean/applicationContext.xml");

        FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("service");

        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                101, 10000, 60, "someemail@somedomain.com"));

        logger.info("Invoking getBean('eventFactory') returns: " + context.getBean("eventSenderFactory"));
        logger.info("Invoking getBean('&eventFactory') returns: " + context.getBean("&eventSenderFactory"));
    }
}
