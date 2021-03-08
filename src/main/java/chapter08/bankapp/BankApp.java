package chapter08.bankapp;

import chapter08.bankapp.domain.BankAccountDetails;
import chapter08.bankapp.domain.FixedDepositDetails;
import chapter08.bankapp.service.BankAccountService;
import chapter08.bankapp.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.*;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter08/bankapp/applicationContext.xml");

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());
        int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);
        log.info("Created bank account with id - " + bankAccountId);

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setActive("N");
        fdd.setBankAccountId(bankAccountId);
        fdd.setFdCreationDate(new Date());
        fdd.setFdAmount(500);
        fdd.setTenure(12);
        fdd.setEmail("dennis.yuan@hotmail.com");
        fixedDepositService.createFixedDeposit(fdd);

        Thread.sleep(5000);
        fixedDepositService.findFixedDepositsByBankAccount(bankAccountId);
        fixedDepositService.findFixedDepositsByBankAccount(bankAccountId);
        fixedDepositService.createFixedDeposit(fdd);

        Thread.sleep(5000);
        List<FixedDepositDetails> fixedDepositDetailsList = fixedDepositService
                .findFixedDepositsByBankAccount(bankAccountId);

        for (FixedDepositDetails detail : fixedDepositDetailsList) {
            fixedDepositService.getFixedDeposit(detail.getFixedDepositId());
        }

        for (FixedDepositDetails detail : fixedDepositDetailsList) {
            fixedDepositService.getFixedDepositFromCache(detail.getFixedDepositId());
        }

        Thread.sleep(5000);
        Map<String, DefaultMessageListenerContainer> containers = context
                .getBeansOfType(DefaultMessageListenerContainer.class);
        Set<String> keySet = containers.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            DefaultMessageListenerContainer container = containers.get(iterator.next());
            System.out.println("Container - " + container);
            container.destroy();
        }

        ThreadPoolTaskScheduler poolTaskScheduler = (ThreadPoolTaskScheduler) context
                .getBean("emailScheduler");
        poolTaskScheduler.destroy();
        BrokerService brokerService = context.getBean(BrokerService.class);
        brokerService.stop();
    }
}
