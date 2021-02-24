package chapter04.bankapp_context_aware.service;

import chapter04.bankapp_dependencies.dao.CustomerRequestDao;
import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Log4j
public class CustomerRequestServiceContextAwareImpl implements
        CustomerRequestService, ApplicationContextAware {
    private CustomerRequestDao customerRequestDao;
    private ApplicationContext applicationContext;

    public CustomerRequestServiceContextAwareImpl(CustomerRequestDao customerRequestDao) {
        log.info("Created CustomerRequestServiceContextAwareImpl instance");
        this.customerRequestDao = customerRequestDao;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void submitRequest(String requestType, String requestDescription) {
        CustomerRequestDetails customerRequestDetails = applicationContext
                .getBean(CustomerRequestDetails.class);
        customerRequestDetails.setType(requestType);
        customerRequestDetails.setDescription(requestDescription);
        customerRequestDao.submitRequest(customerRequestDetails);
    }
}
