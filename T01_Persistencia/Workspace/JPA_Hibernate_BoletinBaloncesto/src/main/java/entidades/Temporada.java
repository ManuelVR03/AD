package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEMPORADA database table.
 * 
 */
@Entity
@Table(name="TEMPORADA")
@NamedQuery(name="Temporada.findAll", query="SELECT t FROM Temporada t")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codTemp;

	private String nombre;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="temporadaBean")
	private List<Partido> partidos;

	//bi-directional many-to-one association to TempEquipoJugador
	@OneToMany(mappedBy="temporada")
	private List<TempEquipoJugador> tempEquipoJugadors;

	public Temporada() {
	}

	public String getCodTemp() {
		return this.codTemp;
	}

	public void setCodTemp(String codTemp) {
		this.codTemp = codTemp;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public Partido addPartido(Partido partido) {
		getPartidos().add(partido);
		partido.setTemporadaBean(this);

		return partido;
	}

	public Partido removePartido(Partido partido) {
		getPartidos().remove(partido);
		partido.setTemporadaBean(null);

		return partido;
	}

	public List<TempEquipoJugador> getTempEquipoJugadors() {
		return this.tempEquipoJugadors;
	}

	public void setTempEquipoJugadors(List<TempEquipoJugador> tempEquipoJugadors) {
		this.tempEquipoJugadors = tempEquipoJugadors;
	}

	public TempEquipoJugador addTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().add(tempEquipoJugador);
		tempEquipoJugador.setTemporada(this);

		return tempEquipoJugador;
	}

	public TempEquipoJugador removeTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().remove(tempEquipoJugador);
		tempEquipoJugador.setTemporada(null);

		return tempEquipoJugador;
	}

}