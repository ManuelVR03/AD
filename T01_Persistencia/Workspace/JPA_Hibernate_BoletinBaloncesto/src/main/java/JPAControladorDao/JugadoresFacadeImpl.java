package JPAControladorDao;

import java.util.List;

import entidades.Jugadore;
import jakarta.persistence.TypedQuery;

public class JugadoresFacadeImpl extends AbstractFacadeJPAImpl<Jugadore> implements JugadoresFacade{

	public JugadoresFacadeImpl() {
		super(Jugadore.class);
	}
	
	@Override
	public List<Jugadore> mostrarTodos() {
		TypedQuery<Jugadore> q = getEm().createQuery("SELECT j FROM Jugadore AS j", Jugadore.class);
		return q.getResultList();
	}
}
