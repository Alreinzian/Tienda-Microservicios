package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Inventario;
import com.msvc.tienda.repository.InventarioRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class InventarioService {

    @Autowired
    private InventarioRepository repositorio;

    public Inventario crear(Inventario inventario) {
        return repositorio.save(inventario);
    }

    public List<Inventario> buscarTodo() {
        return (List<Inventario>) repositorio.findAll();
    }

    public Inventario buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public Inventario actualizar(Inventario inventarioActualizar) {
        Inventario inventarioActual = repositorio.findById(inventarioActualizar.getId_inventario()).get();

        inventarioActual.setId_inventario(inventarioActualizar.getId_inventario());
        inventarioActual.setId_producto(inventarioActualizar.getId_producto());
        inventarioActual.setCantidad(inventarioActualizar.getCantidad());
        inventarioActual.setNombre(inventarioActualizar.getNombre());
        inventarioActual.setFechaingreso(inventarioActualizar.getFechaingreso());
        inventarioActual.setFechaactualizacion(inventarioActualizar.getFechaactualizacion());
        inventarioActual.setProveedor(inventarioActualizar.getProveedor());
        inventarioActual.setPreciocompra(inventarioActualizar.getPreciocompra());
        inventarioActual.setPrecioventa(inventarioActualizar.getPrecioventa());
        inventarioActual.setLote(inventarioActualizar.getLote());
        inventarioActual.setNotas(inventarioActualizar.getNotas());

        Inventario inventarioActualizado = repositorio.save(inventarioActual);
        return inventarioActualizado;
    }

    public void eliminarInventario(Integer id) {
        repositorio.deleteById(id);
    }
}