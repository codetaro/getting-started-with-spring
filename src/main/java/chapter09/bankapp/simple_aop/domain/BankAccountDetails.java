package chapter09.bankapp.simple_aop.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BankAccountDetails {
    private int accountId;
    private int balanceAmount;
    private Date lastTransactionTimestamp;
}
