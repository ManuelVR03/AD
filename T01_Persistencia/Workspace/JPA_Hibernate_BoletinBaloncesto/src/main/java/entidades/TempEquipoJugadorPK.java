package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the TEMP_EQUIPO_JUGADOR database table.
 * 
 */
@Embeddable
public class TempEquipoJugadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String codTemp;

	@Column(insertable=false, updatable=false)
	private String codEquipo;

	@Column(insertable=false, updatable=false)
	private String codJugador;

	public TempEquipoJugadorPK() {
	}
	public String getCodTemp() {
		return this.codTemp;
	}
	public void setCodTemp(String codTemp) {
		this.codTemp = codTemp;
	}
	public String getCodEquipo() {
		return this.codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
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
		if (!(other instanceof TempEquipoJugadorPK)) {
			return false;
		}
		TempEquipoJugadorPK castOther = (TempEquipoJugadorPK)other;
		return 
			this.codTemp.equals(castOther.codTemp)
			&& this.codEquipo.equals(castOther.codEquipo)
			&& this.codJugador.equals(castOther.codJugador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codTemp.hashCode();
		hash = hash * prime + this.codEquipo.hashCode();
		hash = hash * prime + this.codJugador.hashCode();
		
		return hash;
	}
}