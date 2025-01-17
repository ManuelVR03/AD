package ejemplo0_JABX;

import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class Localidad {

	private String nombre;
	private int cp;
	
	public Localidad() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
}
