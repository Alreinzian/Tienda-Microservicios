package com.msvc.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.msvc.tienda.entity.Despacho;
import com.msvc.tienda.service.DespachoService;


@RestController
@RequestMapping("/despacho")
public class DespachoRestController {

    @Autowired
    private DespachoService despachoservice; //no estoy empleando servicio sino despachoservice

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Despacho> listaDespachos = despachoservice.buscarTodo();
        return new ResponseEntity<>(listaDespachos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Despacho despacho = despachoservice.buscarPorId(id);
        if (despacho == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despacho no encontrado, el ID proporcionado no es correcto");
        return new ResponseEntity<>(despacho, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> crear(@RequestBody Despacho despacho) {
    	despachoservice.crear(despacho);
        return new ResponseEntity<>("Despacho creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Despacho despacho) {
    	despachoservice.actualizar(despacho);
        return new ResponseEntity<>("Despacho actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
    	despachoservice.eliminarDespacho(id);
        return new ResponseEntity<>("Despacho eliminado correctamente", HttpStatus.OK);
    }
}

