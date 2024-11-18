package com.example.tp3clever.controller;

import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
