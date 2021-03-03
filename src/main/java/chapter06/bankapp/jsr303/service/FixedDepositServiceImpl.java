package chapter06.bankapp.jsr303.service;

import chapter06.bankapp.jsr303.dao.FixedDepositDao;
import chapter06.bankapp.jsr303.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

@Service(value = "fixedDepositService")
@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private Validator validator;

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(fdd, "Errors");
        validator.validate(fdd, bindingResult);
        if (bindingResult.getErrorCount() > 0) {
            log.error("Errors were found while validating FixedDepositDetails instance");
        } else {
            myFixedDepositDao.createFixedDeposit(fdd);
            log.info("Created fixed deposit");
        }
    }
}
