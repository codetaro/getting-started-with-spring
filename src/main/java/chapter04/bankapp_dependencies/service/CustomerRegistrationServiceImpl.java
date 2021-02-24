package chapter04.bankapp_dependencies.service;

import chapter04.bankapp_dependencies.dao.CustomerRegistrationDao;
import chapter04.bankapp_dependencies.domain.CustomerRegistrationDetails;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    private CustomerRegistrationDetails customerRegistrationDetails;
    private CustomerRegistrationDao customerRegistrationDao;

    public CustomerRegistrationServiceImpl(CustomerRegistrationDetails customerRegistrationDetails, CustomerRegistrationDao customerRegistrationDao) {
        this.customerRegistrationDetails = customerRegistrationDetails;
        this.customerRegistrationDao = customerRegistrationDao;
        log.info("Created CustomerRegistrationServiceImpl instance");
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
