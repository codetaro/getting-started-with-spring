package chapter03.bankapp_factorybean.dao;

import chapter01.bankapp.FixedDepositDetails;

public class FixedDepositDaoImpl implements FixedDepositDao {
    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        // -- save the fixed deposits and then return true
        return true;
    }
}
