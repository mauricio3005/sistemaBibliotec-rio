package com.mauricio.sistemanibliotecario.exception;

public class BookWithSomeoneElse extends RuntimeException {
    public BookWithSomeoneElse( ) {
        super("Livro está com outra pessoa");
    }
}
