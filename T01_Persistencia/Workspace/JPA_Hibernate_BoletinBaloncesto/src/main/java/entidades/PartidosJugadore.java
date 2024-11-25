package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the PARTIDOS_JUGADORES database table.
 * 
 */
@Entity
@Table(name="PARTIDOS_JUGADORES")
@NamedQuery(name="PartidosJugadore.findAll", query="SELECT p FROM PartidosJugadore p")
public class PartidosJugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartidosJugadorePK id;

	private int asistencias;

	private int canastas;

	private int rebotes;

	//bi-directional many-to-one association to Jugadore
	@ManyToOne
	@JoinColumn(name="codJugador")
	private Jugadore jugadore;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="codPartido")
	private Partido partido;

	public PartidosJugadore() {
	}

	public PartidosJugadorePK getId() {
		return this.id;
	}

	public void setId(PartidosJugadorePK id) {
		this.id = id;
	}

	public int getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getCanastas() {
		return this.canastas;
	}

	public void setCanastas(int canastas) {
		this.canastas = canastas;
	}

	public int getRebotes() {
		return this.rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public Jugadore getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}