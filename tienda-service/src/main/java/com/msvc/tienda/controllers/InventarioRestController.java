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

import com.msvc.tienda.entity.Inventario;
import com.msvc.tienda.service.InventarioService;



@RestController
@RequestMapping("/rest/inventario")
public class InventarioRestController {

    @Autowired
    private InventarioService servicio;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Inventario> listaInventarios = servicio.buscarTodo();
        return new ResponseEntity<>(listaInventarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Inventario inventario = servicio.buscarPorId(id);
        if (inventario == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Inventario no encontrado, el ID proporcionado no es correcto");
        return new ResponseEntity<Object>(inventario, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> crear(@RequestBody Inventario inventario) {
        servicio.crear(inventario);
        return new ResponseEntity<Object>("Inventario creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Inventario inventario) {
        servicio.actualizar(inventario);
        return new ResponseEntity<Object>("Inventario actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarInventario(id);
        return new ResponseEntity<Object>("Inventario eliminado correctamente", HttpStatus.OK);
    }
}
