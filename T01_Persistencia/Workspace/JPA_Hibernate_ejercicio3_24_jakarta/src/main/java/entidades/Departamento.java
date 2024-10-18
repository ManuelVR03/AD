package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO", catalog = "ejercicio3")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODDEPT", unique = true, nullable = false)
	private Integer codDep;

	@Column(name = "DNOMBRE")
	private String dnombre;

	@Column(name = "PRESU")
	private Double presu;

	@OneToMany
	@JoinColumn(name = "CODDEPTO_FK")
	private List<Empleado> empleados;

	public Departamento() {
	}
	
	

	public Departamento(String dnombre, Double presu) {
		this.dnombre = dnombre;
		this.presu = presu;
		this.empleados = new ArrayList<Empleado>();
	}



	public Departamento(Integer codDep, String dnombre, Double presu) {
		this.codDep = codDep;
		this.dnombre = dnombre;
		this.presu = presu;
		this.empleados = new ArrayList<Empleado>();
	}

	public Integer getCodDep() {
		return codDep;
	}

	public void setCodDep(Integer codDep) {
		this.codDep = codDep;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public Double getPresu() {
		return presu;
	}

	public void setPresu(Double presu) {
		this.presu = presu;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado e) {
		this.empleados.add(e);
	}
	
	public void removeEmpleado(Empleado e) {
		this.empleados.remove(e);
	}

	@Override
	public String toString() {
		return "Departamento [codDep=" + codDep + ", dnombre=" + dnombre + ", presu=" + presu + "]";
	}

}
