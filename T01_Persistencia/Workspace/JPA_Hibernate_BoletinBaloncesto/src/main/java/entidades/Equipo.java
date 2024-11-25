package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EQUIPOS database table.
 * 
 */
@Entity
@Table(name="EQUIPOS")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codEquipo;

	private String nombreEquipo;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo1")
	private List<Partido> partidos1;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo2")
	private List<Partido> partidos2;

	//bi-directional many-to-one association to TempEquipoJugador
	@OneToMany(mappedBy="equipo")
	private List<TempEquipoJugador> tempEquipoJugadors;

	public Equipo() {
	}

	public String getCodEquipo() {
		return this.codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNombreEquipo() {
		return this.nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public List<Partido> getPartidos1() {
		return this.partidos1;
	}

	public void setPartidos1(List<Partido> partidos1) {
		this.partidos1 = partidos1;
	}

	public Partido addPartidos1(Partido partidos1) {
		getPartidos1().add(partidos1);
		partidos1.setEquipo1(this);

		return partidos1;
	}

	public Partido removePartidos1(Partido partidos1) {
		getPartidos1().remove(partidos1);
		partidos1.setEquipo1(null);

		return partidos1;
	}

	public List<Partido> getPartidos2() {
		return this.partidos2;
	}

	public void setPartidos2(List<Partido> partidos2) {
		this.partidos2 = partidos2;
	}

	public Partido addPartidos2(Partido partidos2) {
		getPartidos2().add(partidos2);
		partidos2.setEquipo2(this);

		return partidos2;
	}

	public Partido removePartidos2(Partido partidos2) {
		getPartidos2().remove(partidos2);
		partidos2.setEquipo2(null);

		return partidos2;
	}

	public List<TempEquipoJugador> getTempEquipoJugadors() {
		return this.tempEquipoJugadors;
	}

	public void setTempEquipoJugadors(List<TempEquipoJugador> tempEquipoJugadors) {
		this.tempEquipoJugadors = tempEquipoJugadors;
	}

	public TempEquipoJugador addTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().add(tempEquipoJugador);
		tempEquipoJugador.setEquipo(this);

		return tempEquipoJugador;
	}

	public TempEquipoJugador removeTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().remove(tempEquipoJugador);
		tempEquipoJugador.setEquipo(null);

		return tempEquipoJugador;
	}

}