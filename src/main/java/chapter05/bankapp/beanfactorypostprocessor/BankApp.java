package chapter05.bankapp.beanfactorypostprocessor;

import chapter05.bankapp.beanfactorypostprocessor.service.FixedDepositService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter05/bankapp/beanfactorypostprocessor/applicationContext.xml");
        context.registerShutdownHook();

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(
                1, 1000, 12, "someemail@somedomain.com");
    }
}
