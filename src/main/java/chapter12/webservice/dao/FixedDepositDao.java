package chapter12.webservice.dao;

import chapter12.webservice.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositDao {
    List<FixedDepositDetails> getFixedDeposits();

    void saveFixedDeposit(FixedDepositDetails fixedDepositDetails);

    void closeFixedDeposit(int fixedDepositId);

    FixedDepositDetails getFixedDeposit(int fixedDepositId);

    void editFixedDeposit(FixedDepositDetails fixedDepositDetails);
}
