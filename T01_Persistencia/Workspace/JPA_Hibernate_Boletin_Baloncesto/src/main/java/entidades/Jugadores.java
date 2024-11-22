package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 * The persistent class for the JUGADORES database table.
 */
@Entity
@Table(name = "JUGADORES")
@NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j")
public class Jugadores implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codJugador;

    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    private String nombreJugador;

    @OneToMany(mappedBy = "jugador")
    private List<PartidosJugadores> partidosJugadores;

    @OneToMany(mappedBy = "jugador")
    private List<TempEquipoJugador> tempEquipoJugadores;

    public Jugadores() {}

    public String getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(String codJugador) {
        this.codJugador = codJugador;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public List<PartidosJugadores> getPartidosJugadores() {
        return partidosJugadores;
    }

    public void setPartidosJugadores(List<PartidosJugadores> partidosJugadores) {
        this.partidosJugadores = partidosJugadores;
    }

    public List<TempEquipoJugador> getTempEquipoJugadores() {
        return tempEquipoJugadores;
    }

    public void setTempEquipoJugadores(List<TempEquipoJugador> tempEquipoJugadores) {
        this.tempEquipoJugadores = tempEquipoJugadores;
    }
}
