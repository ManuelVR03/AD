package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
@Table(name="EMPLEADO")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_EMPLEADO")
	private int codigoEmpleado;

	@Column(name="APELLIDO1")
	private String apellido1;

	@Column(name="APELLIDO2")
	private String apellido2;

	@Column(name="EMAIL")
	private String email;

	@Column(name="EXTENSION")
	private String extension;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PUESTO")
	private String puesto;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="empleado")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="CODIGO_JEFE")
	private Empleado empleado;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="empleado")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Oficina
	@ManyToOne
	@JoinColumn(name="CODIGO_OFICINA")
	private Oficina oficina;

	public Empleado() {
	}

	public int getCodigoEmpleado() {
		return this.codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setEmpleado(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setEmpleado(null);

		return cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setEmpleado(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setEmpleado(null);

		return empleado;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	@Override
	public String toString() {
		return "Empleado [codigoEmpleado=" + codigoEmpleado + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", email=" + email + ", extension=" + extension + ", nombre=" + nombre + ", puesto=" + puesto + "]";
	}
	
	

}