package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PROYECTO", catalog = "ejercicio6")
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODPROY", unique = true, nullable = false)
	private Integer codproy;
	
	@Column(name = "PNOMBRE")
	private String pnombre;
	
	@ManyToOne
	@JoinColumn(name = "CODDEPTO_FK")
	private Departamento departamento;

	public Proyecto() {
		
	}

	public Proyecto(Integer codproy, String pnombre) {
		this.codproy = codproy;
		this.pnombre = pnombre;
	}

	public Proyecto(Integer codproy, String pnombre, Departamento departamento) {
		this.codproy = codproy;
		this.pnombre = pnombre;
		this.departamento = departamento;
	}

	public Integer getCodproy() {
		return codproy;
	}

	public void setCodproy(Integer codproy) {
		this.codproy = codproy;
	}

	public String getPnombre() {
		return pnombre;
	}

	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Proyecto [codproy=" + codproy + ", pnombre=" + pnombre + "]";
	}
	
	
	
	
}
