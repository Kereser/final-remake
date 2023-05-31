package org.finalremake.data.model.payment;

import org.finalremake.data.dto.payment.CreditCardPaymentResponseDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentResponseDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentResponseDTO;
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
