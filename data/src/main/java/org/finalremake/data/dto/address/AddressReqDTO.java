package org.finalremake.data.dto.address;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddressReqDTO {
    @NotNull String address;
    @NotNull String country;
    @NotNull String city;
    @NotNull Integer customerId;
}
