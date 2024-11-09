package com.example.tp3clever.controller;

import com.example.tp3clever.dtos.EmpleadoRequestDTO;
import com.example.tp3clever.dtos.EmpleadoResponseDTO;
import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController @RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAll(){
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados;
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> createEmpleado(@RequestBody EmpleadoRequestDTO empleadoRequestDTO) {
        // Crear una nueva instancia de Empleado a partir del DTO
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(empleadoRequestDTO.getNombre());
        nuevoEmpleado.setApellido(empleadoRequestDTO.getApellido());
        nuevoEmpleado.setTelefonoContacto(Long.valueOf(empleadoRequestDTO.getTelefonoContacto()));

        // Guardar el nuevo empleado en la base de datos
        Empleado savedEmpleado = empleadoRepository.save(nuevoEmpleado);

        // Convertir la entidad guardada a DTO para la respuesta
        EmpleadoResponseDTO responseDTO = EmpleadoResponseDTO.fromEmpleadoEntity(savedEmpleado);

        // Retornar el empleado creado en formato DTO con un estado HTTP 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
