package JPAControladorDao;

import java.util.List;

import entidades.Jugadores;
import jakarta.persistence.TypedQuery;

public class JugadoresFacadeImpl extends AbstractFacadeJPAImpl<Jugadores> implements JugadoresFacade{

	public JugadoresFacadeImpl() {
		super(Jugadores.class);
	}
	
	@Override
	public List<Jugadores> mostrarTodos() {
		TypedQuery<Jugadores> q = getEm().createQuery("SELECT j FROM Jugadores AS j", Jugadores.class);
		return q.getResultList();
	}
}
