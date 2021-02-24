package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.CustomerRegistrationDetails;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerRegistrationDaoImpl implements CustomerRegistrationDao {

    public CustomerRegistrationDaoImpl() {
        log.info("Created CustomerRegistrationDaoImpl instance");
    }

    @Override
    public void registerCustomer(CustomerRegistrationDetails customerRegistrationDetails) {

    }
}
