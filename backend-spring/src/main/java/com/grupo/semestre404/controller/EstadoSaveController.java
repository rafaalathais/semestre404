package com.grupo.semestre404.controller;

import com.grupo.semestre404.model.EstadoSave;
import com.grupo.semestre404.repository.EstadoSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-save")
@CrossOrigin(origins = "*")

public class EstadoSaveController {

        @Autowired
        private final EstadoSaveRepository estadoSaveRepository;
        public EstadoSaveController(EstadoSaveRepository estadoSaveRepository) {
            this.estadoSaveRepository = estadoSaveRepository;
        }

        @GetMapping
        public List<EstadoSave> getAllEstados() {
            return estadoSaveRepository.findAll();
        }

        @PostMapping("/salvar")
        public EstadoSave createEstado(@RequestBody EstadoSave estado) {
            return estadoSaveRepository.save(estado);
        }
    
}
