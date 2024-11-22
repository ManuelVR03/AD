package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the PARTIDOS_JUGADORES database table.
 */
@Entity
@Table(name = "PARTIDOS_JUGADORES")
@NamedQuery(name = "PartidosJugadores.findAll", query = "SELECT p FROM PartidosJugadores p")
public class PartidosJugadores implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PartidoJugadorPK id;

    private int asistencias;

    private int canastas;

    private int rebotes;

    @ManyToOne
    @JoinColumn(name = "codJugador", insertable = false, updatable = false)
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "codPartido", insertable = false, updatable = false)
    private Partido partido;

    public PartidosJugadores() {}

    public PartidoJugadorPK getId() {
        return id;
    }

    public void setId(PartidoJugadorPK id) {
        this.id = id;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
