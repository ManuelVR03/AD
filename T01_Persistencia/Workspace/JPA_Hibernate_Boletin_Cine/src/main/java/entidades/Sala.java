package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the SALAS database table.
 * 
 */
@Entity
@Table(name="SALAS")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codsala;

	private int numasiporfilas;

	private int numfilas;

	@Column(name="tipo_sonido")
	private String tipoSonido;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="sala")
	private List<Pase> pases;

	public Sala() {
	}

	public int getCodsala() {
		return this.codsala;
	}

	public void setCodsala(int codsala) {
		this.codsala = codsala;
	}

	public int getNumasiporfilas() {
		return this.numasiporfilas;
	}

	public void setNumasiporfilas(int numasiporfilas) {
		this.numasiporfilas = numasiporfilas;
	}

	public int getNumfilas() {
		return this.numfilas;
	}

	public void setNumfilas(int numfilas) {
		this.numfilas = numfilas;
	}

	public String getTipoSonido() {
		return this.tipoSonido;
	}

	public void setTipoSonido(String tipoSonido) {
		this.tipoSonido = tipoSonido;
	}

	public List<Pase> getPases() {
		return this.pases;
	}

	public void setPases(List<Pase> pases) {
		this.pases = pases;
	}

	public Pase addPase(Pase pase) {
		getPases().add(pase);
		pase.setSala(this);

		return pase;
	}

	public Pase removePase(Pase pase) {
		getPases().remove(pase);
		pase.setSala(null);

		return pase;
	}

}