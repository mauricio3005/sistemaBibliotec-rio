package com.mauricio.sistemanibliotecario.controller;

import com.mauricio.sistemanibliotecario.model.Usuario;
import com.mauricio.sistemanibliotecario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    private final UsuarioService service;

    public usuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Optional<Usuario> usuario = service.encontrarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<Usuario> findByNome(@PathVariable String nome){
        Optional<Usuario> usuario = service.verPorNome(nome);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(service.verTodos());
    }

    @PostMapping("/criarUsuario")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        service.criarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/atualizarUsuario/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(service.atualizarUsuario(id, usuario));
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        service.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

}
