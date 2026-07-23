package com.mauricio.sistemanibliotecario.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("Usuário não encontrado");
    }
}
