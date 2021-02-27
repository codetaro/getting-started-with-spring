package chapter05.bankapp.beanpostprocessor.dao;

import chapter05.bankapp.beanpostprocessor.common.InstanceValidator;
import chapter05.bankapp.customization.dao.DatabaseConnection;
import chapter05.bankapp.customization.dao.FixedDepositDao;
import chapter05.bankapp.customization.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import sun.security.jca.GetInstance;

@Log4j
public class FixedDepositDaoImpl implements FixedDepositDao, InstanceValidator {
    private DatabaseConnection connection;

    public FixedDepositDaoImpl() {
        log.info("FixedDepositDaoImpl's constructor invoked");
    }

    public void initializeDbConnection() {
        log.info("FixedDepositDaoImpl's initializeDbConnection method invoked");
        connection = DatabaseConnection.getInstance();
    }

    public void releaseDbConnection() {
        log.info("FixedDepositDaoImpl's releaseDbConnection method invoked");
        connection.releaseConnection();
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        log.info("FixedDepositDaoImpl's createFixedDeposit method invoked");
        return true;
    }

    @Override
    public void validateInstance() {
        log.info("Validating FixedDepositDaoImpl instance");
        if (connection == null) {
            log.error("Failed to obtain DatabaseConnection instance");
        }
    }
}
