package chapter03.bankapp_factorybean.dao;

import chapter01.bankapp.FixedDepositDetails;

public interface FixedDepositDao {
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
