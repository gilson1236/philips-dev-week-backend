package com.dio_class.devweek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private Integer regiao_id;
    private Integer mes;
    private Long faixa_id;
    private Integer quant_exames;

    public Incidencia(Long id, Integer regiao_id, Integer mes, Long faixa_id, Integer quant_exames) {
        this.id = id;
        this.regiao_id = regiao_id;
        this.mes = mes;
        this.faixa_id = faixa_id;
        this.quant_exames = quant_exames;
    }

    public Incidencia(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegiao_id() {
        return regiao_id;
    }

    public void setRegiao_id(Integer regiao_id) {
        this.regiao_id = regiao_id;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getFaixa_id() {
        return faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        this.faixa_id = faixa_id;
    }

    public Integer getQuant_exames() {
        return quant_exames;
    }

    public void setQuant_exames(Integer quant_exames) {
        this.quant_exames = quant_exames;
    }
}
