package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.FixedDepositDetails;

public interface FixedDepositDao {
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
