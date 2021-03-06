package com.deveficiente.casadocodigo.request;

import com.deveficiente.casadocodigo.model.Author;
import com.deveficiente.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank
    private final String name;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private final String email;

    @NotBlank
    @Size(max = 400)
    private final String description;

    public AuthorRequest(@NotBlank String name,
                         @NotBlank @Email String email,
                         @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        return new Author(name, email, description);
    }

    public String getName() {
        return name;
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
                "nome='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
