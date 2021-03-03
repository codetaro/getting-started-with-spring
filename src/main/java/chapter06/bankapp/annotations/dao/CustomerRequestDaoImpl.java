package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.CustomerRequestDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

@Repository(value = "customerRequestDao")
@Log4j
public class CustomerRequestDaoImpl implements CustomerRequestDao {

    public CustomerRequestDaoImpl() {
        log.info("Created CustomerRequestDaoImpl instance");
    }

    @Override
    public void submitRequest(CustomerRequestDetails userRequestDetails) {

    }
}
