package ejemplo5_JABX;

import java.time.LocalDate;
import java.util.Objects;

import adaptador.AdaptadorFecha;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(propOrder = {"pais_Capital", "pais_Nombre", "fechaCenso", "pais_Continente", "pais_Habitantes"})
public class Pais2 {

	private String Pais_Capital;
	private String Pais_Nombre;
	private LocalDate fechaCenso;
	private String Pais_Continente;
	private Integer Pais_Habitantes;
	private Integer importancia;
	
	public Pais2() {
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
	
	@XmlJavaTypeAdapter(AdaptadorFecha.class)
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
	@XmlAttribute
	public Integer getImportancia() {
		return importancia;
	}
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Pais_Nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais2 other = (Pais2) obj;
		return Objects.equals(Pais_Nombre, other.Pais_Nombre);
	}


	
	@Override
	public String toString() {
		return "Pais [Pais_Capital=" + Pais_Capital + ", Pais_Nombre=" + Pais_Nombre + ", fechaCenso=" + fechaCenso
				+ ", Pais_Continente=" + Pais_Continente + ", Pais_Habitantes=" + Pais_Habitantes + ", importancia="
				+ importancia + "]";
	}
	
	
	
	
	
}
