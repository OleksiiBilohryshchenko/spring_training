package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
public class StudentController {

    @Autowired
    private MockMvc mvc;

    @Test
    void getStudent_Test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":  \"Mike\", \"lastName\": \"Smith\", \"age\": 20}"))
                .andDo(print())
                .andReturn();

    }


}
