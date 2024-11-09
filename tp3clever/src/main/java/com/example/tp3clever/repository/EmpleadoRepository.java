package com.example.tp3clever.repository;

import com.example.tp3clever.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
}
