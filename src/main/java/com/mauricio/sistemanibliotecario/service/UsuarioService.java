package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.exception.UserNotFound;
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

    public Usuario atualizarUsuario(Long id, Usuario usuario){
        Usuario usuarioExistente = this.encontrarPorId(id).orElseThrow(UserNotFound::new);
        usuarioExistente.setNome(usuario.getNome());
        repo.save(usuarioExistente);
        return usuarioExistente;
    }

    public Usuario deletarUsuarioPorId(Long id){
        if(this.encontrarPorId(id).isPresent()){
            repo.deleteById(id);
            return null;
        }
        throw new UserNotFound();
    }

    public List<Usuario> verTodos(){
        return repo.findAll();
    }

    public Optional<Usuario> verPorNome(String nome){
        return repo.getByNome(nome);
    }

}
