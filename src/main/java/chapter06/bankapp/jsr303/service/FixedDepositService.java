package chapter06.bankapp.jsr303.service;

import chapter06.bankapp.jsr303.domain.FixedDepositDetails;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
}
