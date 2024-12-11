package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PEDIDO database table.
 * 
 */
@Entity
@Table(name="PEDIDO")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_PEDIDO")
	private int codigoPedido;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="ESTADO")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ENTREGA")
	private Date fechaEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ESPERADA")
	private Date fechaEsperada;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PEDIDO")
	private Date fechaPedido;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="pedido")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="CODIGO_CLIENTE")
	private Cliente cliente;

	public Pedido() {
	}

	public int getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaEsperada() {
		return this.fechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setPedido(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setPedido(null);

		return detallePedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", comentarios=" + comentarios + ", estado=" + estado
				+ ", fechaEntrega=" + fechaEntrega + ", fechaEsperada=" + fechaEsperada + ", fechaPedido=" + fechaPedido
				+ "]";
	}
	
	

}