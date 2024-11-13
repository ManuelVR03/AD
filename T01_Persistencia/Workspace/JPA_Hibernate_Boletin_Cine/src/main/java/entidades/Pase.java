package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PASES database table.
 * 
 */
@Entity
@Table(name="PASES")
@NamedQuery(name="Pase.findAll", query="SELECT p FROM Pase p")
public class Pase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codpase;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pase")
	private Date fechaPase;

	@Column(name="tipo_pase")
	private String tipoPase;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="pase")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="codpelicula")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="codsala")
	private Sala sala;

	public Pase() {
	}

	public int getCodpase() {
		return this.codpase;
	}

	public void setCodpase(int codpase) {
		this.codpase = codpase;
	}

	public Date getFechaPase() {
		return this.fechaPase;
	}

	public void setFechaPase(Date fechaPase) {
		this.fechaPase = fechaPase;
	}

	public String getTipoPase() {
		return this.tipoPase;
	}

	public void setTipoPase(String tipoPase) {
		this.tipoPase = tipoPase;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Entrada addEntrada(Entrada entrada) {
		getEntradas().add(entrada);
		entrada.setPase(this);

		return entrada;
	}

	public Entrada removeEntrada(Entrada entrada) {
		getEntradas().remove(entrada);
		entrada.setPase(null);

		return entrada;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}