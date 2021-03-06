package chapter07.bankapp.tx_jdbc;

import chapter07.bankapp.jdbc.domain.BankAccountDetails;
import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import chapter07.bankapp.jdbc.service.BankAccountService;
import chapter07.bankapp.jdbc.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter07/bankapp/tx_jdbc/applicationContext.xml");

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);

        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());

        int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);
        log.info("Created bank account (with balance amount 1000) with id - "
                + bankAccountId);

        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setActive("Y");
        fdd.setFdAmount(1500);
        fdd.setBankAccountId(bankAccountId);
        fdd.setFdCreationDate(new Date());
        fdd.setTenure(12);

        int fixedDepositId = fixedDepositService.createFixedDeposit(fdd);
        log.info("Created fixed deposit (for 1500 amount) with id - "
                + fixedDepositId
                + " Check FIXED_DEPOSIT_DETAILS table to verify the transaction was committed or rolledback.");
    }
}
