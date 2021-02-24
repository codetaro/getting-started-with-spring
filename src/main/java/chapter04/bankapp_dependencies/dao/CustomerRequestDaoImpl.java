package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerRequestDaoImpl implements CustomerRequestDao {

    public CustomerRequestDaoImpl() {
        log.info("Created CustomerRequestDaoImpl instance");
    }

    @Override
    public void submitRequest(CustomerRequestDetails userRequestDetails) {

    }
}
