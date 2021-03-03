package chapter06.bankapp.jsr330.service;

import chapter06.bankapp.annotations.dao.FixedDepositDao;
import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import chapter06.bankapp.annotations.service.FixedDepositService;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Inject
    @Named(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        myFixedDepositDao.createFixedDeposit(fdd);
    }
}
