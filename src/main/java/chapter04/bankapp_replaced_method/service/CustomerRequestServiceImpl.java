package chapter04.bankapp_replaced_method.service;

import chapter04.bankapp_dependencies.dao.CustomerRequestDao;
import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerRequestServiceImpl implements CustomerRequestService {
    private CustomerRequestDao customerRequestDao;

    public CustomerRequestServiceImpl(CustomerRequestDao customerRequestDao) {
        log.info("Created CustomerRequestServiceImpl instance");
        this.customerRequestDao = customerRequestDao;
    }

    public Object getMyBean(String beanName) {
        return null;
    }

    @Override
    public void submitRequest(String requestType, String requestDescription) {
        CustomerRequestDetails customerRequestDetails = (CustomerRequestDetails) getMyBean("customerRequestDetails");
        customerRequestDetails.setType(requestType);
        customerRequestDetails.setDescription(requestDescription);
        customerRequestDao.submitRequest(customerRequestDetails);
    }
}
