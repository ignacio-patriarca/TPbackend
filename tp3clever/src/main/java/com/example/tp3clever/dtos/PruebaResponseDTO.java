package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Prueba;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PruebaResponseDTO {
    private Long id;
    private Long idVehiculo;
    private Long idInteresado;
    private Long idEmpleado;
    private String fechaHoraInicio;
    private String fechaHoraFin;
    private String comentarios;

    // Método builder para convertir una entidad Prueba en un DTO de respuesta
    public static PruebaResponseDTO fromPruebaEntity(Prueba prueba) {
        return PruebaResponseDTO.builder()
                .id(Long.valueOf(prueba.getId()))
                .idVehiculo(Long.valueOf(prueba.getVehiculo().getId()))  // Mapea el ID de Vehiculo
                .idInteresado(Long.valueOf(prueba.getInteresado().getId()))  // Mapea el ID de Interesado
                .idEmpleado(Long.valueOf(prueba.getEmpleado().getLegajo()))  // Mapea el ID de Empleado
                .fechaHoraInicio(String.valueOf(prueba.getFechaHoraInicio()))
                .fechaHoraFin(String.valueOf(prueba.getFechaHoraFin()))
                .comentarios(prueba.getComentarios())
                .build();
    }
}
