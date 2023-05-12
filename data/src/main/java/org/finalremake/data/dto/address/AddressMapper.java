package org.finalremake.data.dto.address;

import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.model.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AbstractDTO.class})
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressResponseDTO getAddressResponseDTO(Address address);
}
