package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.CustomerRegistrationDetails;

public interface CustomerRegistrationDao {
    void registerCustomer(CustomerRegistrationDetails customerRegistrationDetails);
}
