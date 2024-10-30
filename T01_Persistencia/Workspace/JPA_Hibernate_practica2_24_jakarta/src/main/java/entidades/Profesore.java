package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Profesores database table.
 * 
 */
@Entity
@Table(name="Profesores")
@NamedQuery(name="Profesore.findAll", query="SELECT p FROM Profesore p")
public class Profesore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Especialidad")
	private String especialidad;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Clas
	@OneToMany(mappedBy="profesore")
	private List<Clase> clases;

	public Profesore() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase addClas(Clase clase) {
		getClases().add(clase);
		clase.setProfesore(this);

		return clase;
	}

	public Clase removeClas(Clase clase) {
		getClases().remove(clase);
		clase.setProfesore(null);

		return clase;
	}

}