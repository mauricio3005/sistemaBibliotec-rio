package com.mauricio.sistemanibliotecario.exception;

public class AuthorNotFound extends RuntimeException {
    public AuthorNotFound( ) {
        super("Autor não encontrado");
    }
}
