package chapter05.bankapp.customization.service;

import chapter05.bankapp.customization.dao.FixedDepositDao;
import chapter05.bankapp.customization.domain.FixedDepositDetails;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {
    private FixedDepositDao myFixedDepositDao;

    public void setMyFixedDepositDao(FixedDepositDao myFixedDepositDao) {
        log.info("FixedDepositServiceImpl's setMyFixedDepositDao method invoked");
        this.myFixedDepositDao = myFixedDepositDao;
    }

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        myFixedDepositDao.createFixedDeposit(fdd);
    }
}
