package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Entity @Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PATENTE", nullable = false, length = 10)
    private String patente;

    @ManyToOne
    @JoinColumn(name = "ID_MODELO", nullable = false)
    private Modelo modelo;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @OneToMany(mappedBy = "vehiculo")
    private List<Posicion> posiciones;

    @OneToMany(mappedBy = "vehiculo")
    private List<Prueba> pruebas;

    public Vehiculo(int id, String patente) {
        this.id = id;
        this.patente = patente;
        this.modelo = null;
    }

}
