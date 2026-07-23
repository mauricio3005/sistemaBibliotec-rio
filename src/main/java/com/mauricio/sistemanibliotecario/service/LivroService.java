package com.mauricio.sistemanibliotecario.service;

import com.mauricio.sistemanibliotecario.exception.BookNotFound;
import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.model.Usuario;
import com.mauricio.sistemanibliotecario.repo.LivroRepo;
import org.springframework.stereotype.Service;

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

    public Optional<Livro> encontrarPorNome(String nome){
        return livroRepo.findByTitulo(nome);
    }

    public List<Livro> encontrarEmprestados(){
        return livroRepo.findByEstaEmprestadoTrue();
    }

    public List<Livro> encontrarPorAutor(Autor autor){
        return livroRepo.findByAutor(autor);
    }

    public List<Livro> encontrarTodos(){
        return livroRepo.findAll();
    }

    public List<Livro> encontrarEmprestadosAUsuario(Usuario user){
        return livroRepo.findByEmprestadoA(user);
    }

    public Livro deleteById(Long id){
        if(this.encontrarPorId(id).isPresent()){
            livroRepo.deleteById(id);
            return null;
        }
        throw new BookNotFound();
    }

}
