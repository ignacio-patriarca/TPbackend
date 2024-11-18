package com.example.tp3clever.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity @Table(name = "Interesados")
public class Interesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TIPO_DOCUMENTO", nullable = false, length = 3)
    private String tipoDocumento = "DNI";

    @Column(name = "DOCUMENTO", nullable = false, length = 10)
    private String documento;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;

    @Column(name = "RESTRINGIDO", nullable = false)
    private Boolean restringido = false;

    @Column(name = "NRO_LICENCIA", nullable = false)
    private Integer nroLicencia;

    @Column(name = "FECHA_VENCIMIENTO_LICENCIA", nullable = false)
    private LocalDateTime fechaVencimientoLicencia;

    public Interesado(int id, String documento, String nombre, String apellido) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
