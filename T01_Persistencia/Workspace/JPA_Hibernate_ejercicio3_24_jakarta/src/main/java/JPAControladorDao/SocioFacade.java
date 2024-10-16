package JPAControladorDao;

import java.util.List;

import entidades.Socio;

public interface SocioFacade extends AbstractFacadeJPA<Socio> {
	public List<Socio> mostrarTodos();
}
