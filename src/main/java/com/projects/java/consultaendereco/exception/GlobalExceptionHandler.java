package com.projects.java.consultaendereco.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CepNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cep não encontrado")
    public ResponseEntity<String> handler(CepNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(value = FeignException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Requisição Inválida")
    public ResponseEntity<String> handler(FeignException ex){
        return ResponseEntity.status(ex.status()).body("Requisição Inválida");
    }

}
