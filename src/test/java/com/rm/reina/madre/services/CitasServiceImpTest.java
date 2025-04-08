package com.rm.reina.madre.services;

import com.rm.reina.madre.services.entity.Cita;
import com.rm.reina.madre.services.repository.CitaRepository;
import com.rm.reina.madre.services.service.serviceImp.CitasServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CitasServiceImpTest {

    private CitaRepository repository;
    private CitasServiceImp service;

    @BeforeEach
    void setUp() {
        repository = mock(CitaRepository.class);
        service = new CitasServiceImp(repository);
    }

    @Test
    void getAll_ShouldReturnAllCitas() {
        Cita cita1 = new Cita();
        Cita cita2 = new Cita();
        when(repository.findAll()).thenReturn(Arrays.asList(cita1, cita2));

        List<Cita> citas = service.getAll();

        assertEquals(2, citas.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void create_ShouldSaveAndReturnCita() {
        Cita cita = new Cita();
        when(repository.save(cita)).thenReturn(cita);

        Cita result = service.create(cita);

        assertEquals(cita, result);
        verify(repository).save(cita);
    }

    @Test
    void getById_ShouldReturnCitaIfExists() {
        Cita cita = new Cita();
        cita.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(cita));

        Optional<Cita> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void update_ShouldUpdateExistingCita() {
        Cita original = new Cita();
        original.setId(1L);
        original.setNombre("Paciente 1");

        Cita updated = new Cita();
        updated.setNombre("Paciente actualizado");
        updated.setFecha(LocalDate.now());
        updated.setHora(LocalTime.now());
        updated.setNumeroCita("1234");
        updated.setNombreMedico("Dr. House");
        updated.setTipo("Consulta");

        when(repository.findById(1L)).thenReturn(Optional.of(original));
        when(repository.save(any(Cita.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Cita result = service.update(1L, updated);

        assertEquals("Paciente actualizado", result.getNombre());
        assertEquals("1234", result.getNumeroCita());
        assertEquals("Dr. House", result.getNombreMedico());
        verify(repository).save(original);
    }

    @Test
    void delete_ShouldCallDeleteById() {
        service.delete(1L);
        verify(repository).deleteById(1L);
    }
}