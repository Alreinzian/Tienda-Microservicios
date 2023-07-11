package com.msvc.producto.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.msvc.producto.entities.Producto;
import com.msvc.producto.repository.ProductoRepository;
import com.msvc.producto.services.ProductoService;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

 
	@Override
	public List<Producto> getProductosByOfertaId(String ofertaId) {
		// TODO Auto-generated method stub
		return productoRepository.findByOfertaId(ofertaId);
	}

  
	

	
}
