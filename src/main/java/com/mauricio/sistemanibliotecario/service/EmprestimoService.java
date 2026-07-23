package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.exception.BookNotFound;
import com.mauricio.sistemanibliotecario.exception.BookWithSomeoneElse;
import com.mauricio.sistemanibliotecario.exception.UserNotFound;
import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.model.Usuario;
import com.mauricio.sistemanibliotecario.repo.LivroRepo;
import com.mauricio.sistemanibliotecario.repo.UsuarioRepo;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    private final LivroRepo livroRepo;
    private final UsuarioRepo usuarioRepo;

    public EmprestimoService(LivroRepo livroRepo, UsuarioRepo usuarioRepo) {
        this.livroRepo = livroRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public void receberLivro(Long livroId, Long usuarioId) {
        Livro livro = livroRepo.findById(livroId).orElseThrow(BookNotFound::new);
        Usuario usuario = usuarioRepo.findById(usuarioId).orElseThrow(UserNotFound::new);
        if (livro.isEstaEmprestado()) {
            throw new BookWithSomeoneElse();
        }
        livro.setEmprestadoA(usuario);
        livroRepo.save(livro);
    }

    public void devolverLivro(Long livroId, Long usuarioId) {
        Livro livro = livroRepo.findById(livroId).orElseThrow(BookNotFound::new);
        Usuario usuario = usuarioRepo.findById(usuarioId).orElseThrow(UserNotFound::new);
        Usuario emprestadoA = livro.getEmprestadoA();
        if (emprestadoA != null && emprestadoA.getId().equals(usuario.getId())) {
            livro.setEmprestadoA(null);
            livroRepo.save(livro);
            return;
        }
        throw new BookWithSomeoneElse();
    }

}
