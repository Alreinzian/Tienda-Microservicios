package com.msvc.oferta.entities;




import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)

public class Producto {
	

	private String productoId;
   
    private String nombre;
    
    private String descripcion;
    
    private String imagen;
   
    private double precio;
    
    private String ofertaId;

}
