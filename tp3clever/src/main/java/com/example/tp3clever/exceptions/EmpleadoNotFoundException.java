package com.example.tp3clever.exceptions;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
