package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PARTIDOS database table.
 * 
 */
@Entity
@Table(name="PARTIDOS")
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codPartido;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_partido")
	private Date fechaPartido;

	private int jornada;

	private int puntosLocal;

	private int puntosVisitante;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="codEquipoLocal")
	private Equipo equipo1;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="codEquipoVisitante")
	private Equipo equipo2;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="temporada")
	private Temporada temporadaBean;

	//bi-directional many-to-one association to PartidosJugadore
	@OneToMany(mappedBy="partido")
	private List<PartidosJugadore> partidosJugadores;

	public Partido() {
	}

	public String getCodPartido() {
		return this.codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public Date getFechaPartido() {
		return this.fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public int getJornada() {
		return this.jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public int getPuntosLocal() {
		return this.puntosLocal;
	}

	public void setPuntosLocal(int puntosLocal) {
		this.puntosLocal = puntosLocal;
	}

	public int getPuntosVisitante() {
		return this.puntosVisitante;
	}

	public void setPuntosVisitante(int puntosVisitante) {
		this.puntosVisitante = puntosVisitante;
	}

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Temporada getTemporadaBean() {
		return this.temporadaBean;
	}

	public void setTemporadaBean(Temporada temporadaBean) {
		this.temporadaBean = temporadaBean;
	}

	public List<PartidosJugadore> getPartidosJugadores() {
		return this.partidosJugadores;
	}

	public void setPartidosJugadores(List<PartidosJugadore> partidosJugadores) {
		this.partidosJugadores = partidosJugadores;
	}

	public PartidosJugadore addPartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().add(partidosJugadore);
		partidosJugadore.setPartido(this);

		return partidosJugadore;
	}

	public PartidosJugadore removePartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().remove(partidosJugadore);
		partidosJugadore.setPartido(null);

		return partidosJugadore;
	}

}