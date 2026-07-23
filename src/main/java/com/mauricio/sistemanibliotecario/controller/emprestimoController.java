package com.mauricio.sistemanibliotecario.controller;

import com.mauricio.sistemanibliotecario.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
public class emprestimoController {

    private final EmprestimoService service;

    public emprestimoController(EmprestimoService service){
        this.service = service;
    }

    @PostMapping("/receber/{livroId}/{usuarioId}")
    public ResponseEntity<Void> receberLivro(@PathVariable Long livroId, @PathVariable Long usuarioId){
        service.receberLivro(livroId, usuarioId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/devolver/{livroId}/{usuarioId}")
    public ResponseEntity<Void> devolverLivro(@PathVariable Long livroId, @PathVariable Long usuarioId){
        service.devolverLivro(livroId, usuarioId);
        return ResponseEntity.ok().build();
    }

}
