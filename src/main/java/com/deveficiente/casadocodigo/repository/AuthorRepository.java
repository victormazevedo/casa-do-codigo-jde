package com.deveficiente.casadocodigo.repository;

import com.deveficiente.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
}
