package com.mauricio.sistemanibliotecario.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false)
    private Autor autor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroLivro generoLivro;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = true)
    private Usuario emprestadoA;

    public boolean isEstaEmprestado(){
        return emprestadoA != null;
    }

    public Livro(){}

    public Livro(String titulo, Autor autor, GeneroLivro generoLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.generoLivro = generoLivro;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public GeneroLivro getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(GeneroLivro generoLivro) {
        this.generoLivro = generoLivro;
    }

    public Usuario getEmprestadoA() {
        return emprestadoA;
    }

    public void setEmprestadoA(Usuario emprestadoA) {
        this.emprestadoA = emprestadoA;
    }

}
