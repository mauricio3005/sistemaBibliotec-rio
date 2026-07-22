package com.mauricio.sistemanibliotecario.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "emprestadoA")
    private List<Livro> emprestados;

    public Usuario (String nome){
        this.nome = nome;
    }

    public Usuario(){}

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getEmprestados() {
        return emprestados;
    }

    public void setEmprestados(List<Livro> emprestados) {
        this.emprestados = emprestados;
    }
}
