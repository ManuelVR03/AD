package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the JUGADORES database table.
 * 
 */
@Entity
@Table(name="JUGADORES")
@NamedQuery(name="Jugadore.findAll", query="SELECT j FROM Jugadore j")
public class Jugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codJugador;

	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	private String nombreJugador;

	//bi-directional many-to-one association to PartidosJugadore
	@OneToMany(mappedBy="jugadore")
	private List<PartidosJugadore> partidosJugadores;

	//bi-directional many-to-one association to TempEquipoJugador
	@OneToMany(mappedBy="jugadore")
	private List<TempEquipoJugador> tempEquipoJugadors;

	public Jugadore() {
	}

	public String getCodJugador() {
		return this.codJugador;
	}

	public void setCodJugador(String codJugador) {
		this.codJugador = codJugador;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNombreJugador() {
		return this.nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public List<PartidosJugadore> getPartidosJugadores() {
		return this.partidosJugadores;
	}

	public void setPartidosJugadores(List<PartidosJugadore> partidosJugadores) {
		this.partidosJugadores = partidosJugadores;
	}

	public PartidosJugadore addPartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().add(partidosJugadore);
		partidosJugadore.setJugadore(this);

		return partidosJugadore;
	}

	public PartidosJugadore removePartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().remove(partidosJugadore);
		partidosJugadore.setJugadore(null);

		return partidosJugadore;
	}

	public List<TempEquipoJugador> getTempEquipoJugadors() {
		return this.tempEquipoJugadors;
	}

	public void setTempEquipoJugadors(List<TempEquipoJugador> tempEquipoJugadors) {
		this.tempEquipoJugadors = tempEquipoJugadors;
	}

	public TempEquipoJugador addTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().add(tempEquipoJugador);
		tempEquipoJugador.setJugadore(this);

		return tempEquipoJugador;
	}

	public TempEquipoJugador removeTempEquipoJugador(TempEquipoJugador tempEquipoJugador) {
		getTempEquipoJugadors().remove(tempEquipoJugador);
		tempEquipoJugador.setJugadore(null);

		return tempEquipoJugador;
	}

}