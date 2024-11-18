package com.example.tp3clever.exceptions;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
