package org.finalremake.data.model.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalPaymentRepository extends JpaRepository<PaypalPayment, Long> {
}
