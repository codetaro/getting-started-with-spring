package chapter14.bankapp.dao;

import chapter14.bankapp.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositDao {
    List<FixedDepositDetails> getFixedDeposits(String user);

    List<FixedDepositDetails> getAllFixedDeposits();

    void saveFixedDeposit(FixedDepositDetails fixedDepositDetails);

    void closeFixedDeposit(int fixedDepositId);

    FixedDepositDetails getFixedDeposit(int fixedDepositId);

    void editFixedDeposit(FixedDepositDetails fixedDepositDetails);
}
