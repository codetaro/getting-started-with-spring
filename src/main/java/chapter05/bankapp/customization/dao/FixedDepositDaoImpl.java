package chapter05.bankapp.customization.dao;

import chapter05.bankapp.customization.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;

@Log4j
public class FixedDepositDaoImpl implements FixedDepositDao {
    private DatabaseConnection connection;

    public FixedDepositDaoImpl() {
        log.info("FixedDepositDaoImpl's constructor invoked");
    }

    public void initializeDbConnection() {
        log.info("FixedDepositDaoImpl's initializeDbConnection method invoked");
        connection = DatabaseConnection.getInstance();
    }

    public boolean releaseDbConnection() {
        log.info("FixedDepositDaoImpl's releaseDbConnection method invoked");
        return true;
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        log.info("FixedDepositDaoImpl's createFixedDeposit method invoked");
        return true;
    }
}
