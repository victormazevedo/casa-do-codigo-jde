package com.deveficiente.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    private LocalDateTime instant;

    @Deprecated
    protected Author() {}

    public Author(@NotBlank String name,
                  @NotBlank @Email String email,
                  @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.instant = LocalDateTime.now();
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

    public LocalDateTime getInstant() {
        return instant;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", instant=" + instant +
                '}';
    }
}
