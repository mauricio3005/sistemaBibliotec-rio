package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepo extends JpaRepository<Livro , Long> {
    Livro findByTitulo(String titulo);
    List<Livro> findByEstaEmprestadoTrue();
    List<Livro> findByAutor(Autor autor);
}
