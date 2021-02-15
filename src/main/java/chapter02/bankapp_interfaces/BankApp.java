package chapter02.bankapp_interfaces;

import chapter02.bankapp_interfaces.controller.FixedDepositController;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter02/interfaces/applicationContext.xml");

        FixedDepositController fixedDepositController =
                (FixedDepositController) context.getBean("controller");

        logger.info("Submission status of fixed deposit: " +
                fixedDepositController.submit());
        logger.info("Returned fixed deposit info: " +
                fixedDepositController.get());
    }
}
