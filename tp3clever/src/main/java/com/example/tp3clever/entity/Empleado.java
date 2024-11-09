package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Entity @Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAJO")
    private Integer legajo;

    @Column(name = "NOMBRE",nullable = false, length = 30)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;

    @Column(name = "TELEFONO_CONTACTO", nullable = false)
    private Long telefonoContacto;

}
