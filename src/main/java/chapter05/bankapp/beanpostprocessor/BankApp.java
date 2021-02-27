package chapter05.bankapp.beanpostprocessor;

import chapter05.bankapp.customization.domain.FixedDepositDetails;
import chapter05.bankapp.customization.service.FixedDepositService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter05/bankapp/beanpostprocessor/applicationContext.xml");
        context.registerShutdownHook();

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));

        context.getBean("eventSenderFactory");
        context.getBean("eventSenderFactory");
    }
}
