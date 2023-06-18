package org.finalremake.service.customer;

import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO getCustomer(Long customerId);
    void deleteCustomer(Long customerId);
    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO createCustomer(CustomerReqDTO customerReqDTO);
    CustomerResponseDTO updateCustomer(CustomerReqUpdateDTO customerUpdateDTO, Long id);
}
