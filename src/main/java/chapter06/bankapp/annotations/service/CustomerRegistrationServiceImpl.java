package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.dao.CustomerRegistrationDao;
import chapter06.bankapp.annotations.domain.CustomerRegistrationDetails;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerRegistrationService")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    @Getter private CustomerRegistrationDetails customerRegistrationDetails;

    @Autowired
    @Getter
    private CustomerRegistrationDao customerRegistrationDao;

    @Autowired
    public void obtainCustomerRegistrationDetails(
            CustomerRegistrationDetails customerRegistrationDetails) {
        this.customerRegistrationDetails = customerRegistrationDetails;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        customerRegistrationDetails.setAccountNumber(accountNumber);
    }

    @Override
    public void setAddress(String address) {
        customerRegistrationDetails.setAddress(address);
    }

    @Override
    public void setDebitCardNumber(String cardNumber) {
        customerRegistrationDetails.setCardNumber(cardNumber);
    }

    @Override
    public void register() {
        customerRegistrationDao.registerCustomer(customerRegistrationDetails);
    }
}
