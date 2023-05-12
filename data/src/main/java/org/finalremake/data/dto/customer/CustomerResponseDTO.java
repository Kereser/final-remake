package org.finalremake.data.dto.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;

import java.util.List;

@SuperBuilder
@Getter
@Setter
public class CustomerResponseDTO extends AbstractDTO {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Integer age;
    private List<AddressResponseDTO> addresses;
    private List<PaymentResponseDTO> payments;
}
