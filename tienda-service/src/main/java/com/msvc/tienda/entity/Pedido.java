  package com.msvc.tienda.entity;
  
  import java.io.Serializable; 
  import java.util.Date;
  
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
import javax.persistence.OneToOne;
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
  
  @Table(name ="pedido")
  
  @NamedQueries({
  
  @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),  
  @NamedQuery(name = "Pedido.findById_pedido", query ="SELECT p FROM Pedido p WHERE p.id_pedido = :id_pedido"),  
  @NamedQuery(name = "Pedido.findByFechaPedido", query ="SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido"),  
  @NamedQuery(name = "Pedido.findByFechaEntrega", query ="SELECT p FROM Pedido p WHERE p.fechaEntrega = :fechaEntrega"),  
  @NamedQuery(name = "Pedido.findById_cliente", query ="SELECT p FROM Pedido p WHERE p.id_cliente = :id_cliente"),  
  @NamedQuery(name = "Pedido.findById_pago", query ="SELECT p FROM Pedido p WHERE p.id_pago = :id_pago"), 
  @NamedQuery(name = "Pedido.findById_despacho", query ="SELECT p FROM Pedido p WHERE p.id_despacho = :id_despacho")
  
   }) 
  
  
  public class Pedido implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_pedido") 
  private Integer id_pedido;
  
  @Basic(optional = false)
  @Column(name = "fechaPedido")
  private String fechaPedido;
  
  @Basic(optional = false)
  @Column(name = "fechaEntrega") 
  private String fechaEntrega;
  
  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @ManyToOne(optional = false) 
  private Cliente id_cliente;
 
  
  @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
  @ManyToOne(optional = false) 
  private Metodo id_pago;
  @JoinColumn(name = "id_despacho", referencedColumnName = "id_despacho")
  @OneToOne(optional = false) 
  private Despacho id_despacho;
  
  }
 
 