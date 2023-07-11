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
@Table(name = "detalle")
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
    @NamedQuery(name = "Detalle.findById_detalle", query = "SELECT d FROM Detalle d WHERE d.id_detalle = :id_detalle"),
    @NamedQuery(name = "Detalle.findById_pedido", query = "SELECT d FROM Detalle d WHERE d.id_pedido = :id_pedido"),
    @NamedQuery(name = "Detalle.findById_producto", query = "SELECT d FROM Detalle d WHERE d.id_producto = :id_producto"),
    @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detalle.findByPrecio_unitario", query = "SELECT d FROM Detalle d WHERE d.precio_unitario = :precio_unitario"),
    @NamedQuery(name = "Detalle.findByTotal", query = "SELECT d FROM Detalle d WHERE d.total = :total")
})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer id_detalle;


    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedido id_pedido;
    
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto id_producto;

    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    @Basic(optional = false)
    @Column(name = "precio_unitario")
    private double precio_unitario;

    @Basic(optional = false)
    @Column(name = "total")
    private double total;

}
