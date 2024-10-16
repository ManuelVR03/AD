package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIRECCION", catalog = "ejercicio3")
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDDIRECCION", unique = true, nullable = false)
	private Long idDireccion;

	@Column(name = "CALLE")
	private String calle;

	@Column(name = "CIUDAD")
	private String ciudad;

	@Column(name = "PAIS")
	private String pais;

	@Column(name = "CODIGOPOSTAL")
	private Long codigoPostal;

	public Direccion() {}

	public Direccion(Long idDireccion, String calle, String ciudad, String pais, Long codigoPostal) {
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", ciudad=" + ciudad + ", pais=" + pais
				+ ", codigoPostal=" + codigoPostal + "]";
	}
	
	
}
