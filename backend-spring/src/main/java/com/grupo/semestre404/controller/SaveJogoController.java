package com.grupo.semestre404.controller;

import com.grupo.semestre404.model.SaveJogo;
import com.grupo.semestre404.repository.SaveJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-save")
@CrossOrigin(origins = "*")

public class SaveJogoController {

        @Autowired
        private final SaveJogoRepository estadoSaveRepository;
        public SaveJogoController(SaveJogoRepository estadoSaveRepository) {
            this.estadoSaveRepository = estadoSaveRepository;
        }

        @GetMapping
        public List<SaveJogo> getAllEstados() {
            return estadoSaveRepository.findAll();
        }

        @PostMapping("/salvar")
        public SaveJogo createEstado(@RequestBody SaveJogo estado) {
            return estadoSaveRepository.save(estado);
        }
    
}
