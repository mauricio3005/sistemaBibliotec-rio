package com.mauricio.sistemanibliotecario.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autor_id",nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    public Autor(String nome) {
        this.nome = nome;
    }

    public Autor(){}

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

}
