package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.FixedDepositDetails;

public interface FixedDepositDao {
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
