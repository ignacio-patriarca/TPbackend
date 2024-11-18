package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data @ToString
@Entity @Table(name = "Marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;

    public Marca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
