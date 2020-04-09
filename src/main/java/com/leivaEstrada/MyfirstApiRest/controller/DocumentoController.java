/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leivaEstrada.MyfirstApiRest.controller;

import com.mycompany.dependencyproyect1.dao.entity.Documento;
import com.mycompany.dependencyproyect1.dao.repository.DocumentoRepository;
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
public class DocumentoController {
    Logger log = LoggerFactory.getLogger(DiscoController.class);

    DocumentoRepository documentoHandler = new DocumentoRepository();

    @GetMapping(path = "/documento/{nombre}")    
    private Documento getDocumentoById(@PathVariable String nombre) {
        
        Documento documento = documentoHandler.findByid(nombre);

        return documento;

    }
    
    @GetMapping(path = "/documento/findAll")
    private List<Documento> getDocumentos() {
   
        return documentoHandler.findAll();

    }
   
    @PostMapping(path = "/documento/add")
  
    private String setDocumento(@RequestBody Documento documento) {

        documentoHandler.save(documento);

        return " Almacenado en BD";

    }
    
}
