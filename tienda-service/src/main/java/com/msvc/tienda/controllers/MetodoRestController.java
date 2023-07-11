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

import com.msvc.tienda.entity.Metodo;
import com.msvc.tienda.service.MetodoService;




@RestController
@RequestMapping("/rest/metodo")
public class MetodoRestController {

    @Autowired
    private MetodoService servicio;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Metodo> listaMetodos = servicio.buscarTodo();
        System.out.println("LISTA DE MÉTODOS: " + listaMetodos);
        return new ResponseEntity<>(listaMetodos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Metodo metodo = servicio.buscarPorId(id);
        if (metodo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Método no encontrado, el ID proporcionado no es correcto");
        return new ResponseEntity<Object>(metodo, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> crear(@RequestBody Metodo metodo) {
        servicio.crear(metodo);
        return new ResponseEntity<Object>("Método creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Metodo metodo) {
        servicio.actualizar(metodo);
        return new ResponseEntity<Object>("Método actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarMetodo(id);
        return new ResponseEntity<Object>("Método eliminado correctamente", HttpStatus.OK);
    }
}
