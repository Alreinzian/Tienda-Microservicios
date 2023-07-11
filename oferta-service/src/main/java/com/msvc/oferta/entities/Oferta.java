package com.msvc.oferta.entities;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ofertas")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional =false)
    @Column(name = "id_oferta")
    private String ofertaId;

    @Basic(optional = false)
	@Column(name = "titulo")
    private String titulo;

    @Basic(optional = false)
	@Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
	@Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Basic(optional = false)
	@Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Basic(optional = false)
	@Column(name = "descuento")
    private double descuento;

    @Basic(optional = false)
	@Column(name = "codigo_promocion")
    private String codigoPromocion;

    @Basic(optional = false)
	@Column(name = "producto_servicio")
    private String productoServicio;

    @Basic(optional = false)
	@Column(name = "cantidad_disponible")
    private int cantidadDisponible;

    @Basic(optional = false)
	@Column(name = "estado")
    private String estado;
    
   @Transient //Indica que no se dbe persistir la lista en la base de datos
    private List<Producto> productos = new ArrayList<>();
}
