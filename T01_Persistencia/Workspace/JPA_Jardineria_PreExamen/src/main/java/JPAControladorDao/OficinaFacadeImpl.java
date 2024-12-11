package JPAControladorDao;

import java.util.List;

import entidades.Oficina;
import jakarta.persistence.TypedQuery;

public class OficinaFacadeImpl extends AbstractFacadeJPAImpl<Oficina> implements OficinaFacade {

	public OficinaFacadeImpl() {
		super(Oficina.class);
	}

	@Override
	public List<Oficina> mostrarTodos(){
		TypedQuery<Oficina> q = getEm().createQuery("SELECT o FROM Oficina AS o", Oficina.class);
		return q.getResultList();
	}
	

}
