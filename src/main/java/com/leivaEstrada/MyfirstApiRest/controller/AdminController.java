/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leivaEstrada.MyfirstApiRest.controller;

import com.mycompany.dependencyproyect1.dao.entity.Asignatura;
import com.mycompany.dependencyproyect1.dao.entity.Directorio;
import com.mycompany.dependencyproyect1.dao.entity.Programa;
import com.mycompany.dependencyproyect1.dao.entity.TipoDisco;
import com.mycompany.dependencyproyect1.dao.entity.TipoDocumento;
import com.mycompany.dependencyproyect1.dao.entity.TipoFormato;
import com.mycompany.dependencyproyect1.dao.repository.AsignaturaRespository;
import com.mycompany.dependencyproyect1.dao.repository.DirectorioRepository;
import com.mycompany.dependencyproyect1.dao.repository.ProgramaRepository;
import com.mycompany.dependencyproyect1.dao.repository.TipoDiscoRepository;
import com.mycompany.dependencyproyect1.dao.repository.TipoDocumentoRepository;
import com.mycompany.dependencyproyect1.dao.repository.TipoFormatoRepository;
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
public class AdminController {

    Logger log = LoggerFactory.getLogger(AdminController.class);
    DirectorioRepository directorioHandler = new DirectorioRepository();
    TipoDiscoRepository tipoDiscoHandler = new TipoDiscoRepository();
    ProgramaRepository programaHandler = new ProgramaRepository();
    TipoFormatoRepository tipoFormatoHandler = new TipoFormatoRepository();
    TipoDocumentoRepository tipoDocumentoHandler = new TipoDocumentoRepository();
    AsignaturaRespository asignaturaHandler = new AsignaturaRespository();
    

    @GetMapping(path = "/usuario/{usu}")
    private String getNombre(@PathVariable String usu) {
        log.info("usuario recibido:{}", usu);

        return usu + " recibido";

    }

    @PostMapping(path = "/admin/directorio")
    private String getNombre(@RequestBody Directorio directorio) {
        
        directorioHandler.save(directorio.getNombre());

        return directorio.getNombre()+ " Almacenado en BD";

    }

    @PostMapping(path = "/admin/tipDisco")
    private String getNombre(@RequestBody TipoDisco tipoDisco) {
        tipoDiscoHandler.save(tipoDisco.getNombre());

        return tipoDisco.getNombre()+" Almacenado en BD";

    }

    @PostMapping(path = "/admin/programa")
    private String getNombre(@RequestBody Programa programa) {
        programaHandler.save(programa.getNombre(),programa.getNombrecorto(),programa.getVersion(),programa.getFabricante());

        return programa.getNombre()+" Programa Almacenado en BD";

    }

    @PostMapping(path = "/admin/tipoFormato")
    private String getNombre(@RequestBody TipoFormato tipoFormato) {
        tipoFormatoHandler.save(tipoFormato.getNombre());
        return " Almacenado en BD ";
    }

    @PostMapping(path = "/admin/tipoDocumento")
    private String getNombre(@RequestBody TipoDocumento tipoDocumento) {
        //log.info("nombre recibido:{}", tipoDocumento.getNombre());
        tipoDocumentoHandler.save(tipoDocumento.getNombre());
        return " Almacenado en BD";
    }
    @PostMapping(path = "/admin/asignatura")
    private String getNombre(@RequestBody Asignatura asigantura) {
        asignaturaHandler.save(asigantura);
        return " Almacenado en BD";
    }

}
