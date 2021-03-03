package chapter06.bankapp.configuration;

import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import chapter06.bankapp.annotations.service.AccountStatementService;
import chapter06.bankapp.annotations.service.CustomerRegistrationService;
import chapter06.bankapp.annotations.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                BankAppConfiguration.class);

        log.info("----------> Beginning with accessing CustomerRegistrationService");
        CustomerRegistrationService customerRegistrationService_1 = (CustomerRegistrationService) context
                .getBean("customerRegistrationService");
        customerRegistrationService_1.setAccountNumber("account_1");
        customerRegistrationService_1.setAddress("address_1");
        customerRegistrationService_1.setDebitCardNumber("debitCardNumber_1");
        customerRegistrationService_1.register();
        log.info("----------> Done with accessing CustomerRegistrationService");

        log.info("----------> Beginning with accessing FixedDepositService");
        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));
        log.info("----------> Done with accessing FixedDepositService");

        log.info("----------> Beginning with accessing AccountStatementService");
        try {
            AccountStatementService accountStatementService = context
                    .getBean(AccountStatementService.class);
            accountStatementService.getAccountStatement(new Date(), new Date());
        } catch (Exception e) {
            log.error("Exception : " + e.toString());
        }
        log.info("----------> Done with accessing AccountStatementService");
    }
}
