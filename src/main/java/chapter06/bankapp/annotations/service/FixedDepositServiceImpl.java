package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.dao.FixedDepositDao;
import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        myFixedDepositDao.createFixedDeposit(fdd);
    }
}
