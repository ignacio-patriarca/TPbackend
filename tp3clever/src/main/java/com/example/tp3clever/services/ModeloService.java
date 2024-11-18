package com.example.tp3clever.services;

import com.example.tp3clever.dtos.ModeloDTO;
import com.example.tp3clever.entity.Marca;
import com.example.tp3clever.entity.Modelo;
import com.example.tp3clever.repository.MarcaRepository;
import com.example.tp3clever.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    private ModeloRepository modeloRepository;
    private MarcaRepository marcaRepository;

    @Autowired
    public ModeloService(ModeloRepository repository, MarcaRepository marcaRepository) {
        this.modeloRepository = repository;
        this.marcaRepository = marcaRepository;
    }

    public List<ModeloDTO> findAll(){
        return modeloRepository.findAll().stream().map(modelo -> new ModeloDTO(modelo)).toList();
    }

    public Optional<ModeloDTO> findById(Integer id){
        Optional<Modelo> modelo = modeloRepository.findById(id);
        return modelo.isEmpty() ? Optional.empty() : Optional.of(new ModeloDTO(modelo.get()));
    }

    public ModeloDTO add(ModeloDTO modeloDTO){
        Modelo modelo = modeloDTO.toModelo();
        Marca marca = marcaRepository.findById(modeloDTO.getMarca())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        modelo.setMarca(marca);
        modelo = modeloRepository.save(modelo);
        return new ModeloDTO(modelo);
    }
}
