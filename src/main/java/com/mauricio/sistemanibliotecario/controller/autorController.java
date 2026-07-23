package com.mauricio.sistemanibliotecario.controller;

import com.mauricio.sistemanibliotecario.model.Autor;
import com.mauricio.sistemanibliotecario.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class autorController {

    private final AutorService service;

    public autorController(AutorService service){
        this.service = service;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id){
        Optional<Autor> autor = service.encontrarPorId(id);
        return autor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Autor> findByName(@PathVariable String name){
        Optional<Autor> autor = service.encontrarPorNome(name);
        return autor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll(){
        return ResponseEntity.ok(service.encontrarTodos());
    }

    @PostMapping("/salvarAutor")
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        service.salvarAutor(autor);
        return ResponseEntity.ok(autor);
    }

    @PutMapping("/atualizarAutor/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor){
        return ResponseEntity.ok(service.atualizarAutor(id, autor));
    }

    @DeleteMapping("/deletarAutor/{id}")
    public ResponseEntity<Autor> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
