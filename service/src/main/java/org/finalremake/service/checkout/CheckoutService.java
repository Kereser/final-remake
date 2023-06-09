package org.finalremake.service.checkout;

import org.finalremake.data.dto.checkout.CheckoutReqAndReqUpdateDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;

import java.util.Map;

public interface CheckoutService {
    CheckoutResponseDTO createCheckout(Map<String, Long> params, CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO) ;
    void deleteCheckout(Long checkoutId);
    CheckoutResponseDTO getCheckout(Long checkoutId);
    CheckoutResponseDTO updateCheckout(Long checkoutId, Map<String, Long> allParams, CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO);
}
