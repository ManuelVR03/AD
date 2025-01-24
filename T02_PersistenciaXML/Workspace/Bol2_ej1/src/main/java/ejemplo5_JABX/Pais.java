package ejemplo5_JABX;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class Pais {

	private String Pais_Capital;
	private String Pais_Nombre;
	private LocalDate fechaCenso;
	private String Pais_Continente;
	private Integer Pais_Habitantes;
	
	public Pais() {
		// TODO Auto-generated constructor stub
	}
	public String getPais_Capital() {
		return Pais_Capital;
	}
	public void setPais_Capital(String pais_Capital) {
		Pais_Capital = pais_Capital;
	}
	public String getPais_Nombre() {
		return Pais_Nombre;
	}
	public void setPais_Nombre(String pais_Nombre) {
		Pais_Nombre = pais_Nombre;
	}
	public LocalDate getFechaCenso() {
		return fechaCenso;
	}
	public void setFechaCenso(LocalDate fechaCenso) {
		this.fechaCenso = fechaCenso;
	}
	public String getPais_Continente() {
		return Pais_Continente;
	}
	public void setPais_Continente(String pais_Continente) {
		Pais_Continente = pais_Continente;
	}
	public Integer getPais_Habitantes() {
		return Pais_Habitantes;
	}
	public void setPais_Habitantes(Integer pais_Habitantes) {
		Pais_Habitantes = pais_Habitantes;
	}
	@Override
	public String toString() {
		return "Pais [Pais_Capital=" + Pais_Capital + ", Pais_Nombre=" + Pais_Nombre + ", fechaCenso=" + fechaCenso
				+ ", Pais_Continente=" + Pais_Continente + ", Pais_Habitantes=" + Pais_Habitantes + "]";
	}
	
	
	
	
}
