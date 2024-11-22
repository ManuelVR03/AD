package entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 * The persistent class for the TEMPORADAS database table.
 */
@Entity
@Table(name = "TEMPORADAS")
@NamedQuery(name = "Temporada.findAll", query = "SELECT t FROM Temporada t")
public class Temporada implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codTemporada;

    private String descripcion;

    @OneToMany(mappedBy = "temporada")
    private List<Partido> partidos;

    @OneToMany(mappedBy = "temporada")
    private List<TempEquipoJugador> tempEquipoJugadores;

    public Temporada() {}

    public String getCodTemporada() {
        return codTemporada;
    }

    public void setCodTemporada(String codTemporada) {
        this.codTemporada = codTemporada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public List<TempEquipoJugador> getTempEquipoJugadores() {
        return tempEquipoJugadores;
    }

    public void setTempEquipoJugadores(List<TempEquipoJugador> tempEquipoJugadores) {
        this.tempEquipoJugadores = tempEquipoJugadores;
    }
}
