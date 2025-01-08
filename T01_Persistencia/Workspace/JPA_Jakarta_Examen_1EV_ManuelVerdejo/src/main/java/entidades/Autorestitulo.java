package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the autorestitulos database table.
 * 
 */
@Entity
@Table(name="autorestitulos")
@NamedQuery(name="Autorestitulo.findAll", query="SELECT a FROM Autorestitulo a")
public class Autorestitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AutorestituloPK id;

	private int orden;

	private int pct;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="codautor")
	private Autor autor;

	//bi-directional many-to-one association to Titulo
	@ManyToOne
	@JoinColumn(name="codtitulo")
	private Titulo titulo;

	public Autorestitulo() {
	}

	public Autorestitulo(AutorestituloPK id, int orden, int pct, Autor autor, Titulo titulo) {
		this.id = id;
		this.orden = orden;
		this.pct = pct;
		this.autor = autor;
		this.titulo = titulo;
	}



	public AutorestituloPK getId() {
		return this.id;
	}

	public void setId(AutorestituloPK id) {
		this.id = id;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getPct() {
		return this.pct;
	}

	public void setPct(int pct) {
		this.pct = pct;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Titulo getTitulo() {
		return this.titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

}