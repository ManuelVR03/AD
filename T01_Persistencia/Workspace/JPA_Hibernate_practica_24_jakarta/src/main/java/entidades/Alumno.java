package entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "ALUMNO", catalog = "practica")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODALU", unique = true, nullable = false)
	private Integer codAl;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO1")
	private String apellido1;
	
	@Column(name = "APELLIDO2")
	private String apellido2;
	
	@Column(name = "FNAC")
	private Date fnac;
	
	@OneToOne
	@JoinColumn(name = "EXPEDIENTE_FK", unique = true, nullable = false, updatable = false)
	private Expediente expediente;
	
	@ManyToOne
	@JoinColumn(name = "CODGRUPO_FK")
	private Grupo grupo;

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(Integer codAl, String nombre, String apellido1, String apellido2, Date fnac) {
		this.codAl = codAl;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fnac = fnac;
	}

	public Alumno(Integer codAl, String nombre, String apellido1, String apellido2, Date fnac, Expediente expediente) {
		this.codAl = codAl;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fnac = fnac;
		this.expediente = expediente;
	}

	public Alumno(Integer codAl, String nombre, String apellido1, String apellido2, Date fnac, Expediente expediente,
			Grupo grupo) {
		this.codAl = codAl;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fnac = fnac;
		this.expediente = expediente;
		this.grupo = grupo;
	}

	public Integer getCodAl() {
		return codAl;
	}

	public void setCodAl(Integer codAl) {
		this.codAl = codAl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Alumno [codAl=" + codAl + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fnac=" + fnac + "]";
	}
	
	
}
