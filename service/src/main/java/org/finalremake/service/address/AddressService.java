package org.finalremake.service.address;


import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;

import java.util.List;

public interface AddressService {
    AddressResponseDTO getAddress(Long id);
    void deleteAddress(Long id);
    List<AddressResponseDTO> getAddresses();
    List<AddressResponseDTO> getCustomerAddresses(Long customerId);
    AddressResponseDTO createAddress(AddressReqDTO addressReqDTO, Long customerId);
    AddressResponseDTO updateAddress(AddressReqUpdateDTO addressReqUpdateDTO, Long addressId);
}
