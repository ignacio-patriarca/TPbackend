package com.example.tp3clever.services;

import com.example.tp3clever.dtos.MarcaDTO;
import com.example.tp3clever.entity.Marca;
import com.example.tp3clever.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    private MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository repository) {
        this.marcaRepository = repository;
    }

    public List<MarcaDTO> findAll(){
        return marcaRepository.findAll().stream().map(marca -> new MarcaDTO(marca)).toList();
    }

    public Optional<MarcaDTO> findById(Integer id){
        Optional<Marca> marca = marcaRepository.findById(id);
        return marca.isEmpty() ? Optional.empty() : Optional.of(new MarcaDTO(marca.get()));
    }

    public MarcaDTO add(MarcaDTO marcaDTO){
        Marca marca = marcaDTO.toMarca();
        marca = marcaRepository.save(marca);
        return new MarcaDTO(marca);
    }
}
