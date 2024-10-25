package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SOCIOS", catalog = "ejercicio4")
public class Socio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_SOCIO", unique=true, nullable=false)
	private int idSocio;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@ManyToMany(mappedBy="socios")
	private Set<Libro> librosPrestados;

	public Socio() {
		// TODO Auto-generated constructor stub
	}

	public Socio(int idSocio, String nombre, String apellidos) {
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.librosPrestados = new HashSet<Libro>();
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void addLibro(Libro l) {
		librosPrestados.add(l);
	}
	
	public void removeLibro(Libro l) {
		librosPrestados.remove(l);
	}

	public Set<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(Set<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	

}
