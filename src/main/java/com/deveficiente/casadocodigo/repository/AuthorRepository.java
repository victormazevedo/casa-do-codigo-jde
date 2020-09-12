package com.deveficiente.casadocodigo.repository;

import com.deveficiente.casadocodigo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
