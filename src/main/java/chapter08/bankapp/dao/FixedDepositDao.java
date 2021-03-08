package chapter08.bankapp.dao;

import chapter08.bankapp.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fdd);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
    List<FixedDepositDetails> getInactiveFixedDeposits();
    void setFixedDepositsAsActive(List<FixedDepositDetails> fds);
    List<FixedDepositDetails> findFixedDepositsByBankAccount(int bankAccountId);
}
