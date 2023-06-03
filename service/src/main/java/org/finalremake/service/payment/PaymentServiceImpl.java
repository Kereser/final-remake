package org.finalremake.service.payment;

import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void deletePayment(Long paymentId) {}

    @Override
    public PaymentResponseDTO createCreditCardPayment(CreditCardPaymentReqDTO creditCardPaymentReqDTO, Long customerId) {
        return null;
    }

    @Override
    public PaymentResponseDTO createCreditCardPayment(DebitCardPaymentReqDTO debitCardPaymentReqDTO, Long customerId) {
        return null;
    }

    @Override
    public PaymentResponseDTO createCreditCardPayment(PaypalPaymentReqDTO paypalPaymentReqDTO, Long customerId) {
        return null;
    }
}
