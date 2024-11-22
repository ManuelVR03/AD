package entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 * The persistent class for the EQUIPOS database table.
 */
@Entity
@Table(name = "EQUIPOS")
@NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codEquipo;

    private String nombreEquipo;

    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisitante")
    private List<Partido> partidosVisitante;

    @OneToMany(mappedBy = "equipo")
    private List<TempEquipoJugador> tempEquipoJugadores;

    public Equipo() {}

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(List<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }

    public List<Partido> getPartidosVisitante() {
        return partidosVisitante;
    }

    public void setPartidosVisitante(List<Partido> partidosVisitante) {
        this.partidosVisitante = partidosVisitante;
    }

    public List<TempEquipoJugador> getTempEquipoJugadores() {
        return tempEquipoJugadores;
    }

    public void setTempEquipoJugadores(List<TempEquipoJugador> tempEquipoJugadores) {
        this.tempEquipoJugadores = tempEquipoJugadores;
    }
}
