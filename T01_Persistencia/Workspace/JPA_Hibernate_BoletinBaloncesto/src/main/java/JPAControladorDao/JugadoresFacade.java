package JPAControladorDao;

import java.util.List;

import entidades.Jugadore;

public interface JugadoresFacade extends AbstractFacadeJPA<Jugadore>{

	public List<Jugadore> mostrarTodos();
}
