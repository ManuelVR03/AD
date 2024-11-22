package JPAControladorDao;

import java.util.List;

import entidades.Jugadores;

public interface JugadoresFacade extends AbstractFacadeJPA<Jugadores>{

	public List<Jugadores> mostrarTodos();
}
