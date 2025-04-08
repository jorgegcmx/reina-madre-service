package com.rm.reina.madre.services.service.serviceImp;

import com.rm.reina.madre.services.entity.Cita;
import com.rm.reina.madre.services.repository.CitaRepository;
import com.rm.reina.madre.services.service.ICitasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasServiceImp implements ICitasService {

    private final CitaRepository repository;

    public CitasServiceImp(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cita> getAll() {
        return repository.findAll();
    }

    @Override
    public Cita create(Cita cita) {
        return repository.save(cita);
    }

    @Override
    public Optional<Cita> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cita update(Long id, Cita citaDetails) {
        Cita cita = repository.findById(id).orElseThrow();
        cita.setNombre(citaDetails.getNombre());
        cita.setFecha(citaDetails.getFecha());
        cita.setHora(citaDetails.getHora());
        cita.setNumeroCita(citaDetails.getNumeroCita());
        cita.setNombreMedico(citaDetails.getNombreMedico());
        cita.setTipo(citaDetails.getTipo());
        return repository.save(cita);
    }

    @Override
    public void delete(Long id) {
      repository.deleteById(id);
    }
}
