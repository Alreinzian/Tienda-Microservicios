package com.msvc.oferta.oferta.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.msvc.oferta.oferta.entities.Oferta;
import com.msvc.oferta.oferta.service.OfertaService;

import java.util.List;

@RestController
@RequestMapping("/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @PostMapping
    public ResponseEntity<Oferta> guardarOferta(@RequestBody Oferta ofertaRequest){
        Oferta oferta = ofertaService.saveOferta(ofertaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(oferta);
    }

    @GetMapping("/{ofertaId}")
    public ResponseEntity<Oferta> obtenerOferta(@PathVariable String ofertaId){
        Oferta oferta = ofertaService.getOferta(ofertaId);
        return ResponseEntity.ok(oferta);
    }

    @GetMapping
    public ResponseEntity<List<Oferta>> listarOfertas(){
        List<Oferta> ofertas = ofertaService.getAllOfertas();
        return ResponseEntity.ok(ofertas);
    }
}
