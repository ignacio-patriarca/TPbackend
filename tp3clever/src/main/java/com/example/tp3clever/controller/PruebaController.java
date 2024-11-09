package com.example.tp3clever.controller;

import com.example.tp3clever.dtos.PruebaRequestDTO;
import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.entity.Interesado;
import com.example.tp3clever.entity.Prueba;
import com.example.tp3clever.entity.Vehiculo;
import com.example.tp3clever.repository.*;
import com.example.tp3clever.dtos.PruebaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController @RequestMapping("/api/prueba")
public class PruebaController {

    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private InteresadoRepository interesadoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Prueba> getAll(){
        List<Prueba> pruebas = pruebaRepository.findAll();
        return pruebas;
    }

    @PostMapping
    public ResponseEntity<Prueba> createPrueba(@RequestBody PruebaRequestDTO pruebaRequest) {
        // Buscar las entidades relacionadas
        Vehiculo vehiculo = vehiculoRepository.findById(Math.toIntExact(pruebaRequest.getIdVehiculo()))
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        Interesado interesado = interesadoRepository.findById(Math.toIntExact(pruebaRequest.getIdInteresado()))
                .orElseThrow(() -> new RuntimeException("Interesado no encontrado"));
        Empleado empleado = empleadoRepository.findById(Math.toIntExact(pruebaRequest.getIdEmpleado()))
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        // Convertir el DTO a la entidad
        Prueba prueba = PruebaMapper.toEntity(pruebaRequest, vehiculo, interesado, empleado);

        // Guardar en la base de datos
        Prueba nuevaPrueba = pruebaRepository.save(prueba);

        return ResponseEntity.ok(nuevaPrueba);
    }

    
}
