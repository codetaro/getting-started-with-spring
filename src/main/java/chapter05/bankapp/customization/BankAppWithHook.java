package chapter05.bankapp.customization;

import chapter05.bankapp.customization.domain.FixedDepositDetails;
import chapter05.bankapp.customization.service.FixedDepositService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankAppWithHook {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter05/bankapp/customization/applicationContext.xml");
        context.registerShutdownHook();
        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));
    }
}
