package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.CustomerRegistrationDetails;

public interface CustomerRegistrationDao {
    void registerCustomer(CustomerRegistrationDetails customerRegistrationDetails);
}
