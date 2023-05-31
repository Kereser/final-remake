package org.finalremake.data.respository.payment;

import org.finalremake.data.model.payment.PaypalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalPaymentRepository extends JpaRepository<PaypalPayment, Long> {
}
