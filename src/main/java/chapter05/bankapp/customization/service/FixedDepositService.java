package chapter05.bankapp.customization.service;

import chapter05.bankapp.customization.domain.FixedDepositDetails;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
}
