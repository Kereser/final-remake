package org.finalremake.data.respository.payment;

import org.finalremake.data.model.payment.DebitCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardPaymentRepository extends JpaRepository<DebitCardPayment, Long> {
}
