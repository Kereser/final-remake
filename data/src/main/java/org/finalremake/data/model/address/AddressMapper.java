package org.finalremake.data.model.address;

import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.model.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDTO getAddressResponseDTO(Address address);
}
