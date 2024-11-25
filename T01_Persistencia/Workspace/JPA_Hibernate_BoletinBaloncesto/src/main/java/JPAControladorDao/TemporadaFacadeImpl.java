package JPAControladorDao;

import java.util.List;

import entidades.Temporada;
import jakarta.persistence.TypedQuery;

public class TemporadaFacadeImpl extends AbstractFacadeJPAImpl<Temporada> implements TemporadaFacade{

	public TemporadaFacadeImpl() {
		super(Temporada.class);
	}
	
	@Override
	public List<Temporada> mostrarTodos() {
		TypedQuery<Temporada> q = getEm().createQuery("SELECT t FROM Temporada AS t", Temporada.class);
		return q.getResultList();
	}
}
