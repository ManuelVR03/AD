package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "GRUPO", catalog = "practica")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODGRUPO", unique = true, nullable = false)
	private Integer codGrupo;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy = "grupo")
	private List<Alumno> alumnos;

	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public Grupo(Integer codGrupo, String nombre) {
		this.codGrupo = codGrupo;
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
	}

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumno(Alumno a) {
		alumnos.add(a);
		a.setGrupo(this);
	}
	
	public void removeAlumno(Alumno a) {
		alumnos.remove(a);
		a.setGrupo(null);
	}

	@Override
	public String toString() {
		return "Grupo [codGrupo=" + codGrupo + ", nombre=" + nombre + "]";
	}
	
	
	
}
