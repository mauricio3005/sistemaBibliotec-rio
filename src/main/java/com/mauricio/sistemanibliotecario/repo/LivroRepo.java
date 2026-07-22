package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepo extends JpaRepository<Livro , Long> {
    Livro findByTitulo(String titulo);
}
