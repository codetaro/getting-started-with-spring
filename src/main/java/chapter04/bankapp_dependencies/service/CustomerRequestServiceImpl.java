package chapter04.bankapp_dependencies.service;

import chapter04.bankapp_dependencies.dao.CustomerRequestDao;
import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;
import lombok.extern.log4j.Log4j;

import java.beans.ConstructorProperties;

@Log4j
public class CustomerRequestServiceImpl implements CustomerRequestService {
    private CustomerRequestDetails customerRequestDetails;
    private CustomerRequestDao customerRequestDao;

    public CustomerRequestServiceImpl(
            CustomerRequestDetails customerRequestDetails,
            CustomerRequestDao customerRequestDao) {
        log.info("Created CustomerRequestServiceImpl instance");
        this.customerRequestDetails = customerRequestDetails;
        this.customerRequestDao = customerRequestDao;
    }

    @Override
    public void submitRequest(String requestType, String requestDescription) {

    }
}
