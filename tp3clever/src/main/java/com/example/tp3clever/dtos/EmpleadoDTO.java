package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private int legajo;
    private String nombre;
    private String apellido;

    public EmpleadoDTO(Empleado empleado) {
        this.legajo = empleado.getLegajo();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
    }

    public Empleado toEmpleado() {return new Empleado(legajo, nombre, apellido);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoDTO that = (EmpleadoDTO) o;
        return legajo == that.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(legajo);
    }
}
