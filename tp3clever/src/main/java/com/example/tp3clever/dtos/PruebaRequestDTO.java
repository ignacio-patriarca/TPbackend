package com.example.tp3clever.dtos;

import com.example.tp3clever.entity.Prueba;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PruebaRequestDTO {
    private Long idVehiculo;
    private Long idInteresado;
    private Long idEmpleado;
    private String fechaHoraInicio;
    private String fechaHoraFin;
    private String comentarios;

    // Ejemplo de método builder para manejar el paso de IDs de entidades relacionadas
    public static PruebaRequestDTO fromPruebaEntity(Prueba prueba) {
        return PruebaRequestDTO.builder()
                .idVehiculo(Long.valueOf(prueba.getVehiculo().getId()))  // Obtiene el ID de la entidad Vehiculo
                .idInteresado(Long.valueOf(prueba.getInteresado().getId()))  // Obtiene el ID de la entidad Interesado
                .idEmpleado(Long.valueOf(prueba.getEmpleado().getLegajo()))  // Obtiene el ID de la entidad Empleado
                .fechaHoraInicio(String.valueOf(prueba.getFechaHoraInicio()))
                .fechaHoraFin(String.valueOf(prueba.getFechaHoraFin()))
                .comentarios(prueba.getComentarios())
                .build();
    }
}
