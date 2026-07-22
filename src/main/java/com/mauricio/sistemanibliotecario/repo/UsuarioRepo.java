package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.model.Usuario;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    List<Livro> findByEstaEmprestadoTrue();
}
