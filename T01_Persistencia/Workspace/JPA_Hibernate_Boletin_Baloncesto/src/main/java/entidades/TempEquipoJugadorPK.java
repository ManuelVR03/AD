package entidades;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

/**
 * Primary key class for TEMP_EQUIPO_JUGADOR.
 */
@Embeddable
public class TempEquipoJugadorPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codJugador;
    private String codEquipo;
    private String codTemporada;

    public TempEquipoJugadorPK() {}

    public String getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(String codJugador) {
        this.codJugador = codJugador;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getCodTemporada() {
        return codTemporada;
    }

    public void setCodTemporada(String codTemporada) {
        this.codTemporada = codTemporada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codJugador, codEquipo, codTemporada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TempEquipoJugadorPK other = (TempEquipoJugadorPK) obj;
        return Objects.equals(codJugador, other.codJugador) &&
               Objects.equals(codEquipo, other.codEquipo) &&
               Objects.equals(codTemporada, other.codTemporada);
    }
}
