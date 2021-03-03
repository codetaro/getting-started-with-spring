package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.CustomerRequestDetails;

public interface CustomerRequestDao {
    void submitRequest(CustomerRequestDetails userRequestDetails);
}
