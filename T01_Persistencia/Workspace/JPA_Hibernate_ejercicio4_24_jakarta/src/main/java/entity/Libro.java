package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIBROS", catalog = "ejercicio4")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISBN", unique = true, nullable = false)
	private String isbn;

	@Column(name = "AUTOR")
	private String autor;

	@Column(name = "TITULO", unique = true, nullable = false)
	private String titulo;

	@Column(name = "PRESTADO")
	private byte prestado;

	@ManyToMany
	@JoinTable(name = "PRESTAMOS", joinColumns = @JoinColumn(name = "ISBN"), inverseJoinColumns = @JoinColumn(name = "ID_SOCIO"))
	private Set<Socio> socios;

	public Libro() {
	}

	public Libro(String isbn, String autor, String titulo, byte prestado) {
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.prestado = prestado;
		this.socios = new HashSet<Socio>();
	}

	public Set<Socio> getSocios() {
		return socios;
	}

	public void setSocios(Set<Socio> socios) {
		this.socios = socios;
	}
	
	public void addSocio(Socio s) {
		if(this.socios.add(s))
			s.getLibrosPrestados().add(this);
		else
			System.out.println("el socio " + s.getIdSocio() + "ya tiene el libro " + this.getIsbn() + " alquilado");
	}
	
	public void removeSocio(Socio s) {
		socios.remove(s);
		s.getLibrosPrestados().remove(this);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte getPrestado() {
		return prestado;
	}

	public void setPrestado(byte prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", prestado=" + prestado + "]";
	}

}
