package JPAControladorDao;

import java.util.List;

import entidades.PartidosJugadore;

public interface PartidosJugadoresFacade extends AbstractFacadeJPA<PartidosJugadore>{

	public List<PartidosJugadore> mostrarTodos();
}
