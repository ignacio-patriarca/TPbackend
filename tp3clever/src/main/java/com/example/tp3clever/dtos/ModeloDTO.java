package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {
    private int id;
    private String descripcion;
    private int marca;

    public ModeloDTO(Modelo modelo) {
        this.id = modelo.getId();
        this.descripcion = modelo.getDescripcion();
        this.marca = modelo.getMarca().getId();
    }

    public Modelo toModelo() {return new Modelo(id, descripcion);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloDTO modeloDTO = (ModeloDTO) o;
        return id == modeloDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
