package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.model.Author;
import com.deveficiente.casadocodigo.repository.AuthorRepository;
import com.deveficiente.casadocodigo.request.AuthorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/author")
public class AuthorController {
    //1
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //2
    @PostMapping
    public ResponseEntity<Author> create(@Valid @RequestBody AuthorRequest authorRequest) {
        Author author = authorRequest.toModel();
        authorRepository.save(author);
        return ResponseEntity.status(CREATED).body(author);
    }
}
