package chapter04.bankapp_dependencies.service;

import chapter04.bankapp_dependencies.domain.FixedDepositDetails;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
}
