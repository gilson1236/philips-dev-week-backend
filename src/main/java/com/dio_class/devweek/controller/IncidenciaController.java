package com.dio_class.devweek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.dio_class.devweek.entity.Incidencia;
import com.dio_class.devweek.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/api")
public class IncidenciaController {

    private final OcorrenciaRepository ocorrenciaRepository;

    public IncidenciaController(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<List<Incidencia>> findOcorrencias(){
        List<Incidencia> listaOcorrencia = ocorrenciaRepository.findAll();
        if(listaOcorrencia.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id){
        Optional<Incidencia> ocorrenciaOptional = ocorrenciaRepository.findById(id);
        if(ocorrenciaOptional.isPresent()){
            Incidencia elementoOcorrencia = ocorrenciaOptional.get();
            return new ResponseEntity<>(elementoOcorrencia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
