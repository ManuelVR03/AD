package JPAControladorDao;

import java.util.List;

import entidades.Pase;

public interface PaseFacade extends AbstractFacadeJPA<Pase>{

	public List<Pase> mostrarTodos();
}
