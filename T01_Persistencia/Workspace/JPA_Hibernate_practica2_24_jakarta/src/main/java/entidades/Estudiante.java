package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Estudiantes database table.
 * 
 */
@Entity
@Table(name="Estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Edad")
	private int edad;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Clas
	@ManyToOne
	@JoinColumn(name="ClaseID")
	private Clase clase;

	//bi-directional many-to-one association to EstudiantesMateria
	@OneToMany(mappedBy="estudiante")
	private List<EstudiantesMateria> estudiantesMaterias;

	public Estudiante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public List<EstudiantesMateria> getEstudiantesMaterias() {
		return this.estudiantesMaterias;
	}

	public void setEstudiantesMaterias(List<EstudiantesMateria> estudiantesMaterias) {
		this.estudiantesMaterias = estudiantesMaterias;
	}

	public EstudiantesMateria addEstudiantesMateria(EstudiantesMateria estudiantesMateria) {
		getEstudiantesMaterias().add(estudiantesMateria);
		estudiantesMateria.setEstudiante(this);

		return estudiantesMateria;
	}

	public EstudiantesMateria removeEstudiantesMateria(EstudiantesMateria estudiantesMateria) {
		getEstudiantesMaterias().remove(estudiantesMateria);
		estudiantesMateria.setEstudiante(null);

		return estudiantesMateria;
	}

}