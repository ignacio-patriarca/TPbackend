package com.example.tp3clever.repository;

import com.example.tp3clever.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    Optional<Vehiculo> findByPatente(String patente);
}
