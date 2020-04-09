/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leivaEstrada.MyfirstApiRest.controller;

import com.mycompany.dependencyproyect1.dao.entity.Directorio;
import com.mycompany.dependencyproyect1.dao.entity.Disco;
import com.mycompany.dependencyproyect1.dao.entity.TipoDisco;
import com.mycompany.dependencyproyect1.dao.entity.TipoFormato;
import com.mycompany.dependencyproyect1.dao.repository.DiscoRepository;
import com.mycompany.dependencyproyect1.dao.repository.TipoDiscoRepository;
import com.mycompany.dependencyproyect1.dao.repository.TipoFormatoRepository;
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
    TipoDiscoRepository tipoDisco = new TipoDiscoRepository();
    TipoFormatoRepository tipoFormato = new TipoFormatoRepository();
    DiscoRepository discoHandler = new DiscoRepository();

    /*
    @GetMapping(path = "/usuario/{usu}")
    private String getNombre(@PathVariable String usu) {
        log.info("usuario recibido:{}", usu);

        return usu + " recibido";

    }*/
    @GetMapping(path = "/disco/tipodiscos/findAll")
    private List<TipoDisco> listTipoDiscos() {
        List<TipoDisco> listTipoDisco = tipoDisco.findAll();
        return listTipoDisco;

    }

    @GetMapping(path = "/disco/tipoformatos/findAll")
    private List<TipoFormato> listTipoFormato() {
        List<TipoFormato> listTipoFormato = tipoFormato.findAll();
        return listTipoFormato;

    }
    @PostMapping(path = "/disco/add")
  
    private String setDisco(@RequestBody Disco disco) {

        discoHandler.save(disco.getTipoDisco().getIdTIPODISCO(),disco.getTipoFormato().getIdTIPOFORMATO(),disco.getComentario(),disco.getUbicacion());

        return " Almacenado en BD";

    }

}
