package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the prestamos database table.
 * 
 */
@Embeddable
public class PrestamoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_socio", insertable=false, updatable=false)
	private int idSocio;

	@Column(insertable=false, updatable=false)
	private String isbn;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prestamo")
	private java.util.Date fechaPrestamo;

	public PrestamoPK() {
	}
	public int getIdSocio() {
		return this.idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public java.util.Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}
	public void setFechaPrestamo(java.util.Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrestamoPK)) {
			return false;
		}
		PrestamoPK castOther = (PrestamoPK)other;
		return 
			(this.idSocio == castOther.idSocio)
			&& this.isbn.equals(castOther.isbn)
			&& this.fechaPrestamo.equals(castOther.fechaPrestamo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSocio;
		hash = hash * prime + this.isbn.hashCode();
		hash = hash * prime + this.fechaPrestamo.hashCode();
		
		return hash;
	}
}