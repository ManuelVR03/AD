package JPAControladorDao;

import java.util.List;

import entidades.Partido;

public interface PartidoFacade extends AbstractFacadeJPA<Partido>{

	public List<Partido> mostrarTodos();
}
