package com.deveficiente.casadocodigo.model;

import javax.persistence.*;
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
    @Email(message = "Enter a valid email, please.")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400, message = "Description must have 400 characters")
    private String description;

    private LocalDateTime instant;

    protected Author() {}

    public Author(@NotBlank String name,
                  @NotBlank @Email(message = "Enter a valid email, please.") String email,
                  @NotBlank @Size(max = 400, message = "Description must have a max of 400 characters") String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.instant = LocalDateTime.now();
    }

    public void updateAuthor(Author author) {
        this.description = author.description;
        this.name = author.name;
        this.email = author.email;
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
