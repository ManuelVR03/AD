package JPAControladorDao;

import java.util.List;

import entidades.PartidosJugadore;
import jakarta.persistence.TypedQuery;

public class PartidosJugadoresFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadore> implements PartidosJugadoresFacade{

	public PartidosJugadoresFacadeImpl() {
		super(PartidosJugadore.class);
	}
	
	@Override
	public List<PartidosJugadore> mostrarTodos() {
		TypedQuery<PartidosJugadore> q = getEm().createQuery("SELECT pj FROM PartidosJugadore AS pj", PartidosJugadore.class);
		return q.getResultList();
	}
}
