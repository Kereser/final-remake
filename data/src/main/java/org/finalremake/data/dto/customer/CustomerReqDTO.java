package org.finalremake.data.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerReqDTO {
    private String name;
    @NotNull @Size(min = 3, max =18) private String surname;
    @Email private String email;
    private String phone;
    private Integer age;
}
