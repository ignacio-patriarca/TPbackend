package com.example.tp3clever.repository;


import com.example.tp3clever.entity.Prueba;
import com.example.tp3clever.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PruebaRepository extends JpaRepository<Prueba, Integer> {
    boolean existsByVehiculoAndFechaHoraFinIsNull(Vehiculo vehiculo);
}
