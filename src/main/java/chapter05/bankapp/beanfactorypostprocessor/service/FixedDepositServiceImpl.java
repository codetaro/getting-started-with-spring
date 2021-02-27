package chapter05.bankapp.beanfactorypostprocessor.service;

import chapter05.bankapp.beanfactorypostprocessor.dao.FixedDepositDao;
import lombok.Setter;

public class FixedDepositServiceImpl implements FixedDepositService {
    @Setter private FixedDepositDao fixedDepositDao;

    @Override
    public void createFixedDeposit(long id, float depositAmount, int tenure, String email) throws Exception {
        fixedDepositDao.createFixedDeposit(id, depositAmount, tenure, email);
    }
}
