package chapter12.webservice.service;

import chapter12.webservice.dao.FixedDepositDao;
import chapter12.webservice.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {
    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Override
    public List<FixedDepositDetails> getFixedDeposits() {
        return fixedDepositDao.getFixedDeposits();
    }

    @Override
    public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        fixedDepositDao.saveFixedDeposit(fixedDepositDetails);
    }

    @Override
    public void closeFixedDeposit(int fixedDepositId) {
        fixedDepositDao.closeFixedDeposit(fixedDepositId);
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return fixedDepositDao.getFixedDeposit(fixedDepositId);
    }

    @Override
    public void editFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        fixedDepositDao.editFixedDeposit(fixedDepositDetails);
    }
}
