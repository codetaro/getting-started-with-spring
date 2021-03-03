package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.CustomerRegistrationDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

@Repository(value = "customerRegistrationDao")
@Log4j
public class CustomerRegistrationDaoImpl implements CustomerRegistrationDao {

    public CustomerRegistrationDaoImpl() {
        log.info("Created CustomerRegistrationDaoImpl instance");
    }

    @Override
    public void registerCustomer(CustomerRegistrationDetails customerRegistrationDetails) {

    }
}
