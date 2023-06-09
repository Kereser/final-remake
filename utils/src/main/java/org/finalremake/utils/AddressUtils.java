package org.finalremake.utils;

import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.model.address.Address;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AddressUtils {
    public static AddressResponseDTO getAddressResponseDTO1 () {
        return AddressResponseDTO.builder()
                .id(1L)
                .city("Bogota")
                .country("Colombia")
                .direction("Av 10 #34-34")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public static AddressResponseDTO getAddressResponseDTO2 () {
        return AddressResponseDTO.builder()
                .id(2L)
                .city("Bogota")
                .country("Colombia")
                .direction("Calle 100 #34-34")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public static AddressReqDTO getAddressReqDTO1 () {
        return AddressReqDTO.builder()
                .direction("Av 10 #34-34")
                .city("Bogota")
                .country("Colombia")
                .customer(null)
                .build();
    }

    public static AddressReqDTO getAddressReqDTO2 () {
        return AddressReqDTO.builder()
                .city("Bogota")
                .country("Colombia")
                .direction("Calle 100 #34-34")
                .customer(null)
                .build();
    }

    public static Address getAddress1() {
        return Address.builder()
                .id(1L)
                .city("Bogota")
                .country("Colombia")
                .direction("Av 10 #34-34")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomer1())
                .build();
    }

    public static Address getAddress2() {
        return Address.builder()
                .id(2L)
                .city("Bogota")
                .country("Colombia")
                .direction("Calle 100 #34-34")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomer2())
                .build();
    }

    public static AddressReqUpdateDTO getAddressReqUpdateDTO1() {
        return AddressReqUpdateDTO.builder()
                .city("Bogota")
                .country("Colombia")
                .direction("Calle 100 #34-34")
                .build();
    }
}
