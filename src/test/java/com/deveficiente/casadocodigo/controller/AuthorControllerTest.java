package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.repository.AuthorRepository;
import com.deveficiente.casadocodigo.request.AuthorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    private final String URL = "/v1/author";

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

    @Test
    @DisplayName("Falha ao tentar criar autor sem nome")
    public void testFailWithoutName() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("", "null@globo.com", "Esse é o teste do null");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Name must be informed")));
    }

    @Test
    @DisplayName("Falha ao tentar criar autor sem email")
    public void testFailWithoutEmail() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Victor", "", "Esse é o teste do null");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Email must be informed")));
    }

    @Test
    @DisplayName("Falha ao tentar criar autor sem email")
    public void testFailWithoutEmailFormat() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Victor", "email", "Esse é o teste do null");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Enter a valid email format")));
    }

    @Test
    @DisplayName("Falha ao tentar criar autor sem descrição")
    public void testFailWithoutDescription() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Victor", "email@email.com", "");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Description must be informed")));
    }

    @Test
    @DisplayName("Falha ao tentar criar autor com descrição > 400 caracteres")
    public void testFailWithMaxDescription() throws Exception {
        AuthorRequest authorRequest = new AuthorRequest("Victor", "email@email.com", "Lorem ipsum dolor sit amet, " +
                "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
                "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem." +
                " Nulla consequat massa quis enim. Donec pede justo, fringilla vel, " +
                "aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a,");
        String requestBody = objectMapper.writeValueAsString(authorRequest);
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Description must have a max of 400 characters")));
    }

}
