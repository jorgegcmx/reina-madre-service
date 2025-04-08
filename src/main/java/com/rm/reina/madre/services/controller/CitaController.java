package com.rm.reina.madre.services.controller;


import com.rm.reina.madre.services.entity.Cita;
import com.rm.reina.madre.services.service.ICitasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/citas")
public class CitaController {


    private ICitasService service;

    public CitaController(ICitasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cita> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Cita create(@RequestBody Cita cita) {
        return service.create(cita);
    }

    @GetMapping("/{id}")
    public Optional<Cita> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Cita update(@PathVariable Long id, @RequestBody Cita citaDetails) {
         return service.update(id,citaDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}