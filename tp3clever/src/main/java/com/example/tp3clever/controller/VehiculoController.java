package com.example.tp3clever.controller;

import com.example.tp3clever.dtos.VehiculoDTO;
import com.example.tp3clever.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService service) {
        this.vehiculoService = service;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> findAll() {
        List<VehiculoDTO> vehiculoDTOS = vehiculoService.findAll();
        return vehiculoDTOS.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(vehiculoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> findById(@PathVariable Integer id) {
        Optional<VehiculoDTO> vehiculoDTO = vehiculoService.findById(id);
        return vehiculoDTO.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(vehiculoDTO.get());
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> add(@RequestBody VehiculoDTO vehiculoDTO) {
        return new ResponseEntity<>(vehiculoService.add(vehiculoDTO), HttpStatus.CREATED);
    }
}
