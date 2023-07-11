package com.msvc.tienda.entity;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventario")
@NamedQueries({
        @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
        @NamedQuery(name = "Inventario.findById_inventario", query = "SELECT i FROM Inventario i WHERE i.id_inventario = :id_inventario"),
        @NamedQuery(name = "Inventario.findById_producto", query = "SELECT i FROM Inventario i WHERE i.id_producto = :id_producto"),
        @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
        @NamedQuery(name = "Inventario.findByUbicacion", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre"),
        @NamedQuery(name = "Inventario.findByFechaIngreso", query = "SELECT i FROM Inventario i WHERE i.fechaingreso = :fechaingreso"),
        @NamedQuery(name = "Inventario.findByFechaActualizacion", query = "SELECT i FROM Inventario i WHERE i.fechaactualizacion = :fechaactualizacion"),
        @NamedQuery(name = "Inventario.findByProveedor", query = "SELECT i FROM Inventario i WHERE i.proveedor = :proveedor"),
        @NamedQuery(name = "Inventario.findByPrecioCompra", query = "SELECT i FROM Inventario i WHERE i.preciocompra = :preciocompra"),
        @NamedQuery(name = "Inventario.findByPrecioVenta", query = "SELECT i FROM Inventario i WHERE i.precioventa = :precioventa"),
        @NamedQuery(name = "Inventario.findByLote", query = "SELECT i FROM Inventario i WHERE i.lote = :lote"),
        @NamedQuery(name = "Inventario.findByNotas", query = "SELECT i FROM Inventario i WHERE i.notas = :notas")
})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario")
    private Integer id_inventario;

    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto id_producto;


    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "fechaingreso")
    private String fechaingreso;

    @Basic(optional = false)
    @Column(name = "fechaactualizacion")
    private String fechaactualizacion;

    @Basic(optional = false)
    @Column(name = "proveedor")
    private String proveedor;

    @Basic(optional = false)
    @Column(name = "preciocompra")
    private Double preciocompra;

    @Basic(optional = false)
    @Column(name = "precioventa")
    private Double precioventa;

    @Basic(optional = false)
    @Column(name = "lote")
    private String lote;

    @Basic(optional = false)
    @Column(name = "notas")
    private String notas;

}