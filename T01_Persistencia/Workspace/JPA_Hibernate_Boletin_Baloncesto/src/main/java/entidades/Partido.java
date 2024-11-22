package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 * The persistent class for the PARTIDOS database table.
 */
@Entity
@Table(name = "PARTIDOS")
@NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
public class Partido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codPartido;

    @Temporal(TemporalType.DATE)
    private Date fechaPartido;

    private int jornada;

    private int puntosLocal;

    private int puntosVisitante;

    @ManyToOne
    @JoinColumn(name = "codEquipoLocal")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "codEquipoVisitante")
    private Equipo equipoVisitante;

    @ManyToOne
    @JoinColumn(name = "temporada")
    private Temporada temporada;

    @OneToMany(mappedBy = "partido")
    private List<PartidosJugadores> partidosJugadores;

    public Partido() {}

    public String getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(String codPartido) {
        this.codPartido = codPartido;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public List<PartidosJugadores> getPartidosJugadores() {
        return partidosJugadores;
    }

    public void setPartidosJugadores(List<PartidosJugadores> partidosJugadores) {
        this.partidosJugadores = partidosJugadores;
    }
}
