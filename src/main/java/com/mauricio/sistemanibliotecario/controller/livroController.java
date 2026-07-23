package com.mauricio.sistemanibliotecario.controller;

import com.mauricio.sistemanibliotecario.model.Livro;
import com.mauricio.sistemanibliotecario.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class livroController {

    private final LivroService service;

    public livroController(LivroService service){
        this.service = service;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Optional<Livro> livro = service.encontrarPorId(id);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByTitulo/{titulo}")
    public ResponseEntity<Livro> findByTitulo(@PathVariable String titulo){
        Optional<Livro> livro = service.encontrarPorNome(titulo);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        return ResponseEntity.ok(service.encontrarTodos());
    }

    @PostMapping("/salvarLivro")
    public ResponseEntity<Livro> save(@RequestBody Livro livro){
        service.salvarLivro(livro);
        return ResponseEntity.ok(livro);
    }

    @PutMapping("/atualizarLivro/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
        return ResponseEntity.ok(service.atualizarLivro(id, livro));
    }

    @DeleteMapping("/deletarLivro/{id}")
    public ResponseEntity<Livro> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
