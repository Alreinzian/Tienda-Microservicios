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

import com.msvc.tienda.entity.Detalle;
import com.msvc.tienda.service.DetalleService;




@RestController
@RequestMapping("detalle")
public class DetalleRestController {

    @Autowired
    private DetalleService servicio;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Detalle> listaDetalles = servicio.buscarTodo();
        System.out.println("LISTA DE DETALLES: " + listaDetalles);
        return new ResponseEntity<>(listaDetalles, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Detalle detalle = servicio.buscarPorId(id);
        if (detalle == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle no encontrado, el ID proporcionado no es correcto");
        return new ResponseEntity<Object>(detalle, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> crear(@RequestBody Detalle detalle) {
        servicio.crear(detalle);
        return new ResponseEntity<Object>("Detalle creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Detalle detalle) {
        servicio.actualizar(detalle);
        return new ResponseEntity<Object>("Detalle actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarDetalle(id);
        return new ResponseEntity<Object>("Detalle eliminado correctamente", HttpStatus.OK);
    }
}
