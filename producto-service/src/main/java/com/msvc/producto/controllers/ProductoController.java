package com.msvc.producto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.msvc.producto.entities.Producto;
import com.msvc.producto.services.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.create(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/ofertas/{ofertaId}")
    public ResponseEntity<List<Producto>> listarProductosPorOfertaId(@PathVariable String ofertaId){
        return ResponseEntity.ok(productoService.getProductosByOfertaId(ofertaId));
    }

    
}
