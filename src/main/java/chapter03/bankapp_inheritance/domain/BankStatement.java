package chapter03.bankapp_inheritance.domain;

import java.util.Date;

public class BankStatement {
    private Date transactionDate;
    private double amount;
    private String transactionType;
    private String referenceNumber;

    public BankStatement() {
    }

    public BankStatement(Date transactionDate, double amount, String transactionType, String referenceNumber) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
        this.referenceNumber = referenceNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public BankStatement setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public BankStatement setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BankStatement setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public BankStatement setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Your mini statement: Amount = " + this.getAmount() + ", " +
               "Ref. number = " + this.getReferenceNumber() + ", " +
               "Transaction Type = " + this.getTransactionType() + ", " +
               "Transaction Date = " + this.getTransactionDate();
    }
}
