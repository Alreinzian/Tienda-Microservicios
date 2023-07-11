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
@Table(name = "metodo")
@NamedQueries({
    @NamedQuery(name = "Metodo.findAll", query = "SELECT m FROM Metodo m"),
    @NamedQuery(name = "Metodo.findById_pago", query = "SELECT m FROM Metodo m WHERE m.id_pago = :id_pago"),
    @NamedQuery(name = "Metodo.findByNmpago", query = "SELECT m FROM Metodo m WHERE m.nmpago = :nmpago"),
    @NamedQuery(name = "Metodo.findByDescripcion", query = "SELECT m FROM Metodo m WHERE m.descripcion = :descripcion")
    
})
public class Metodo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer id_pago;

    @Basic(optional = false)
    @Column(name = "nmpago")
    private String nmpago;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

}
