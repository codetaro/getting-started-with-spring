package chapter06.bankapp.validator_interface.service;

import chapter06.bankapp.annotations.dao.FixedDepositDao;
import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import chapter06.bankapp.annotations.service.FixedDepositService;
import chapter06.bankapp.validator_interface.validator.FixedDepositValidator;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;

@Service(value = "fixedDepositService")
@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    @Qualifier(value = "myFixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        // a default implementation of Errors interface provided out-of-the-box by Spring
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(
                fdd, "Errors");
        FixedDepositValidator validator = new FixedDepositValidator();
        validator.validate(fdd, bindingResult);
        if (bindingResult.getErrorCount() > 0) {
            log.error("Errors were found while validating FixedDepositDetails instance");
        } else {
            myFixedDepositDao.createFixedDeposit(fdd);
            log.info("Created fixed deposit");
        }
    }
}
