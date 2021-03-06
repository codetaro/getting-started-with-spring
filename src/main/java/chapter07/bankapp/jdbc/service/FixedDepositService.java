package chapter07.bankapp.jdbc.service;

import chapter07.bankapp.jdbc.domain.FixedDepositDetails;

public interface FixedDepositService {
    int createFixedDeposit(FixedDepositDetails fdd) throws Exception;
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
