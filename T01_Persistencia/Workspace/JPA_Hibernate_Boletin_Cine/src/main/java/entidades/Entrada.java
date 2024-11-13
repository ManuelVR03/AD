package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ENTRADAS database table.
 * 
 */
@Entity
@Table(name="ENTRADAS")
@NamedQuery(name="Entrada.findAll", query="SELECT e FROM Entrada e")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codentrada;

	private String comprador;

	private int numenfila;

	private int numfila;

	private int pvp;

	private String vendido;

	//bi-directional many-to-one association to Pas
	@ManyToOne
	@JoinColumn(name="codpase")
	private Pase pase;

	public Entrada() {
	}

	public int getCodentrada() {
		return this.codentrada;
	}

	public void setCodentrada(int codentrada) {
		this.codentrada = codentrada;
	}

	public String getComprador() {
		return this.comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public int getNumenfila() {
		return this.numenfila;
	}

	public void setNumenfila(int numenfila) {
		this.numenfila = numenfila;
	}

	public int getNumfila() {
		return this.numfila;
	}

	public void setNumfila(int numfila) {
		this.numfila = numfila;
	}

	public int getPvp() {
		return this.pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	public String getVendido() {
		return this.vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}

	public Pase getPase() {
		return this.pase;
	}

	public void setPase(Pase pase) {
		this.pase = pase;
	}

}