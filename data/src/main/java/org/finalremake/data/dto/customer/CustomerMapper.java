package org.finalremake.data.dto.customer;

import org.finalremake.data.model.customer.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO getCustomerResponseDTO(Customer customer);
}
