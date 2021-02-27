package chapter05.bankapp.customization.dao;

import chapter05.bankapp.customization.domain.FixedDepositDetails;

public interface FixedDepositDao {
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
