package org.finalremake.service.payment;

import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;

public interface PaymentService {
    void deletePayment(Long paymentId);
    PaymentResponseDTO createCreditCardPayment(CreditCardPaymentReqDTO creditCardPaymentReqDTO, Long customerId);
    PaymentResponseDTO createCreditCardPayment(DebitCardPaymentReqDTO debitCardPaymentReqDTO, Long customerId);
    PaymentResponseDTO createCreditCardPayment(PaypalPaymentReqDTO paypalPaymentReqDTO, Long customerId);
}
