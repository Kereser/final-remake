package org.finalremake.data.model.address;

import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.model.address.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDTO getAddressResponseDTO(Address address);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address getUpdatedAddress (AddressReqUpdateDTO addressReqUpdateDTO, @MappingTarget Address address);
}
