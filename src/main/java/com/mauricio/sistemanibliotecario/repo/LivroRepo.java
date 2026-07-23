package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepo extends JpaRepository<Livro , Long> {
    Optional<Livro> findByTitulo(String titulo);
    List<Livro> findByEstaEmprestadoTrue();
    List<Livro> findByAutor(Autor autor);
    List<Livro> findByEmprestadoA(Usuario usuario);
}
