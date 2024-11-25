package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TEMP_EQUIPO_JUGADOR database table.
 * 
 */
@Entity
@Table(name="TEMP_EQUIPO_JUGADOR")
@NamedQuery(name="TempEquipoJugador.findAll", query="SELECT t FROM TempEquipoJugador t")
public class TempEquipoJugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TempEquipoJugadorPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	private int salario;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="codEquipo")
	private Equipo equipo;

	//bi-directional many-to-one association to Jugadore
	@ManyToOne
	@JoinColumn(name="codJugador")
	private Jugadore jugadore;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="codTemp")
	private Temporada temporada;

	public TempEquipoJugador() {
	}

	public TempEquipoJugadorPK getId() {
		return this.id;
	}

	public void setId(TempEquipoJugadorPK id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jugadore getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

}