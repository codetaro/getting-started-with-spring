package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.FixedDepositDetails;

public class FixedDepositDaoImpl implements FixedDepositDao {
    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return true;
    }
}
