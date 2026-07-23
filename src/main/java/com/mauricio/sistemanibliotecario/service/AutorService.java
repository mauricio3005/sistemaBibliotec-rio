package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.exception.AuthorNotFound;
import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.repo.AutorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepo repo;

    public AutorService(AutorRepo repo) {
        this.repo = repo;
    }

    public Autor salvarAutor(Autor autor){
        repo.save(autor);
        return autor;
    }

    public Optional<Autor> encontrarPorId(Long id) {
        return repo.findById(id);
    }

    public Optional<Autor> encontrarPorNome(String nome){
        return repo.findByNome(nome);
    }

    public List<Autor> encontrarTodos(){
        return repo.findAll();
    }

    public Autor atualizarAutor(Long id, Autor autor){
        Autor autorExistente = this.encontrarPorId(id).orElseThrow(AuthorNotFound::new);
        autorExistente.setNome(autor.getNome());
        repo.save(autorExistente);
        return autorExistente;
    }

    public void deleteById(Long id){
        if(this.encontrarPorId(id).isPresent()) {
            repo.deleteById(id);
            return;
        }
        throw new AuthorNotFound();
    }

}
