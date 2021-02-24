package chapter04.bankapp_dependencies;

import chapter04.bankapp_dependencies.domain.FixedDepositDetails;
import chapter04.bankapp_dependencies.service.CustomerRegistrationService;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import chapter04.bankapp_dependencies.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter04/bankapp_dependencies/applicationContext.xml");

        FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("service");

        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                101, 10000, 60, "someemail@somedomain.com"));

        log.info("Beginning with accessing CustomerRequestService");
        CustomerRequestService customerRequestService_1 = context.getBean(CustomerRequestService.class);
        customerRequestService_1.submitRequest(
                "checkBookRequest", "Request to send a 50-leaf check book");
        CustomerRequestService customerRequestService_2 = context.getBean(CustomerRequestService.class);
        customerRequestService_2.submitRequest(
                "checkBookRequest", "Request to send a 100-leaf check book");
        log.info("Done with accessing CustomerRequestService");

        log.info("Beginning with accessing CustomerRegistrationService");

        CustomerRegistrationService customerRegistrationService_1 = context
                .getBean(CustomerRegistrationService.class);
        customerRegistrationService_1.setAccountNumber("account_1");
        customerRegistrationService_1.setAddress("address_1");
        customerRegistrationService_1.setDebitCardNumber("debitCardNumber_1");
        customerRegistrationService_1.register();
        log.info("registered customer with id account_1");

        CustomerRegistrationService customerRegistrationService_2 = context
                .getBean(CustomerRegistrationService.class);
        customerRegistrationService_2.setAccountNumber("account_2");
        customerRegistrationService_2.setAddress("address_2");
        customerRegistrationService_2.setDebitCardNumber("debitCardNumber_2");
        customerRegistrationService_2.register();
        log.info("registered customer with id account_2");

        log.info("Done with accessing CustomerRegistrationService");
    }
}
