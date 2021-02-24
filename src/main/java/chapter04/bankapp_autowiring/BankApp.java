package chapter04.bankapp_autowiring;

import chapter04.bankapp_autowiring.service.AccountStatementService;
import chapter04.bankapp_dependencies.domain.FixedDepositDetails;
import chapter04.bankapp_dependencies.service.CustomerRegistrationService;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import chapter04.bankapp_dependencies.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter04/bankapp_autowiring/applicationContext.xml");

        log.info("Beginning with accessing CustomerRequestService (autowire='constructor')");
        CustomerRequestService customerRequestService_1 = (CustomerRequestService) context
                .getBean("customerRequestService");
        customerRequestService_1.submitRequest("checkBookRequest",
                "Request to send a 50-leaf check book");
        log.info("Done with accessing CustomerRequestService (autowire='constructor')");

        log.info("Beginning with accessing CustomerRegistrationService (autowire='byType')");
        CustomerRegistrationService customerRegistrationService_1 = (CustomerRegistrationService) context
                .getBean("customerRegistrationService");
        customerRegistrationService_1.setAccountNumber("account_1");
        customerRegistrationService_1.setAddress("address_1");
        customerRegistrationService_1.setDebitCardNumber("debitCardNumber_1");
        customerRegistrationService_1.register();
        log.info("Done with accessing CustomerRegistrationService (autowire='byType')");

        log.info("Beginning with accessing CustomerRegistrationService (autowire='no')");
        CustomerRegistrationService customerRegistrationService_2 = (CustomerRegistrationService) context
                .getBean("customerRegistrationService_");
        try {
            customerRegistrationService_2.setAccountNumber("account_2");
            customerRegistrationService_2.setAddress("address_2");
            customerRegistrationService_2
                    .setDebitCardNumber("debitCardNumber_2");
            customerRegistrationService_2.register();
        } catch (Exception e) {
            log.error("Exception : " + e.toString());
        }
        log.info("Done with accessing CustomerRegistrationService (autowire='no')");

        log.info("Beginning with accessing FixedDepositService (autowire='byName')");
        FixedDepositService fixedDepositService = context
                .getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(1, 1000,
                12, "someemail@somedomain.com"));
        log.info("Done with accessing FixedDepositService (autowire='byName')");

        log.info("Beginning with accessing AccountStatementService (autowire-candidate='false')");
        try {
            AccountStatementService accountStatementService = context
                    .getBean(AccountStatementService.class);
            accountStatementService.getAccountStatement(new Date(), new Date());
        } catch (Exception e) {
            log.error("Exception : " + e.toString());
        }
        log.info("Done with accessing AccountStatementService (autowire-candidate='false')");
    }
}
