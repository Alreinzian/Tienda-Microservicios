package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Metodo;
import com.msvc.tienda.repository.MetodoRepository;

@Service
public class MetodoService {

    @Autowired
    private MetodoRepository metodoRepository;

    public Metodo crear(Metodo metodo) {
        return metodoRepository.save(metodo);
    }

    public List<Metodo> buscarTodo() {
        return (List<Metodo>) metodoRepository.findAll();
    }

    public Metodo buscarPorId(Integer id) {
        return metodoRepository.findById(id).orElse(null);
    }

    public Metodo actualizar(Metodo metodoActualizar) {
        Metodo metodoActual = metodoRepository.findById(metodoActualizar.getId_pago()).orElse(null);

        if (metodoActual != null) {
            metodoActual.setNmpago(metodoActualizar.getNmpago());
            metodoActual.setDescripcion(metodoActualizar.getDescripcion());
            return metodoRepository.save(metodoActual);
        }

        return null;
    }

    public void eliminarMetodo(Integer id) {
        metodoRepository.deleteById(id);
    }
}
