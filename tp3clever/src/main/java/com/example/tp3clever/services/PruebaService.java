package com.example.tp3clever.services;

import com.example.tp3clever.dtos.PruebaDTO;
import com.example.tp3clever.entity.Empleado;
import com.example.tp3clever.entity.Interesado;
import com.example.tp3clever.entity.Prueba;
import com.example.tp3clever.entity.Vehiculo;
import com.example.tp3clever.exceptions.*;
import com.example.tp3clever.repository.EmpleadoRepository;
import com.example.tp3clever.repository.InteresadoRepository;
import com.example.tp3clever.repository.PruebaRepository;
import com.example.tp3clever.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PruebaService {
    private PruebaRepository repository;
    private InteresadoRepository interesadoRepository;
    private VehiculoRepository vehiculoRepository;
    private EmpleadoRepository empleadoRepository;

    @Autowired
    public PruebaService(PruebaRepository repository, InteresadoRepository interesadoRepository, VehiculoRepository vehiculoRepository, EmpleadoRepository empleadoRepository) {
        this.repository = repository;
        this.interesadoRepository = interesadoRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public  List<PruebaDTO> findAll(){
        return repository.findAll().stream().map(prueba -> new PruebaDTO(prueba)).toList();
    }

    public Optional<PruebaDTO> findById(Integer id){
        Optional<Prueba> prueba = repository.findById(id);

        return prueba.isEmpty() ? Optional.empty() : Optional.of(new PruebaDTO(prueba.get()));
    }

    public PruebaDTO add(PruebaDTO pruebaDTO){
        Interesado interesado = interesadoRepository.findById(pruebaDTO.getIdInteresado())
                .orElseThrow(() -> new InteresadoNotFoundException("Interesado no encontrado"));

        Empleado empleado = empleadoRepository.findById(pruebaDTO.getLegajoEmpleado())
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));

        Vehiculo vehiculo = vehiculoRepository.findById(pruebaDTO.getIdVehiculo())
                .orElseThrow(() -> new VehiculoNotFoundException("Vehiculo no encontrado"));

        validarLicencia(interesado);

        validarPruebaVehiculo(vehiculo);

        Prueba prueba = pruebaDTO.toPrueba();
        prueba.setInteresado(interesado);
        prueba.setVehiculo(vehiculo);
        prueba.setEmpleado(empleado);
        prueba.setFechaHoraInicio(LocalDateTime.now());
        prueba = repository.save(prueba);
        return new PruebaDTO(prueba);
    }

//    public void validarPruebaVehiculo(Vehiculo vehiculo) {
//        Optional<List<Prueba>> pruebaExistente = Optional.of(repository.findAll());
//        for (Prueba prueba : pruebaExistente.get()) {
//            if (prueba.getVehiculo().getId() == vehiculo.getId()){
//                LocalDate fechaFinPrueba = prueba.getFechaHoraFin() == null ? null : prueba.getFechaHoraFin();
//                if (fechaFinPrueba == null || fechaFinPrueba.isAfter(LocalDate.now())) {
//                    throw new EntityExistsException("El vehículo ya está siendo utilizado en una prueba activa.");
//                }
//            }
//        }
//
//    }

    public void validarPruebaVehiculo(Vehiculo vehiculo) {
        List<Prueba> pruebasVehiculo = repository.findByVehiculoId(vehiculo.getId());
        for (Prueba prueba : pruebasVehiculo) {
            LocalDateTime fechaFinPrueba = prueba.getFechaHoraFin();
            if (fechaFinPrueba == null || fechaFinPrueba.isAfter(LocalDateTime.now())) {
                throw new VehiculoEnUsoException(
                        "El vehículo con ID " + vehiculo.getId() + " ya está siendo utilizado en una prueba activa."
                );
            }
        }
    }

    private void validarLicencia(Interesado interesado) {
        LocalDateTime fechaVencimiento = interesado.getFechaVencimientoLicencia();
        LocalDateTime fechaActual = LocalDateTime.now();
        if (interesado.getRestringido() || fechaVencimiento.isBefore(fechaActual)) {
            throw new InteresadoNoValidoException("El interesado: " + interesado.getNombre() + "no puede realizar la prueba (Licencia vencida o esta restringido)");
        }
    }

    public PruebaDTO update(PruebaDTO pruebaDTO){
        Optional<Prueba> prueba = repository.findById(pruebaDTO.getId());
        if (prueba.isPresent()) {
            Prueba pruebaAux = prueba.get();
            pruebaAux.update(pruebaDTO.toPrueba());
            return pruebaDTO;
        }
        return null;
    }
}
