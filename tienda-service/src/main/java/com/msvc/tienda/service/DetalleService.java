package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Detalle;
import com.msvc.tienda.repository.DetalleRepository;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    public Detalle crear(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    public List<Detalle> buscarTodo() {
        return (List<Detalle>) detalleRepository.findAll();
    }

    public Detalle buscarPorId(Integer id) {
        return detalleRepository.findById(id).orElse(null);
    }

    public Detalle actualizar(Detalle detalleActualizar) {
        Detalle detalleActual = detalleRepository.findById(detalleActualizar.getId_detalle()).orElse(null);

        if (detalleActual != null) {
            detalleActual.setId_pedido(detalleActualizar.getId_pedido());
            detalleActual.setId_producto(detalleActualizar.getId_producto());
            detalleActual.setCantidad(detalleActualizar.getCantidad());
            detalleActual.setPrecio_unitario(detalleActualizar.getPrecio_unitario());
            detalleActual.setTotal(detalleActualizar.getTotal());
            return detalleRepository.save(detalleActual);
        }

        return null;
    }

    public void eliminarDetalle(Integer id) {
        detalleRepository.deleteById(id);
    }
}
