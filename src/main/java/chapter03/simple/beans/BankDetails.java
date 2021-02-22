package chapter03.simple.beans;

import java.util.Currency;
import java.util.Date;
import java.util.Properties;

public class BankDetails {
    private String bankName;
    private byte[] bankPrimaryBusiness;
    private char[] headOfficeAddress;
    private char privateBank;
    private Currency primaryCurrency;
    private Date dateOfInception;
    private Properties branchAddresses;

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankPrimaryBusiness(byte[] bankPrimaryBusiness) {
        this.bankPrimaryBusiness = bankPrimaryBusiness;
    }

    public void setHeadOfficeAddress(char[] headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress;
    }

    public void setPrivateBank(char privateBank) {
        this.privateBank = privateBank;
    }

    public void setPrimaryCurrency(Currency primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public void setDateOfInception(Date dateOfInception) {
        this.dateOfInception = dateOfInception;
    }

    public void setBranchAddresses(Properties branchAddresses) {
        this.branchAddresses = branchAddresses;
    }

    @Override
    public String toString() {
        return "BankDetails ["
                + "bankName=" + bankName + ", "
                + "bankPrimaryBusiness=" + new String(bankPrimaryBusiness) + ", "
                + "headOfficeAddress=" + new String(headOfficeAddress) + ", "
                + "primaryCurrency=" + primaryCurrency + ", "
                + "dataOfInception=" + dateOfInception + ", "
                + "privateBank=" + privateBank + ", "
                + "branchAddresses=" + branchAddresses + "]";
    }
}
