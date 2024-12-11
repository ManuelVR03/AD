package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Entity
@Table(name="CLIENTE")
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="ClientesMadrid", query="SELECT c FROM Cliente c WHERE c.ciudad = 'Madrid'"),
	@NamedQuery(name="ClientesUSA", query="SELECT c FROM Cliente c WHERE c.pais = 'USA'")
})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String CLIENTES_ESTADOUNIDENSES = "ClientesUSA";

	@Id
	@Column(name="CODIGO_CLIENTE")
	private int codigoCliente;

	@Column(name="APELLIDO_CONTACTO")
	private String apellidoContacto;

	@Column(name="CIUDAD")
	private String ciudad;

	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name="FAX")
	private String fax;

	@Column(name="LIMITE_CREDITO")
	private double limiteCredito;

	@Column(name="LINEA_DIRECCION1")
	private String lineaDireccion1;

	@Column(name="LINEA_DIRECCION2")
	private String lineaDireccion2;

	@Column(name="NOMBRE_CLIENTE")
	private String nombreCliente;

	@Column(name="NOMBRE_CONTACTO")
	private String nombreContacto;

	@Column(name="PAIS")
	private String pais;

	@Column(name="REGION")
	private String region;

	@Column(name="TELEFONO")
	private String telefono;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="CODIGO_EMPLEADO_REP_VENTAS")
	private Empleado empleado;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="cliente")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public int getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getApellidoContacto() {
		return this.apellidoContacto;
	}

	public void setApellidoContacto(String apellidoContacto) {
		this.apellidoContacto = apellidoContacto;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public double getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getLineaDireccion1() {
		return this.lineaDireccion1;
	}

	public void setLineaDireccion1(String lineaDireccion1) {
		this.lineaDireccion1 = lineaDireccion1;
	}

	public String getLineaDireccion2() {
		return this.lineaDireccion2;
	}

	public void setLineaDireccion2(String lineaDireccion2) {
		this.lineaDireccion2 = lineaDireccion2;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setCliente(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setCliente(null);

		return pago;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", apellidoContacto=" + apellidoContacto + ", ciudad="
				+ ciudad + ", codigoPostal=" + codigoPostal + ", fax=" + fax + ", limiteCredito=" + limiteCredito
				+ ", lineaDireccion1=" + lineaDireccion1 + ", lineaDireccion2=" + lineaDireccion2 + ", nombreCliente="
				+ nombreCliente + ", nombreContacto=" + nombreContacto + ", pais=" + pais + ", region=" + region
				+ ", telefono=" + telefono + "]";
	}
	
	

}