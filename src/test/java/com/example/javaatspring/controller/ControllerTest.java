package com.example.javaatspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getBookWord() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/book?bookName=src/test/java/com/example/javaatspring/repository/testText")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseBookAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertNotNull(responseBookAsString);
        Assertions.assertTrue(responseBookAsString.equals("{\"его\":1,\"текстфайл\":1,\"тестов\":1,\"приведет\":1," +
                "\"падению\":1,\"тестовый\":1,\"изменение\":1,\"это\":1,\"к\":1}"));
        System.out.println("asd");
    }
}