package com.consultorio.consultorio;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Controlador_Consul {
    private final Repositorio_Consul repository;

    Controlador_Consul(Repositorio_Consul repository) {
        this.repository = repository; }
        // Aggregate root
                 @GetMapping("/consultorio")
                     List<Consultorio> all() {
                      return repository.findAll();
                  }
                  @PostMapping("/consultorio")
                  Consultorio newConsultorio(@RequestBody Consultorio newConsultorio) {
                    return repository.save(newConsultorio);
                  }
                  // Single item
                  @GetMapping("/consultorio/{id}")
                  Consultorio one(@PathVariable Long id) {
                    return repository.findById(id)
                            .orElseThrow(() -> new NotFound_Consul(id));
                    }
                    @PutMapping("/consultorio/{id}")
                    Consultorio replaceEmployee(@RequestBody Consultorio newConsultorio, @PathVariable Long id) {
                    return repository.findById(id)
                            .map(consultorio -> {
                                consultorio.setNumero(newConsultorio.getNumero());
                                consultorio.setPiso(newConsultorio.getPiso());
                                consultorio.setEspecialidad(newConsultorio.getEspecialidad());
                                return repository.save(consultorio);
                            })
                            .orElseGet(() -> {
                                newConsultorio.setId(id);
                                return repository.save(newConsultorio);
                            });
                        }
                        @DeleteMapping("/consultorio/{id}")
                        void deleteConsultorio(@PathVariable Long id) {
                        repository.deleteById(id);
    } }
