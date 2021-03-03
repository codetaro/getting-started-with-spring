package chapter06.bankapp.jsr303;

import chapter06.bankapp.jsr303.domain.FixedDepositDetails;
import chapter06.bankapp.jsr303.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter06/bankapp/jsr303/applicationContext.xml");

        log.info("Validating FixedDepositDetails object using Spring Validation API");
        FixedDepositService fixedDepositService = (FixedDepositService) context
                .getBean("fixedDepositService");
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 0, 12, "someemail@somedomain.com"));
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));

        log.info("Validating FixedDepositDetails object using JSR 303's Validator");
        FixedDepositService fixedDepositServiceJsr303 = (FixedDepositService) context
                .getBean("fixedDepositService");
        fixedDepositServiceJsr303.createFixedDeposit(new FixedDepositDetails(
                1, 0, 12, "someemail@somedomain.com"));
        fixedDepositServiceJsr303.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));
    }
}
