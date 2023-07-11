package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Despacho;
import com.msvc.tienda.repository.DespachoRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class DespachoService {

    @Autowired
    private DespachoRepository repositorio;

    public Despacho crear(Despacho despacho) {
        return repositorio.save(despacho);
    }

    public List<Despacho> buscarTodo() {
        return (List<Despacho>) repositorio.findAll();
    }

    public Despacho buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public Despacho actualizar(Despacho despachoActualizar) {
        Despacho despachoActual = repositorio.findById(despachoActualizar.getId_despacho()).get();

        despachoActual.setNombre(despachoActualizar.getNombre());
        despachoActual.setDireccionenvio(despachoActualizar.getDireccionenvio());
        despachoActual.setRazonsocial(despachoActualizar.getRazonsocial());
        despachoActual.setEstado(despachoActualizar.getEstado());

        Despacho despachoActualizado = repositorio.save(despachoActual);
        return despachoActualizado;
    }

    public void eliminarDespacho(Integer id) {
        repositorio.deleteById(id);
    }
}
