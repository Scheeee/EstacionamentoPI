package br.com.uniamerica.estacionamento.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 17/05/2023
 * @since 1.0.0
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     *
     * @param methodArgumentNotValidException
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
            final MethodArgumentNotValidException methodArgumentNotValidException
    ){
        final Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    errors.put(
                            ((FieldError) error).getField(),
                            error.getDefaultMessage());
                });

        return errors;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AssertionError.class)
    public ResponseEntity<String> handleAssertionError(AssertionError error) {
        //String mensagemDeErro = error.getMessage();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro de validação");


    }
}