package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Prueba;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaDTO {
    private int id;
    private String comentarios;
    private int idInteresado;
    private int idVehiculo;
    private int legajoEmpleado;
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;

    public PruebaDTO(Prueba prueba){
        super();
        this.id = prueba.getId();
        this.comentarios = prueba.getComentarios();
        if (prueba.getInteresado() != null){
            this.idInteresado = prueba.getInteresado().getId();
        }
        if (prueba.getVehiculo() != null){
            this.idVehiculo = prueba.getVehiculo().getId();
        }
        this.legajoEmpleado = prueba.getEmpleado().getLegajo();
        this.fechaHoraInicio = prueba.getFechaHoraInicio();
        this.fechaHoraFin = prueba.getFechaHoraFin();
    }

    public Prueba toPrueba(){return new Prueba(id, comentarios);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruebaDTO pruebaDTO = (PruebaDTO) o;
        return id == pruebaDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
