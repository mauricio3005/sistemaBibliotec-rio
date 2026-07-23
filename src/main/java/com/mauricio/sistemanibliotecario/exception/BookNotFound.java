package com.mauricio.sistemanibliotecario.exception;

public class BookNotFound extends RuntimeException {
    public BookNotFound() {
        super("Livro não encontrado");
    }
}
