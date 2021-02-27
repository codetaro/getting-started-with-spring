package chapter05.bankapp.jsr250.dao;

import chapter05.bankapp.customization.dao.DatabaseConnection;
import chapter05.bankapp.customization.dao.FixedDepositDao;
import chapter05.bankapp.customization.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j
public class FixedDepositDaoImpl implements FixedDepositDao {
    private DatabaseConnection connection;

    public FixedDepositDaoImpl() {
        log.info("FixedDepositDaoImpl's constructor invoked");
    }

    @PostConstruct
    public void initializeDbConnection() {
        log.info("FixedDepositDaoImpl's initializeDbConnection method invoked");
        connection = DatabaseConnection.getInstance();
    }

    @PreDestroy
    public void releaseDbConnection() {
        log.info("FixedDepositDaoImpl's releaseDbConnection method invoked");
        connection.releaseConnection();
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        log.info("FixedDepositDaoImpl's createFixedDeposit method invoked");
        return true;
    }
}
