package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Empleado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoRequestDTO {
    private String nombre;
    private String apellido;
    private Integer telefonoContacto;

    // Método builder para convertir un Empleado en un EmpleadoRequestDTO
    public static EmpleadoRequestDTO fromEmpleadoEntity(Empleado empleado) {
        return EmpleadoRequestDTO.builder()
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .telefonoContacto(Math.toIntExact(empleado.getTelefonoContacto()))
                .build();
    }
}

