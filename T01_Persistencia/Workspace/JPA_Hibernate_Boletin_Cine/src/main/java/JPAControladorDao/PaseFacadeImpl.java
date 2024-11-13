package JPAControladorDao;

import java.util.List;

import entidades.Pase;
import jakarta.persistence.TypedQuery;

public class PaseFacadeImpl extends AbstractFacadeJPAImpl<Pase> implements PaseFacade{

	public PaseFacadeImpl() {
		super(Pase.class);
	}
	
	@Override
	public List<Pase> mostrarTodos(){
		TypedQuery<Pase> q = getEm().createQuery("SELECT p FROM Pase AS p", Pase.class);
		return q.getResultList();
	}
}
