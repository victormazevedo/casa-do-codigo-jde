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
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email(message = "Por favor, digite um e-mail válido.")
    private String email;

    @NotBlank
    @Size(max = 400, message = "Descrição ultrapassou 400 caracteres.")
    private String descricao;

    private LocalDateTime instant = LocalDateTime.now();

    protected Autor() {}

    public Autor(@NotBlank String nome,
                 @NotBlank @Email(message = "Por favor, digite um e-mail válido.") String email,
                 @NotBlank @Size(max = 400, message = "Descrição ultrapassou 400 caracteres.") String descricao,
                 LocalDateTime instant) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instant = instant;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstant() {
        return instant;
    }
}
