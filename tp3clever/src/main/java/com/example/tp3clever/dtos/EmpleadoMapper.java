package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Empleado;
import org.springframework.stereotype.Component;


@Component
public class EmpleadoMapper {

    public static Empleado toEntity(EmpleadoRequestDTO requestDTO) {
        return Empleado.builder()
                .nombre(requestDTO.getNombre())
                .apellido(requestDTO.getApellido())
                .telefonoContacto(Long.valueOf(requestDTO.getTelefonoContacto()))
                .build();
    }

    public EmpleadoResponseDTO toDTO(Empleado empleado) {
        return EmpleadoResponseDTO.fromEmpleadoEntity(empleado);
    }
}

