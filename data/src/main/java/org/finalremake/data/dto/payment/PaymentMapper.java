package org.finalremake.data.dto.payment;

import org.finalremake.data.model.payment.CreditCardPayment;
import org.finalremake.data.model.payment.DebitCardPayment;
import org.finalremake.data.model.payment.Payment;
import org.finalremake.data.model.payment.PaypalPayment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponseDTO getPaymentResponseDTO(Payment payment);
    CreditCardPaymentResponseDTO getCreditCardPaymentResponseDTO(CreditCardPayment creditCardPayment);
    DebitCardPaymentResponseDTO getDebitCardPaymentResponseDTO(DebitCardPayment debitCardPayment);
    PaypalPaymentResponseDTO getPaypalPaymentResponseDTO(PaypalPayment paypalPayment);
}
