package com.meli.w4.desafio_quality.advice;

import com.meli.w4.desafio_quality.exception.DistrictFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PropertyExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String errorMessage = ((FieldError) error).getDefaultMessage();
            errors.put(field + "_error", errorMessage);
        });
        return errors;
    }


    /**
     * Retorna ResponseBody com o erro capturado pela exception
     *
     * @author Thomaz Ferreira
     * @param e
     * @return Map
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private Map<String, String> jsonFormatterException(HttpMessageNotReadableException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error_message", "Json inválido");
        return errors;
    }


    /**
     * Retorna ResponseBody com o erro capturado pela exception
     *
     * @author Thomaz Ferreira
     * @param e
     * @return Map
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    private Map<String, String> IoException(RuntimeException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error_message", e.getMessage());
        errors.put("exception", e.getMessage());
        return errors;
    }


    /**
     * Retorna ResponseBody com o erro capturado pela exception
     *
     * @author Thomaz Ferreira
     * @param e
     * @return Map
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(DistrictFoundException.class)
    private Map<String, String> districFoundException(DistrictFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error_message", e.getMessage());
        errors.put("statusCode", "400");
        return errors;
    }
}
