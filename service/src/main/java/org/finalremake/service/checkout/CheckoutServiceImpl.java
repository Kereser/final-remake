package org.finalremake.service.checkout;

import org.finalremake.data.dto.checkout.CheckoutReqAndReqUpdateDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Override
    public CheckoutResponseDTO createCheckout(Map<String, Long> params, CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO) {
        return null;
    }

    @Override
    public void deleteCheckout(Long checkoutId) {

    }

    @Override
    public CheckoutResponseDTO getCheckout(Long checkoutId) {
        return null;
    }

    @Override
    public CheckoutResponseDTO updateCheckout(Long checkoutId, Map<String, Long> allParams, CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO) {
        return null;
    }
}
