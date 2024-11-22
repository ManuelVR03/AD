package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the TEMP_EQUIPO_JUGADOR database table.
 */
@Entity
@Table(name = "TEMP_EQUIPO_JUGADOR")
@NamedQuery(name = "TempEquipoJugador.findAll", query = "SELECT t FROM TempEquipoJugador t")
public class TempEquipoJugador implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TempEquipoJugadorPK id;

    @ManyToOne
    @JoinColumn(name = "codJugador", insertable = false, updatable = false)
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "codEquipo", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "codTemporada", insertable = false, updatable = false)
    private Temporada temporada;

    public TempEquipoJugador() {}

    public TempEquipoJugadorPK getId() {
        return id;
    }

    public void setId(TempEquipoJugadorPK id) {
        this.id = id;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}
