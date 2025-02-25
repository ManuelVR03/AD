package ejemplo6;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Personas")
public class Personas {
	
	private Set<Persona> personas;

	public Personas() {
		// TODO Auto-generated constructor stub
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "Personas [personas=" + personas + "]";
	}
	

}
