package chapter09.bankapp.simple_aop.service;

import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
