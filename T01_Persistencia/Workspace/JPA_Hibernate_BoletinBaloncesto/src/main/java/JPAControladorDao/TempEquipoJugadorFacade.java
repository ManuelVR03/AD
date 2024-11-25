package JPAControladorDao;

import java.util.List;

import entidades.TempEquipoJugador;

public interface TempEquipoJugadorFacade extends AbstractFacadeJPA<TempEquipoJugador>{

	public List<TempEquipoJugador> mostrarTodos();
}
