package com.example.tp3clever.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(VehiculoEnUsoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleVehiculoEnUsoException(VehiculoEnUsoException ex) {
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(InteresadoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleInteresadoNotFoundException(InteresadoNotFoundException ex) {
        return "Error: Interesado no encontrado.";
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEmpleadoNotFoundException(EmpleadoNotFoundException ex) {
        return "Error: Empleado no encontrado.";
    }

    @ExceptionHandler(VehiculoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleVehiculoNotFoundException(VehiculoNotFoundException ex) {
        return "Error: Vehículo no encontrado.";
    }

    @ExceptionHandler(InteresadoNoValidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInteresadoNoValidoException(InteresadoNoValidoException ex) {
        return "Error: " + ex.getMessage();
    }

}
