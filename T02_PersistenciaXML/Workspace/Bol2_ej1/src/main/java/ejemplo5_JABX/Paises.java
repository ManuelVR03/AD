package ejemplo5_JABX;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paises {
	private Set<Pais> listaPaises;

	public Paises() {
		// TODO Auto-generated constructor stub
	}

	public Set<Pais> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(Set<Pais> listaPaises) {
		this.listaPaises = listaPaises;
	}

	@Override
	public String toString() {
		return "Paises [listaPaises=" + listaPaises + "]";
	}
	
	
}
