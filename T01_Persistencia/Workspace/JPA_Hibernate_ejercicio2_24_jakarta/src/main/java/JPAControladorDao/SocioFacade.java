package JPAControladorDao;

import java.util.List;

import entity.Socio;

public interface SocioFacade extends AbstractFacadeJPA<Socio> {
	public List<Socio> mostrarTodos();
}
