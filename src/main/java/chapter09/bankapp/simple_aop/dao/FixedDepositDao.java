package chapter09.bankapp.simple_aop.dao;

import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;

public interface FixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fdd);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
