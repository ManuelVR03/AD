package JPAControladorDao;

import java.util.List;

import entidades.TempEquipoJugador;
import jakarta.persistence.TypedQuery;

public class TempEquipoJugadorFacadeImpl extends AbstractFacadeJPAImpl<TempEquipoJugador> implements TempEquipoJugadorFacade{

	public TempEquipoJugadorFacadeImpl() {
		super(TempEquipoJugador.class);
	}
	
	@Override
	public List<TempEquipoJugador> mostrarTodos() {
		TypedQuery<TempEquipoJugador> q = getEm().createQuery("SELECT tej FROM TempEquipoJugador AS tej", TempEquipoJugador.class);
		return q.getResultList();
	}
}
