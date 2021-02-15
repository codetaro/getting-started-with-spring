package chapter02.bankapp_interfaces.service;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.dao.FixedDepositDao;
import org.apache.log4j.Logger;

public class FixedDepositServiceImpl implements FixedDepositService {
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);

    private FixedDepositDao fixedDepositDao;

    public FixedDepositServiceImpl() {
        logger.info("initializing");
    }

    @Override
    public FixedDepositDao getFixedDepositDao() {
        return fixedDepositDao;
    }

    public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
        logger.info("Setting fixedDepositDao property");
        this.fixedDepositDao = fixedDepositDao;
    }

    @Override
    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixedDepositDao.getFixedDepositDetails(id);
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return fixedDepositDao.createFixedDeposit(fdd);
    }
}
