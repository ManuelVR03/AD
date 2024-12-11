package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the OFICINA database table.
 * 
 */
@Entity
@Table(name="OFICINA")
@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_OFICINA")
	private String codigoOficina;

	@Column(name="CIUDAD")
	private String ciudad;

	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name="LINEA_DIRECCION1")
	private String lineaDireccion1;

	@Column(name="LINEA_DIRECCION2")
	private String lineaDireccion2;

	@Column(name="PAIS")
	private String pais;

	@Column(name="REGION")
	private String region;

	@Column(name="TELEFONO")
	private String telefono;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="oficina")
	private List<Empleado> empleados;

	public Oficina() {
	}

	public String getCodigoOficina() {
		return this.codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
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

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setOficina(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setOficina(null);

		return empleado;
	}

	@Override
	public String toString() {
		return "Oficina [codigoOficina=" + codigoOficina + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal
				+ ", lineaDireccion1=" + lineaDireccion1 + ", lineaDireccion2=" + lineaDireccion2 + ", pais=" + pais
				+ ", region=" + region + ", telefono=" + telefono + "]";
	}
	
	

}