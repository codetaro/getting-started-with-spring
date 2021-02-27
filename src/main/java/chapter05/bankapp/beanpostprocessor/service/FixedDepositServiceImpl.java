package chapter05.bankapp.beanpostprocessor.service;

import chapter05.bankapp.beanpostprocessor.common.DependencyResolver;
import chapter05.bankapp.beanpostprocessor.common.MyApplicationContext;
import chapter05.bankapp.customization.dao.FixedDepositDao;
import chapter05.bankapp.customization.domain.FixedDepositDetails;
import chapter05.bankapp.customization.service.FixedDepositService;
import lombok.extern.log4j.Log4j;

@Log4j
public class FixedDepositServiceImpl implements FixedDepositService, DependencyResolver {
    private FixedDepositDao fixedDepositDao;

    public FixedDepositServiceImpl() {
        log.info("FixedDepositServiceImpl's constructor invoked");
    }

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        fixedDepositDao.createFixedDeposit(fdd);
    }

    @Override
    public void resolveDependency(MyApplicationContext myApplicationContext) {
        log.info("Resolving dependencies of FixedDepositServiceImpl instance");
        fixedDepositDao = myApplicationContext.getBean(FixedDepositDao.class);
    }
}
