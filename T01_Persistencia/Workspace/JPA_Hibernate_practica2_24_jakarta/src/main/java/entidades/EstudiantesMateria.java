package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the EstudiantesMaterias database table.
 * 
 */
@Entity
@Table(name="EstudiantesMaterias")
@NamedQuery(name="EstudiantesMateria.findAll", query="SELECT e FROM EstudiantesMateria e")
public class EstudiantesMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="EstudianteID")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="MateriaID")
	private Materia materia;

	public EstudiantesMateria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}