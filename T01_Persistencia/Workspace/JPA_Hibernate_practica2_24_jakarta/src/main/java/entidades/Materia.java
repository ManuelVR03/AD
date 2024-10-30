package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Materias database table.
 * 
 */
@Entity
@Table(name="Materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to EstudiantesMateria
	@OneToMany(mappedBy="materia")
	private List<EstudiantesMateria> estudiantesMaterias;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EstudiantesMateria> getEstudiantesMaterias() {
		return this.estudiantesMaterias;
	}

	public void setEstudiantesMaterias(List<EstudiantesMateria> estudiantesMaterias) {
		this.estudiantesMaterias = estudiantesMaterias;
	}

	public EstudiantesMateria addEstudiantesMateria(EstudiantesMateria estudiantesMateria) {
		getEstudiantesMaterias().add(estudiantesMateria);
		estudiantesMateria.setMateria(this);

		return estudiantesMateria;
	}

	public EstudiantesMateria removeEstudiantesMateria(EstudiantesMateria estudiantesMateria) {
		getEstudiantesMaterias().remove(estudiantesMateria);
		estudiantesMateria.setMateria(null);

		return estudiantesMateria;
	}

}