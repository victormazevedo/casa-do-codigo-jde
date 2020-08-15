package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.repository.AuthorRepository;
import com.deveficiente.casadocodigo.request.AuthorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    private final String URL = "/author";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    AuthorRepository authorRepository;

    @Test
    public void testSuccessWhenCreateANewAuthor() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Victor", "victor@gmail.com", "Victor é graduado pela Fatec");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody)).andExpect(status().isCreated());
    }
}
