package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the DETALLE_PEDIDO database table.
 * 
 */
@Entity
@Table(name="DETALLE_PEDIDO")
@NamedQuery(name="DetallePedido.findAll", query="SELECT d FROM DetallePedido d")
public class DetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallePedidoPK id;

	@Column(name="CANTIDAD")
	private int cantidad;

	@Column(name="NUMERO_LINEA")
	private int numeroLinea;

	@Column(name="PRECIO_UNIDAD")
	private double precioUnidad;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="CODIGO_PEDIDO")
	private Pedido pedido;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="CODIGO_PRODUCTO")
	private Producto producto;

	public DetallePedido() {
	}

	public DetallePedidoPK getId() {
		return this.id;
	}

	public void setId(DetallePedidoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getNumeroLinea() {
		return this.numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public double getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", cantidad=" + cantidad + ", numeroLinea=" + numeroLinea + ", precioUnidad="
				+ precioUnidad + "]";
	}
	
	

}