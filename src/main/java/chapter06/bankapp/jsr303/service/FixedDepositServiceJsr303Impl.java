package chapter06.bankapp.jsr303.service;

import chapter06.bankapp.jsr303.dao.FixedDepositDao;
import chapter06.bankapp.jsr303.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

@Service(value = "fixedDepositServiceJsr303")
@Log4j
public class FixedDepositServiceJsr303Impl implements FixedDepositService {

    @Autowired
    private Validator validator;

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        Set<ConstraintViolation<FixedDepositDetails>> violations = validator.validate(fdd);
        Iterator<ConstraintViolation<FixedDepositDetails>> itr = violations.iterator();
        if (itr.hasNext()) {
            log.error("Errors were found while validating FixedDepositDetails instance");
        } else {
            myFixedDepositDao.createFixedDeposit(fdd);
            log.info("Created fixed deposit");
        }
    }
}
