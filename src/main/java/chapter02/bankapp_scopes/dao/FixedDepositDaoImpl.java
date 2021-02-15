package chapter02.bankapp_scopes.dao;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.dao.FixedDepositDao;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class FixedDepositDaoImpl implements FixedDepositDao {
    private static Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);

    private Map<Long, FixedDepositDetails> fixDeposits = new HashMap<>();

    public FixedDepositDaoImpl() {
        logger.info("initializing");
    }

    @Override
    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixDeposits.get(id);
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        fixDeposits.put(fdd.getId(), fdd);
        return true;
    }
}
