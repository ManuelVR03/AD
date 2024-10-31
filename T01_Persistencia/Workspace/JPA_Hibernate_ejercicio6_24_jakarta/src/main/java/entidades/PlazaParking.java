package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAZAPARKING", catalog = "ejercicio6")
public class PlazaParking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMPLAZA", unique = true, nullable = false)
	private String numPlaza;

	@Column(name = "PLANTA")
	private Integer planta;

	@Column(name = "LUGAR")
	private Integer lugar;

	@OneToOne(mappedBy = "plaza")
	@JoinColumn(unique = true, nullable = false, updatable = false)
	private Empleado empleado;

	public PlazaParking() {
	}

	public PlazaParking(String numPlaza, Integer planta, Integer lugar) {
		this.numPlaza = numPlaza;
		this.planta = planta;
		this.lugar = lugar;
	}

	public PlazaParking(String numPlaza, Integer planta, Integer lugar, Empleado empleado) {
		this.numPlaza = numPlaza;
		this.planta = planta;
		this.lugar = lugar;
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getNumPlaza() {
		return numPlaza;
	}

	public void setNumPlaza(String numPlaza) {
		this.numPlaza = numPlaza;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public Integer getLugar() {
		return lugar;
	}

	public void setLugar(Integer lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return "PlazaParking [numPlaza=" + numPlaza + ", planta=" + planta + ", lugar=" + lugar + "]";
	}
	
	

}
