package com.dio_class.devweek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

import com.dio_class.devweek.repository.FaixaEtariaRepository;
import com.dio_class.devweek.entity.FaixaEtaria;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {
    private final FaixaEtariaRepository faixaEtariaRepository;

    public FaixaEtariaController(FaixaEtariaRepository faixaEtariaRepository){
        this.faixaEtariaRepository = faixaEtariaRepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try {
            List<FaixaEtaria> lista = this.faixaEtariaRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findFaixaEtariaById(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> elemento = faixaEtariaRepository.findById(id);
            if(elemento.isPresent()){
                FaixaEtaria faixaEtariaElemento = elemento.get();
                return new ResponseEntity<>(faixaEtariaElemento, HttpStatus.OK);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria){
        return faixaEtariaRepository.save(faixaEtaria);
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtariaById(@PathVariable Long id){
        faixaEtariaRepository.deleteById(id);
    }
}
