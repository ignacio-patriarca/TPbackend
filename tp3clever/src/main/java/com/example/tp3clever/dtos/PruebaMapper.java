package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.entity.Interesado;
import com.example.tp3clever.entity.Prueba;
import com.example.tp3clever.entity.Vehiculo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PruebaMapper {

    public static Prueba toEntity(PruebaRequestDTO requestDTO, Vehiculo vehiculo, Interesado interesado, Empleado empleado) {
        return Prueba.builder()
                .vehiculo(vehiculo)  // Asigna la entidad Vehiculo directamente
                .interesado(interesado)  // Asigna la entidad Interesado directamente
                .empleado(empleado)  // Asigna la entidad Empleado directamente
                .fechaHoraInicio(LocalDateTime.parse(requestDTO.getFechaHoraInicio()))
                .fechaHoraFin(LocalDateTime.parse(requestDTO.getFechaHoraFin()))
                .comentarios(requestDTO.getComentarios())
                .build();
    }

    public PruebaResponseDTO toDTO(Prueba prueba) {
        return PruebaResponseDTO.fromPruebaEntity(prueba);
    }
}


