package com.rm.reina.madre.services.service;


import com.rm.reina.madre.services.entity.Cita;
import java.util.List;
import java.util.Optional;

public interface ICitasService {
    List<Cita> getAll();
    Cita create(Cita cita);
    Optional<Cita> getById(Long id);
    Cita update(Long id, Cita citaDetails);
    void delete(Long id);
}
