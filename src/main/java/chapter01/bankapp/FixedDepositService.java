package chapter01.bankapp;

import org.apache.log4j.Logger;

public class FixedDepositService {
    private static Logger logger = Logger.getLogger(FixedDepositService.class);
    private FixedDepositDao fixedDepositDao;

    public FixedDepositService() {
        logger.info("initializing");
    }

    public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
        logger.info("Setting fixedDepositDao property");
        this.fixedDepositDao = fixedDepositDao;
    }

    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixedDepositDao.getFixedDepositDetails(id);
    }

    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return fixedDepositDao.createFixedDeposit(fdd);
    }
}
