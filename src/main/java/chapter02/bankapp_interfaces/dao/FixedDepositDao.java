package chapter02.bankapp_interfaces.dao;

import chapter01.bankapp.FixedDepositDetails;

public interface FixedDepositDao {
    FixedDepositDetails getFixedDepositDetails(long id);

    boolean createFixedDeposit(FixedDepositDetails fdd);
}
