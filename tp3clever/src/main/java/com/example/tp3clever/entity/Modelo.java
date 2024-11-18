package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data @ToString
@Entity
@Table(name = "Modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA", nullable = false)
    private Marca marca;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    public Modelo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = null;
    }
}
