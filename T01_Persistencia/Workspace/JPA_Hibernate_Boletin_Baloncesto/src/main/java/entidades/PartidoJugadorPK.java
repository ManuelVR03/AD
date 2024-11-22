package entidades;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

/**
 * Primary key class for PARTIDO_JUGADOR.
 */
@Embeddable
public class PartidoJugadorPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codPartido;

    private String codJugador;

    public PartidoJugadorPK() {}

    public String getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(String codPartido) {
        this.codPartido = codPartido;
    }

    public String getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(String codJugador) {
        this.codJugador = codJugador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPartido, codJugador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PartidoJugadorPK other = (PartidoJugadorPK) obj;
        return Objects.equals(codPartido, other.codPartido) &&
               Objects.equals(codJugador, other.codJugador);
    }
}
