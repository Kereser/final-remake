package org.finalremake.controller.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.model.address.Address;
import org.finalremake.service.address.AddressServiceImpl;
import org.finalremake.utils.AddressUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ContextConfiguration(classes = {AddressController.class})
public class AddressControllerTest {
    @MockBean
    private AddressServiceImpl addressServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private Address address;
    private AddressResponseDTO addressResponseDTO;
    private AddressReqDTO addressReqDTO;
    private AddressReqUpdateDTO addressReqUpdateDTO;

    @BeforeEach
    void init() {
        address = AddressUtils.getAddress1();
        addressReqDTO = AddressUtils.getAddressReqDTO1();
        addressResponseDTO = AddressUtils.getAddressResponseDTO1();
        addressReqUpdateDTO = AddressUtils.getAddressReqUpdateDTO1();
    }

    @Test
    void createAddress_CreateOneAddress_WhenValidInput() throws Exception {
        when(addressServiceImpl.createAddress(Mockito.any(AddressReqDTO.class), anyLong())).thenReturn(addressResponseDTO);

        mockMvc.perform(post("/addresses").content(objectMapper.writeValueAsString(addressReqDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.city").value(addressResponseDTO.getCity()))
                .andExpect(jsonPath("$.id").value(addressResponseDTO.getId()))
                .andExpect(status().isCreated());

    }

    @Nested
    class getAddresses {
        @Test
        void getAllAddresses_GetAll_WhenValidInput() throws Exception {
            when(addressServiceImpl.getAllAddresses()).thenReturn(new ArrayList<>(Arrays.asList(addressResponseDTO)));

            mockMvc.perform(get("/addresses"))
                    .andExpect(jsonPath("[0].city").value(addressResponseDTO.getCity()))
                    .andExpect(jsonPath("[0].id").value(addressResponseDTO.getId()))
                    .andExpect(status().isOk());
        }

        @Test
        void getOneAddress_GetOne_WhenValidId() throws Exception {
            when(addressServiceImpl.getOneAddress(anyLong())).thenReturn(addressResponseDTO);

            mockMvc.perform(get("/addresses/1"))
                    .andExpect(jsonPath("$.country").value(addressResponseDTO.getCountry()))
                    .andExpect(jsonPath("$.id").value(addressResponseDTO.getId()))
                    .andExpect(status().isFound());
        }
    }

    @Test
    void deleteAddress_DeleteOneAddress_WhenValidId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/addresses/1")).andReturn();

        assertThat(mvcResult.getResponse().getStatus(), is(204));
        verify(addressServiceImpl).deleteAddress(anyLong());
        verifyNoMoreInteractions(addressServiceImpl);
    }

    @Test
    void updateAddress_UpdateOneAddress_WhenValidPayload() throws Exception {
        when(addressServiceImpl.updateAddress(Mockito.any(AddressReqUpdateDTO.class), anyLong())).thenReturn(addressResponseDTO);

        mockMvc.perform(put("/addresses/1").content(objectMapper.writeValueAsString(addressReqUpdateDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.city").value(addressResponseDTO.getCity()))
                .andExpect(jsonPath("$.id").value(addressResponseDTO.getId()))
                .andExpect(status().isOk());
    }
}
