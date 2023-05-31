package org.finalremake.data.respository.payment;

import org.finalremake.data.model.payment.CreditCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {
}
