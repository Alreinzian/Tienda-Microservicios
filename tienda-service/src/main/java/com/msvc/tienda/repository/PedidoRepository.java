package com.msvc.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.msvc.tienda.entity.Pedido;



public interface PedidoRepository extends CrudRepository <Pedido, Integer> {

}
