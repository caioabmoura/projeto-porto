package com.example.demo.handler;

import com.example.demo.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleUserException(UserException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro de validação", ex.getMessage()));
    }

    public static class ErrorResponse {
        private String erro;
        private String detalhe;

        public ErrorResponse(String erro, String detalhe) {
            this.erro = erro;
            this.detalhe = detalhe;
        }

        public String getErro() {
            return erro;
        }

        public String getDetalhe() {
            return detalhe;
        }
    }
}
