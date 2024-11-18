package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Interesado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresadoDTO {
    private int id;
    private String documento;
    private String nombre;
    private String apellido;

    public InteresadoDTO(Interesado interesado) {
        this.id = interesado.getId();
        this.documento = interesado.getDocumento();
        this.nombre = interesado.getNombre();
        this.apellido = interesado.getApellido();
    }

    public Interesado toInteresado() {return new Interesado(id,documento, nombre, apellido);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteresadoDTO that = (InteresadoDTO) o;
        return documento == that.documento;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(documento);
    }
}
