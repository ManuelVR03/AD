package JPAControladorDao;

import java.util.List;

import entidades.PartidosJugadores;

public interface PartidosJugadoresFacade extends AbstractFacadeJPA<PartidosJugadores>{

	public List<PartidosJugadores> mostrarTodos();
}
