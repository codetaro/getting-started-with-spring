package chapter04.bankapp_autowiring.service;

import chapter04.bankapp_dependencies.dao.CustomerRegistrationDao;
import chapter04.bankapp_dependencies.domain.CustomerRegistrationDetails;
import chapter04.bankapp_dependencies.service.CustomerRegistrationService;
import lombok.Getter;
import lombok.Setter;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    @Getter @Setter CustomerRegistrationDetails customerRegistrationDetails;
    @Getter @Setter private CustomerRegistrationDao customerRegistrationDao;

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
