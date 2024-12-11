package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PAGO database table.
 * 
 */
@Entity
@Table(name="PAGO")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PagoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PAGO")
	private Date fechaPago;

	@Column(name="FORMA_PAGO")
	private String formaPago;

	@Column(name="TOTAL")
	private double total;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="CODIGO_CLIENTE")
	private Cliente cliente;

	public Pago() {
	}

	public PagoPK getId() {
		return this.id;
	}

	public void setId(PagoPK id) {
		this.id = id;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", fechaPago=" + fechaPago + ", formaPago=" + formaPago + ", total=" + total + "]";
	}

	
}