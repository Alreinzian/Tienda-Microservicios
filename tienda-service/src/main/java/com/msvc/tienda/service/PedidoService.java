package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Pedido;
import com.msvc.tienda.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repositorio;

    public Pedido crear(Pedido pedido) {
        return repositorio.save(pedido);
    }

    public List<Pedido> buscarTodo() {
        return (List<Pedido>) repositorio.findAll();
    }

    public Pedido buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public Pedido actualizar(Pedido pedidoActualizar) {
        Pedido pedidoActual = repositorio.findById(pedidoActualizar.getId_pedido()).get();

        pedidoActual.setFechaPedido(pedidoActualizar.getFechaPedido());
        pedidoActual.setFechaEntrega(pedidoActualizar.getFechaEntrega());
        pedidoActual.setId_cliente(pedidoActualizar.getId_cliente());
        pedidoActual.setId_pago(pedidoActualizar.getId_pago());
        pedidoActual.setId_despacho(pedidoActualizar.getId_despacho());

        Pedido pedidoActualizado = repositorio.save(pedidoActual);
        return pedidoActualizado;
    }

    public void eliminarPedido(Integer id) {
        repositorio.deleteById(id);
    }
}

