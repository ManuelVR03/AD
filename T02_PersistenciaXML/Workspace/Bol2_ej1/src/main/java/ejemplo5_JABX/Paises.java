package ejemplo5_JABX;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Paises")
public class Paises {
	private Set<Pais2> listaPaises;

	public Paises() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="Pais")
	public Set<Pais2> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(Set<Pais2> listaPaises) {
		this.listaPaises = listaPaises;
	}

	@Override
	public String toString() {
		return "Paises [listaPaises=" + listaPaises + "]";
	}
	
	
}
