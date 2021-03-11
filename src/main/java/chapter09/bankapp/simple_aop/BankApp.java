package chapter09.bankapp.simple_aop;

import chapter09.bankapp.simple_aop.domain.BankAccountDetails;
import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;
import chapter09.bankapp.simple_aop.service.BankAccountService;
import chapter09.bankapp.simple_aop.service.FixedDepositService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class BankApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter09/bankapp/simple_aop/applicationContext.xml");

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());
        bankAccountService.createBankAccount(bankAccountDetails);

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 1000, 12, "someemail@somedomain.com"));
    }
}
