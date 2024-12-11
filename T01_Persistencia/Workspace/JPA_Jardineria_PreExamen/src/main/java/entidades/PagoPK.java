package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the PAGO database table.
 * 
 */
@Embeddable
public class PagoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_CLIENTE", insertable=false, updatable=false)
	private int codigoCliente;

	@Column(name="ID_TRANSACCION")
	private String idTransaccion;

	public PagoPK() {
	}
	public int getCodigoCliente() {
		return this.codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getIdTransaccion() {
		return this.idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PagoPK)) {
			return false;
		}
		PagoPK castOther = (PagoPK)other;
		return 
			(this.codigoCliente == castOther.codigoCliente)
			&& this.idTransaccion.equals(castOther.idTransaccion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoCliente;
		hash = hash * prime + this.idTransaccion.hashCode();
		
		return hash;
	}
	
	
	@Override
	public String toString() {
		return "PagoPK [codigoCliente=" + codigoCliente + ", idTransaccion=" + idTransaccion + "]";
	}
	
	
}