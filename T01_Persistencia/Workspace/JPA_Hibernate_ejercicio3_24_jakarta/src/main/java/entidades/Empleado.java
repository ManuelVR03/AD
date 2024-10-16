package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADO", catalog = "ejercicio3")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODEMPLEADO", unique = true, nullable = false)
	private String codEmpleado;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@OneToOne
	@JoinColumn(name = "DIRECCION_FK", unique = true, nullable = false, updatable = false)
	private Direccion dir;

	public Empleado() {}

	public Empleado(String codEmpleado, String nombre, String apellidos) {
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
