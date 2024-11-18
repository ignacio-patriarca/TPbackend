package com.example.tp3clever.services;

import com.example.tp3clever.dtos.PosicionDTO;
import com.example.tp3clever.entity.Posicion;
import com.example.tp3clever.entity.Vehiculo;
import com.example.tp3clever.repository.PosicionRepository;
import com.example.tp3clever.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosicionService {
    private PosicionRepository posicionRepository;
    private VehiculoRepository vehiculoRepository;

    @Autowired
    public PosicionService(PosicionRepository repository, VehiculoRepository vehiculoRepository) {
        this.posicionRepository = repository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<PosicionDTO> findAll(){
        return posicionRepository.findAll().stream().map(posicion -> new PosicionDTO(posicion)).toList();
    }

    public Optional<PosicionDTO> findById(Integer id){
        Optional<Posicion> posicion = posicionRepository.findById(id);
        return posicion.isEmpty() ? Optional.empty() : Optional.of(new PosicionDTO(posicion.get()));
    }

    public PosicionDTO add(PosicionDTO posicionDTO){
        Posicion posicion = posicionDTO.toPosicion();
        Vehiculo vehiculo = vehiculoRepository.findById(posicionDTO.getVehiculo())
                .orElseThrow(() -> new EntityNotFoundException("Vehiculo no encontrado"));
        posicion.setVehiculo(vehiculo);
        posicion = posicionRepository.save(posicion);
        return new PosicionDTO(posicion);
    }
}
