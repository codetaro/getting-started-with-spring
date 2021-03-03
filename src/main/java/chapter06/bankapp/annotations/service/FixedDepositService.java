package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.domain.FixedDepositDetails;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
}
