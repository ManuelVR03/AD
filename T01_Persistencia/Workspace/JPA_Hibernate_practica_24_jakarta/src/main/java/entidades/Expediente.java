package entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "EXPEDIENTE", catalog = "practica")
public class Expediente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODEXP", unique = true, nullable = false)
	private Integer codExp;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@OneToOne(mappedBy = "expediente")
	@JoinColumn(unique = true, nullable = false, updatable = false)
	private Alumno alumno;

	public Expediente() {
		// TODO Auto-generated constructor stub
	}

	public Expediente(Integer codExp, Date fecha, Alumno alumno) {
		this.codExp = codExp;
		this.fecha = fecha;
		this.alumno = alumno;
	}

	public Expediente(Integer codExp, Date fecha) {
		this.codExp = codExp;
		this.fecha = fecha;
	}

	public Integer getCodExp() {
		return codExp;
	}

	public void setCodExp(Integer codExp) {
		this.codExp = codExp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Expediente [codExp=" + codExp + ", fecha=" + fecha + "]";
	}
	
	
}
