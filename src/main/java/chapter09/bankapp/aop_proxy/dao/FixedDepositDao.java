package chapter09.bankapp.aop_proxy.dao;

import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;

public interface FixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fdd);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
