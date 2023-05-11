package org.finalremake.data.dto.address;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@Getter
@Setter
public class AddressResponseDTO {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String direction;
    private String city;
    private String country;
}
