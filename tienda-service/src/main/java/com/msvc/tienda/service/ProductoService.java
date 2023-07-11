package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Producto;
import com.msvc.tienda.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    public Producto crear(Producto producto) {
        return repositorio.save(producto);
    }

    public List<Producto> buscarTodo() {
        return (List<Producto>) repositorio.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public Producto actualizar(Producto productoActualizar) {
        Producto productoActual = repositorio.findById(productoActualizar.getId_producto()).get();

        productoActual.setId_producto(productoActualizar.getId_producto());
        productoActual.setNombre(productoActualizar.getNombre());
        productoActual.setDescripcion(productoActualizar.getDescripcion());
        productoActual.setPrecio(productoActualizar.getPrecio());
        productoActual.setImagen(productoActualizar.getImagen());
        productoActual.setId_despacho(productoActualizar.getId_despacho());

        Producto productoActualizado = repositorio.save(productoActual);
        return productoActualizado;
    }

    public void eliminarProducto(Integer id) {
        repositorio.deleteById(id);
    }
}
