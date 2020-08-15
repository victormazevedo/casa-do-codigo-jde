package com.deveficiente.casadocodigo.request;

import com.deveficiente.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank
    private final String nome;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    public AuthorRequest(@NotBlank String nome,
                         @NotBlank @Email String email,
                         @NotBlank @Size(max = 400) String description) {
        this.nome = nome;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        return new Author(nome, email, description);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AuthorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
