package com.msvc.producto.services;

import java.util.List;

import com.msvc.producto.entities.Producto;

public interface ProductoService {

    Producto create(Producto producto);

    List<Producto> getProductos();

    List<Producto> getProductosByOfertaId(String ofertaId);

    //List<Producto> getCalificacionesByHotelId(String hotelId);

}
