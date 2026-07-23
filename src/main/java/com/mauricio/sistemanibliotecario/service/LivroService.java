package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.repo.LivroRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepo livroRepo;

    public LivroService(LivroRepo livroRepo){
        this.livroRepo = livroRepo;
    }

    public Livro salvarLivro(Livro livro){
        livroRepo.save(livro);
        return livro;
    }

    public Optional<Livro> encontrarPorId(Long id){
        return livroRepo.findById(id);
    }

    public Livro encontrarPorNome(String nome){
        return livroRepo.findByTitulo(nome);
    }

    public List<Livro> encontrarEmprestados(){
        return livroRepo.findByEstaEmprestadoTrue();
    }

    public List<Livro> encontrarPorAutor(Autor autor){
        return livroRepo.findByAutor(autor);
    }

    public Livro deleteById(Long id){
        livroRepo.deleteById(id);
        return null;
    }

}
