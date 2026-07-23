package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.exception.BookNotFound;
import com.mauricio.sistemanibliotecario.exception.BookWithSomeoneElse;
import com.mauricio.sistemanibliotecario.exception.UserNotFound;
import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.model.Usuario;
import com.mauricio.sistemanibliotecario.repo.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepo repo;

    public UsuarioService(UsuarioRepo repo) {
        this.repo = repo;
    }

    public Usuario criarUsuario(Usuario usuario){
        repo.save(usuario);
        return usuario;
    }

    public Optional<Usuario> encontrarPorId(Long id){
        return repo.findById(id);
    }

    public Usuario deletarUsuarioPorId(Long id){
        if(this.encontrarPorId(id).isPresent()){
            repo.deleteById(id);
            return null;
        }
        throw new UserNotFound();
    }

    public void receberLivro(Livro livro, Usuario usuario){
        if(usuario == null || usuario.getId() == null){
            throw new UserNotFound();
        }
        if(livro == null){
            throw new BookNotFound();
        }
        if(!livro.isEstaEmprestado()){
            if(repo.findById(usuario.getId()).isPresent()){
                livro.setEmprestadoA(usuario);
                return;
            } else throw new UserNotFound();
        }
        else throw new BookWithSomeoneElse();
    }

    public void devolverLivro(Livro livro, Usuario usuario) {
        if(usuario == null || usuario.getId() == null){
            throw new UserNotFound();
        }
        if(livro == null){
            throw new BookNotFound();
        }
        Usuario emprestadoA = livro.getEmprestadoA();
        if (emprestadoA != null && emprestadoA.getId().equals(usuario.getId())) {
            livro.setEmprestadoA(null);
            return;
        } else throw new BookWithSomeoneElse();
    }

    public List<Usuario> verTodos(){
        return repo.findAll();
    }

    public Optional<Usuario> verPorNome(String nome){
        return repo.getByNome(nome);
    }

}
