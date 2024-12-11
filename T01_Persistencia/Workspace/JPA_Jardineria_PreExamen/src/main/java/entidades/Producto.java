package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCTO database table.
 * 
 */
@Entity
@Table(name="PRODUCTO")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_PRODUCTO")
	private String codigoProducto;

	@Column(name="CANTIDAD_EN_STOCK")
	private int cantidadEnStock;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="DIMENSIONES")
	private String dimensiones;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PRECIO_PROVEEDOR")
	private double precioProveedor;

	@Column(name="PRECIO_VENTA")
	private double precioVenta;

	@Column(name="PROVEEDOR")
	private String proveedor;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="producto")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to GamaProducto
	@ManyToOne
	@JoinColumn(name="GAMA")
	private GamaProducto gamaProducto;

	public Producto() {
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidadEnStock() {
		return this.cantidadEnStock;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDimensiones() {
		return this.dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioProveedor() {
		return this.precioProveedor;
	}

	public void setPrecioProveedor(double precioProveedor) {
		this.precioProveedor = precioProveedor;
	}

	public double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setProducto(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setProducto(null);

		return detallePedido;
	}

	public GamaProducto getGamaProducto() {
		return this.gamaProducto;
	}

	public void setGamaProducto(GamaProducto gamaProducto) {
		this.gamaProducto = gamaProducto;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", cantidadEnStock=" + cantidadEnStock + ", descripcion="
				+ descripcion + ", dimensiones=" + dimensiones + ", nombre=" + nombre + ", precioProveedor="
				+ precioProveedor + ", precioVenta=" + precioVenta + ", proveedor=" + proveedor + "]";
	}
	
	

}