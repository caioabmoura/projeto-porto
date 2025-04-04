package com.example.demo.exception;

public class UserException extends RuntimeException{

    public UserException(String message) {
        super(message);
    }

    public UserException() {
        super("Usuário não encontrado"); // mensagem padrão
    }
}
