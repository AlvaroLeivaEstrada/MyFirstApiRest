/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leivaEstrada.MyfirstApiRest.controller;

import com.mycompany.dependencyproyect1.dao.entity.Disco;
import com.mycompany.dependencyproyect1.dao.repository.DiscoRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fercholeiva
 */
@RestController
public class DiscoController {

    Logger log = LoggerFactory.getLogger(DiscoController.class);

    DiscoRepository discoHandler = new DiscoRepository();

    @GetMapping(path = "/disco/{idDisco}")    
    private Disco getDiscoById(@PathVariable int idDisco) {
        Disco disco = discoHandler.findByid(idDisco);

        return disco;

    }
    
    @GetMapping(path = "/disco/findAll")
    private List<Disco> getDiscos() {
   
        return discoHandler.findAll();

    }
   
    @PostMapping(path = "/disco/add")
  
    private String setDisco(@RequestBody Disco disco) {

        discoHandler.save(disco.getTipoDisco().getIdTIPODISCO(),disco.getTipoFormato().getIdTIPOFORMATO(),disco.getComentario(),disco.getUbicacion());

        return " Almacenado en BD";

    }

}
