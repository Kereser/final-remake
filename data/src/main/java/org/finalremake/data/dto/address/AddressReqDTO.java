package org.finalremake.data.dto.address;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.model.customer.Customer;

@Builder
@Getter
@Setter
public class AddressReqDTO {
    @NotNull String direction;
    @NotNull String country;
    @NotNull String city;
    @Nullable Customer customer;
}
