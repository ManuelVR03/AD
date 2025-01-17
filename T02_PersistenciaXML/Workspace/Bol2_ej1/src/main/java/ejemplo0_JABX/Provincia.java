package ejemplo0_JABX;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Provincia {

	private String nombre;
	private Localidad[] localidad;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad[] getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad[] localidad) {
		this.localidad = localidad;
	}
	
	
}
