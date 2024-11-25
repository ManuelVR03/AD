package JPAControladorDao;

import java.util.List;

import entidades.PartidosJugadores;
import jakarta.persistence.TypedQuery;

public class PartidosJugadoresFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadores> implements PartidosJugadoresFacade{

	public PartidosJugadoresFacadeImpl() {
		super(PartidosJugadores.class);
	}
	
	@Override
	public List<PartidosJugadores> mostrarTodos() {
		TypedQuery<PartidosJugadores> q = getEm().createQuery("SELECT pj FROM PartidosJugadores AS pj", PartidosJugadores.class);
		return q.getResultList();
	}
}
