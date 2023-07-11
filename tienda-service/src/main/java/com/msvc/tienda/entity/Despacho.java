package com.msvc.tienda.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Anotaciones para el uso de Lombok
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "despacho")
@NamedQueries({
        @NamedQuery(name = "Despacho.findAll", query = "SELECT d FROM Despacho d"),
        @NamedQuery(name = "Despacho.findById_despacho", query = "SELECT d FROM Despacho d WHERE d.id_despacho = :id_despacho"),
        @NamedQuery(name = "Despacho.findByNombre", query = "SELECT d FROM Despacho d WHERE d.nombre = :nombre"),
        @NamedQuery(name = "Despacho.findByDireccionenvio", query = "SELECT d FROM Despacho d WHERE d.direccionenvio = :direccionenvio"),
        @NamedQuery(name = "Despacho.findByRazonsocial", query = "SELECT d FROM Despacho d WHERE d.razonsocial = :razonsocial"),
        @NamedQuery(name = "Despacho.findByEstado", query = "SELECT d FROM Despacho d WHERE d.estado = :estado")
})
public class Despacho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_despacho")
    private Integer id_despacho;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "direccionenvio")
    private String direccionenvio;

    @Basic(optional = false)
    @Column(name = "razonsocial")
    private String razonsocial;

    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

}
