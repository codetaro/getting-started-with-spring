package chapter04.bankapp_autowiring.service;

import chapter04.bankapp_dependencies.dao.CustomerRequestDao;
import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerRequestServiceImpl implements CustomerRequestService {
    private CustomerRequestDetails customerRequestDetails;
    private CustomerRequestDao customerRequestDao;

    @Override
    public void submitRequest(String requestType, String requestDescription) {
        customerRequestDao.submitRequest(customerRequestDetails);
    }
}
