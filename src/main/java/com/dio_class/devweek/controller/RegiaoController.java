package com.dio_class.devweek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

import com.dio_class.devweek.entity.Regiao;
import com.dio_class.devweek.repository.RegiaoRepository;

@RestController
@RequestMapping("/api")
public class RegiaoController {

    private final RegiaoRepository regiaoRepository;

    public RegiaoController(RegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }

    @GetMapping("/regiao")
    public ResponseEntity<?> getRegioes(){
        try{
            List<Regiao> todasRegioes = regiaoRepository.findAll();
            if(todasRegioes.isEmpty()){
                System.out.println("Lista vazia");
            }
            return new ResponseEntity<>(todasRegioes, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<Regiao> getRegiaoById(@PathVariable Long id){
        Optional<Regiao> regiaoEscolhida = regiaoRepository.findById(id);
        if(regiaoEscolhida.isPresent()){
            Regiao regiaoUnid = regiaoEscolhida.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public void postRegiao(@RequestBody Regiao newRegiao){
        regiaoRepository.save(newRegiao);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiaoById(@PathVariable Long id){
        regiaoRepository.deleteById(id);
    }
}
