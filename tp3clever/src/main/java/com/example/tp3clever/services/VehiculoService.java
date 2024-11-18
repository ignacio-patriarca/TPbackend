package com.example.tp3clever.services;

import com.example.tp3clever.dtos.VehiculoDTO;
import com.example.tp3clever.entity.Modelo;
import com.example.tp3clever.entity.Vehiculo;
import com.example.tp3clever.repository.ModeloRepository;
import com.example.tp3clever.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    private VehiculoRepository vehiculoRepository;
    private ModeloRepository modeloRepository;

    @Autowired
    public VehiculoService(VehiculoRepository repository, ModeloRepository modeloRepository) {
        this.vehiculoRepository = repository;
        this.modeloRepository = modeloRepository;
    }

    public List<VehiculoDTO> findAll(){
        return vehiculoRepository.findAll().stream().map(vehiculo -> new VehiculoDTO(vehiculo)).toList();
    }

    public Optional<VehiculoDTO> findById(Integer id){
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        return vehiculo.isEmpty() ? Optional.empty() : Optional.of(new VehiculoDTO(vehiculo.get()));
    }

    public VehiculoDTO add(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = vehiculoDTO.toVehiculo();
        Optional<Modelo> modelo = modeloRepository.findById(vehiculoDTO.getModelo());
        vehiculo.setModelo(modelo.get());
        vehiculo = vehiculoRepository.save(vehiculo);
        return new VehiculoDTO(vehiculo);
    }
}
