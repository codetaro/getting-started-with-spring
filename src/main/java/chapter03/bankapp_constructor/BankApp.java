package chapter03.bankapp_constructor;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.controller.FixedDepositController;
import chapter03.bankapp_inheritance.controller.PersonalBankingController;
import chapter03.bankapp_inheritance.controller.UserRequestController;
import chapter03.bankapp_inheritance.domain.Request;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter03/bankapp_constructor/applicationContext.xml");

        FixedDepositController fixedDepositController = context.getBean(FixedDepositController.class);
        fixedDepositController.submit(context
                .getBean(FixedDepositDetails.class).setDepositAmount(100)
                .setEmail("someemail@somedomain.com").setId(1).setTenure(10));
        logger.info("Your fixed deposit details: " + fixedDepositController.get());

        PersonalBankingController personalBankingController = context.getBean(PersonalBankingController.class);
        logger.info(personalBankingController.getMiniStatement());

        UserRequestController userRequestController = context.getBean(UserRequestController.class);
        userRequestController.submitRequest(new Request());
        logger.info("Submitted user request");
    }
}
