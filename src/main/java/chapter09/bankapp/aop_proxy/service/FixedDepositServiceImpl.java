package chapter09.bankapp.aop_proxy.service;

import chapter09.bankapp.aop_proxy.dao.FixedDepositDao;
import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service(value = "fixedDepositService")
@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        log.info("createFixedDeposit method invoked");
        fixedDepositDao.createFixedDeposit(new FixedDepositDetails(1, 100, 12, "somedomain@someemail.com"));
    }

    @Override
    @CachePut(value = {"fixedDeposit"}, key = "#fixedDepositId")
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        log.info("getFixedDeposit method invoked with fixedDepositId "
                + fixedDepositId);
        return fixedDepositDao.getFixedDeposit(fixedDepositId);
    }
}
