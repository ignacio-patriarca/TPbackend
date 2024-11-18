package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Marca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {
    private int id;
    private String nombre;

    public MarcaDTO(Marca marca){
        this.id = marca.getId();
        this.nombre = marca.getNombre();
    }

    public Marca toMarca(){return new Marca(id, nombre);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaDTO marcaDTO = (MarcaDTO) o;
        return id == marcaDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
