package JPAControladorDao;

import java.util.List;

import entidades.Sala;
import jakarta.persistence.TypedQuery;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> implements SalaFacade{

	public SalaFacadeImpl() {
		super(Sala.class);
	}
	
	@Override
	public List<Sala> mostrarTodos(){
		TypedQuery<Sala> q = getEm().createQuery("SELECT s FROM Sala AS s", Sala.class);
		return q.getResultList();
	}
}
