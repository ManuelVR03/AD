package ejemplo6;

import java.io.Serializable;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder= {"nombre", "edad", "soltero"})
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Integer edad;
	private Boolean soltero;
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, Integer edad, Boolean soltero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.soltero = soltero;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Boolean getSoltero() {
		return soltero;
	}
	public void setSoltero(Boolean soltero) {
		this.soltero = soltero;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", soltero=" + soltero + "]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	

}
