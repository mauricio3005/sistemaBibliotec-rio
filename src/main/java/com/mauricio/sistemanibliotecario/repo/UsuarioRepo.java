package com.mauricio.sistemanibliotecario.repo;

import com.mauricio.sistemanibliotecario.model.Livro;

import java.util.List;

public interface UsuarioRepo {
    List<Livro> findByEstaEmprestadoTrue();
}
