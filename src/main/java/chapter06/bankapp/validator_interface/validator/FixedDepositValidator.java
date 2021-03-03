package chapter06.bankapp.validator_interface.validator;

import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FixedDepositValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // check if the supplied object instance is of type FixedDepositDetails
        return FixedDepositDetails.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FixedDepositDetails fdd = (FixedDepositDetails) target;
        if (fdd.getDepositAmount() == 0) {
            errors.reject("zeroDepositAmount");
        }
    }
}
