package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Posicion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDTO {
    private int idPosicion;
    private String fechaHora;
    private int vehiculo;

    public PosicionDTO(Posicion posicion){
        this.idPosicion = posicion.getId();
        this.fechaHora = posicion.getFechaHora();
        this.vehiculo = posicion.getVehiculo().getId();
    }

    public Posicion toPosicion(){return new Posicion(idPosicion, fechaHora);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosicionDTO that = (PosicionDTO) o;
        return idPosicion == that.idPosicion;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPosicion);
    }
}
