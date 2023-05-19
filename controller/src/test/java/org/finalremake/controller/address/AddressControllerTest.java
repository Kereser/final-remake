package org.finalremake.controller.address;

import org.finalremake.service.address.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class AddressControllerTest {
    @MockBean
    private AddressServiceImpl addressServiceImpl;
    @Autowired
    private MockMvc mockMvc;

}
