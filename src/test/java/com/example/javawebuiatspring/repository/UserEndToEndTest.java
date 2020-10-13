package com.example.javawebuiatspring.repository;


import com.example.javawebuiatspring.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testEndToEnd() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(post("/user")
                .content("{\"id\":null,\"name\":\"Vacheron\",\"age\":5,\"email\":null}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andReturn();


        String responseUserAsString = mvcResult.getResponse().getContentAsString();
        User response = objectMapper.readerFor(User.class).readValue(responseUserAsString, User.class);

        Assertions.assertNotNull(response.getId());
        Assertions.assertEquals("Vacheron", response.getName());
    }



}
