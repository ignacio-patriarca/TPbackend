package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor @AllArgsConstructor @Data @ToString
@Entity @Table(name = "Posiciones")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "FECHA_HORA", nullable = false)
    private String fechaHora;

    @Column(name = "LATITUD", nullable = false, precision = 10, scale = 8)
    private BigDecimal latitud;

    @Column(name = "LONGITUD", nullable = false, precision = 11, scale = 8)
    private BigDecimal longitud;

    public Posicion(int idPosicion, String fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.vehiculo = null;
    }
}
