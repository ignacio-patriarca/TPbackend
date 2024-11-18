package com.example.tp3clever.services;

import com.example.tp3clever.dtos.EmpleadoDTO;
import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository repository) {
        this.empleadoRepository = repository;
    }

    public List<EmpleadoDTO> findAll(){
        return empleadoRepository.findAll().stream().map(empleado -> new EmpleadoDTO(empleado)).toList();
    }

    public Optional<EmpleadoDTO> findById(Integer id){
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.isEmpty() ? Optional.empty() : Optional.of(new EmpleadoDTO(empleado.get()));
    }

    public EmpleadoDTO add(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoDTO.toEmpleado();
        empleado = empleadoRepository.save(empleado);
        return new EmpleadoDTO(empleado);
    }
}
