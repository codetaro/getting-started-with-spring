package chapter03.bankapp_inheritance.dao;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.dao.FixedDepositDao;
import chapter03.bankapp_inheritance.utils.DatabaseOperations;
import org.apache.log4j.Logger;

public class FixedDepositDaoImpl implements FixedDepositDao {
    private static Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);
    private DatabaseOperations databaseOperations;

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public FixedDepositDaoImpl() {
        logger.info("initializing");
    }

    @Override
    public FixedDepositDetails getFixedDepositDetails(long id) {
        return databaseOperations.loadFd(id);
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return databaseOperations.saveFd(fdd);
    }
}
