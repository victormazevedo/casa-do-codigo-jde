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

import static org.springframework.http.HttpStatus.OK;
//3
@RestController
@RequestMapping("/v1/author")
public class AuthorController {
    //1
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //1
    @PostMapping
    public ResponseEntity<Author> create(@Valid @RequestBody AuthorRequest authorRequest) {
       //1
        Author author = authorRequest.toModel();
        authorRepository.save(author);
        return ResponseEntity.status(OK).body(author);
    }
}
