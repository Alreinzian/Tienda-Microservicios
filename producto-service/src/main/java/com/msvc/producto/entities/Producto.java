package com.msvc.producto.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("productos")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)

public class Producto {
	
	@Id
	private String productoId;
   
    private String nombre;
    
    private String descripcion;
    
    private String imagen;
   
    private double precio;
    
    private String ofertaId;

}
