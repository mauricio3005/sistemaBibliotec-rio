package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepo extends JpaRepository<Autor, Long> {

    public Autor findByNome(String nome);
}
