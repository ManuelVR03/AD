package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the editorial database table.
 * 
 */
@Entity
@Table(name="editorial")
@NamedQuery(name="Editorial.findAll", query="SELECT e FROM Editorial e")
@NamedQuery(name="Editorial.miLibro", query="SELECT e FROM Editorial e WHERE e.codEditorial = 1")
public class Editorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_editorial")
	private int codEditorial;

	private String ciudad;

	private String nombre;

	private String pais;

	//bi-directional many-to-one association to Titulo
	@OneToMany(mappedBy="editorial")
	private List<Titulo> titulos;

	public Editorial() {
	}

	public int getCodEditorial() {
		return this.codEditorial;
	}

	public void setCodEditorial(int codEditorial) {
		this.codEditorial = codEditorial;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Titulo> getTitulos() {
		return this.titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public Titulo addTitulo(Titulo titulo) {
		getTitulos().add(titulo);
		titulo.setEditorial(this);

		return titulo;
	}

	public Titulo removeTitulo(Titulo titulo) {
		getTitulos().remove(titulo);
		titulo.setEditorial(null);

		return titulo;
	}

	@Override
	public String toString() {
		return "Editorial [codEditorial=" + codEditorial + ", ciudad=" + ciudad + ", nombre=" + nombre + ", pais="
				+ pais + "]";
	}
	
	

}