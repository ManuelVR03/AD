package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@Table(name="autor")
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
@NamedQuery(name="Autor.autor1", query="SELECT a FROM Autor a WHERE a.codautor = 'a1'")
@NamedQuery(name="Autor.autor2", query="SELECT a FROM Autor a WHERE a.codautor = 'a2'")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codautor;

	private String ciudad;

	private int cp;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Autorestitulo
	@OneToMany(mappedBy="autor")
	private List<Autorestitulo> autorestitulos;

	public Autor() {
	}

	public String getCodautor() {
		return this.codautor;
	}

	public void setCodautor(String codautor) {
		this.codautor = codautor;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Autorestitulo> getAutorestitulos() {
		return this.autorestitulos;
	}

	public void setAutorestitulos(List<Autorestitulo> autorestitulos) {
		this.autorestitulos = autorestitulos;
	}

	public Autorestitulo addAutorestitulo(Autorestitulo autorestitulo) {
		getAutorestitulos().add(autorestitulo);
		autorestitulo.setAutor(this);

		return autorestitulo;
	}

	public Autorestitulo removeAutorestitulo(Autorestitulo autorestitulo) {
		getAutorestitulos().remove(autorestitulo);
		autorestitulo.setAutor(null);

		return autorestitulo;
	}

	@Override
	public String toString() {
		return "Autor [codautor=" + codautor + ", ciudad=" + ciudad + ", cp=" + cp + ", direccion=" + direccion
				+ ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	

}