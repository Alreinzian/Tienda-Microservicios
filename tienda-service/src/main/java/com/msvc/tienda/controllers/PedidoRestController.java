package com.msvc.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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

import com.msvc.tienda.entity.Pedido;
import com.msvc.tienda.service.PedidoService;




@RestController
@RequestMapping("/pedido")
public class PedidoRestController {

    @Autowired
    private PedidoService servicio;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Pedido> listaPedidos = servicio.buscarTodo();
        System.out.println("LISTA DE PEDIDOS: " + listaPedidos);
        return new ResponseEntity<>(listaPedidos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Pedido pedido = servicio.buscarPorId(id);
        if (pedido == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado, el ID proporcionado no es correcto");
        return new ResponseEntity<Object>(pedido, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> crear(@RequestBody Pedido pedido) {
        servicio.crear(pedido);
        return new ResponseEntity<Object>("Pedido creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Pedido pedido) {
        servicio.actualizar(pedido);
        return new ResponseEntity<Object>("Pedido actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarPedido(id);
        return new ResponseEntity<Object>("Pedido eliminado correctamente", HttpStatus.OK);
    }
}
