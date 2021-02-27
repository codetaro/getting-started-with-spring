package chapter05.bankapp.beanfactorypostprocessor.dao;

import chapter01.bankapp.FixedDepositDetails;
import chapter05.bankapp.beanpostprocessor.common.InstanceValidator;
import chapter05.bankapp.customization.dao.DatabaseConnection;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class FixedDepositDaoImpl implements FixedDepositDao, InstanceValidator {
    @Setter private FixedDepositDetails fixedDepositDetails;
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
    public boolean createFixedDeposit(long id, float depositAmount, int tenure, String email) {
        fixedDepositDetails.setDepositAmount(depositAmount);
        fixedDepositDetails.setEmail(email);
        fixedDepositDetails.setId(id);
        fixedDepositDetails.setTenure(tenure);

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
