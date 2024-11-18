package com.example.tp3clever.services;

import com.example.tp3clever.dtos.InteresadoDTO;
import com.example.tp3clever.entity.Interesado;
import com.example.tp3clever.repository.InteresadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteresadoService {
    private InteresadoRepository interesadoRepository;

    @Autowired
    public InteresadoService(InteresadoRepository repository) {
        this.interesadoRepository = repository;
    }

    public List<InteresadoDTO> findAll(){
        return interesadoRepository.findAll().stream().map(interesado -> new InteresadoDTO(interesado)).toList();
    }

    public Optional<InteresadoDTO> findById(Integer id){
        Optional<Interesado> interesado = interesadoRepository.findById(id);

        return interesado.isEmpty() ? Optional.empty() : Optional.of(new InteresadoDTO(interesado.get()));
    }

    public InteresadoDTO add(InteresadoDTO interesadoDTO){
        Interesado interesado = interesadoDTO.toInteresado();
        interesado = interesadoRepository.save(interesado);
        return new InteresadoDTO(interesado);
    }
}
