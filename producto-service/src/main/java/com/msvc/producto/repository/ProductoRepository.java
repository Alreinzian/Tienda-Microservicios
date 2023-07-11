package com.msvc.producto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msvc.producto.entities.Producto;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto,Long> {

    List<Producto> findByOfertaId(String ofertaId);
    //List<Calificacion> findByHotelId(String hotelId);
}
