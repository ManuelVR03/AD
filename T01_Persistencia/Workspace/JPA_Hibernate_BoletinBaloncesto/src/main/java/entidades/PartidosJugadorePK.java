package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the PARTIDOS_JUGADORES database table.
 * 
 */
@Embeddable
public class PartidosJugadorePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String codPartido;

	@Column(insertable=false, updatable=false)
	private String codJugador;

	public PartidosJugadorePK() {
	}
	public String getCodPartido() {
		return this.codPartido;
	}
	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}
	public String getCodJugador() {
		return this.codJugador;
	}
	public void setCodJugador(String codJugador) {
		this.codJugador = codJugador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartidosJugadorePK)) {
			return false;
		}
		PartidosJugadorePK castOther = (PartidosJugadorePK)other;
		return 
			this.codPartido.equals(castOther.codPartido)
			&& this.codJugador.equals(castOther.codJugador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codPartido.hashCode();
		hash = hash * prime + this.codJugador.hashCode();
		
		return hash;
	}
}