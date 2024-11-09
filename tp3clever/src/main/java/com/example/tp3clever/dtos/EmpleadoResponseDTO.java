package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Empleado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoResponseDTO {

    private Long legajo;
    private String nombre;
    private String apellido;
    private Integer telefonoContacto;

    // Constructor, getters, setters y otros métodos generados por @Data

    // Método estático para crear un EmpleadoResponseDTO a partir de la entidad Empleado
    public static EmpleadoResponseDTO fromEmpleadoEntity(Empleado empleado) {
        EmpleadoResponseDTO dto = new EmpleadoResponseDTO(builder().legajo, builder().nombre, builder().apellido, builder().telefonoContacto);
        dto.setLegajo(Long.valueOf(empleado.getLegajo()));
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setTelefonoContacto(Math.toIntExact(empleado.getTelefonoContacto()));
        return dto;
    }
}
