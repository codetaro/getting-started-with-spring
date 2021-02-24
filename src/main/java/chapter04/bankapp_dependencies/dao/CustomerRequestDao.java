package chapter04.bankapp_dependencies.dao;

import chapter04.bankapp_dependencies.domain.CustomerRequestDetails;

public interface CustomerRequestDao {
    void submitRequest(CustomerRequestDetails userRequestDetails);
}
