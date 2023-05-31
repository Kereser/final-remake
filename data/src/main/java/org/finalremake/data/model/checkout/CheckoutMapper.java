package org.finalremake.data.model.checkout;

import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.data.model.checkout.Checkout;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {
    CheckoutResponseDTO getCheckoutResponseDTO(Checkout checkout);
}
