package chapter06.bankapp.annotations.service;

import chapter06.bankapp.annotations.dao.CustomerRequestDao;
import chapter06.bankapp.annotations.domain.CustomerRequestDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerRequestService")
@Log4j
public class CustomerRequestServiceImpl implements CustomerRequestService {
    private CustomerRequestDetails customerRequestDetails;
    private CustomerRequestDao customerRequestDao;

    @Autowired
    public CustomerRequestServiceImpl(
            CustomerRequestDetails customerRequestDetails,
            CustomerRequestDao customerRequestDao) {
        log.info("Created CustomerRequestServiceImpl instance");
        this.customerRequestDetails = customerRequestDetails;
        this.customerRequestDao = customerRequestDao;
    }

    @Override
    public void submitRequest(String requestType, String requestDescription) {
        customerRequestDao.submitRequest(customerRequestDetails);
    }
}
