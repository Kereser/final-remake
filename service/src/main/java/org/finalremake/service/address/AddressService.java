package org.finalremake.service.address;


import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;

import java.util.List;

public interface AddressService {
    AddressResponseDTO getOneAddress(Long id);
    void deleteAddress(Long id);
    List<AddressResponseDTO> getAllAddresses();
    List<AddressResponseDTO> getAllCustomerAddresses(Long customerId);
    AddressResponseDTO createAddress(AddressReqDTO addressReqDTO, Long customerId);
    AddressResponseDTO updateAddress(AddressReqDTO addressReqDTO, Long addressId);
}
