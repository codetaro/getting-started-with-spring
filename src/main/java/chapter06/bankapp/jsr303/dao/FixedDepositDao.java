package chapter06.bankapp.jsr303.dao;

import chapter06.bankapp.jsr303.domain.FixedDepositDetails;

public interface FixedDepositDao {
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
