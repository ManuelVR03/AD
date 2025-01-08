package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the autorestitulos database table.
 * 
 */
@Embeddable
public class AutorestituloPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String codautor;

	@Column(insertable=false, updatable=false)
	private String codtitulo;

	public AutorestituloPK() {
	}
	
	public AutorestituloPK(String codautor, String codtitulo) {
		this.codautor = codautor;
		this.codtitulo = codtitulo;
	}


	public String getCodautor() {
		return this.codautor;
	}
	public void setCodautor(String codautor) {
		this.codautor = codautor;
	}
	public String getCodtitulo() {
		return this.codtitulo;
	}
	public void setCodtitulo(String codtitulo) {
		this.codtitulo = codtitulo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AutorestituloPK)) {
			return false;
		}
		AutorestituloPK castOther = (AutorestituloPK)other;
		return 
			this.codautor.equals(castOther.codautor)
			&& this.codtitulo.equals(castOther.codtitulo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codautor.hashCode();
		hash = hash * prime + this.codtitulo.hashCode();
		
		return hash;
	}
}