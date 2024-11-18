package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private int id;
    private String patente;
    private int modelo;


    public VehiculoDTO(Vehiculo vehiculo) {
        this.patente = vehiculo.getPatente();
        this.id = vehiculo.getId();
        this.modelo = vehiculo.getModelo().getId();
    }

    public Vehiculo toVehiculo() {return new Vehiculo(id,patente);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoDTO that = (VehiculoDTO) o;
        return Objects.equals(patente, that.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patente);
    }
}
