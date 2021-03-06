package chapter07.bankapp.jdbc.dao;

import chapter07.bankapp.jdbc.domain.FixedDepositDetails;

public interface FixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fdd);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
