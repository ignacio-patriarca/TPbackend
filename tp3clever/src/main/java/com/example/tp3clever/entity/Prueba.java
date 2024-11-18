package com.example.tp3clever.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data@NoArgsConstructor@AllArgsConstructor@ToString@Builder
@Entity@Table(name = "Pruebas")
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "ID_INTERESADO", nullable = false)
    private Interesado interesado;

    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado empleado;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "FECHA_HORA_FIN", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "COMENTARIOS", length = 500)
    private String comentarios;

    public Prueba(int id, String comentarios) {
        this.id = id;
        this.comentarios = comentarios;
        this.vehiculo = null;
        this.interesado = null;
        this.empleado = null;
    }

    public Prueba update(Prueba prueba) {
        id = prueba.id;
        comentarios = prueba.comentarios;
        return this;
    }

}
