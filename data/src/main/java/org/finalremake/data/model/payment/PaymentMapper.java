package org.finalremake.data.model.payment;

import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponseDTO getPaymentResponseDTO(Payment payment);
}
