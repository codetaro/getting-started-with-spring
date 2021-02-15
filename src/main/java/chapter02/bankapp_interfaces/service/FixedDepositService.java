package chapter02.bankapp_interfaces.service;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.dao.FixedDepositDao;

public interface FixedDepositService {
    FixedDepositDao getFixedDepositDao();

    FixedDepositDetails getFixedDepositDetails(long id);

    boolean createFixedDeposit(FixedDepositDetails fdd);
}
