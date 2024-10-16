package JPAControladorDao;

import java.util.List;

import entity.Socio;
import jakarta.persistence.TypedQuery;

public class SocioFacadeImpl extends AbstractFacadeJPAImpl<Socio> implements SocioFacade{

	public SocioFacadeImpl() {
		super(Socio.class);
		
	}
	
	@Override
	public List<Socio> mostrarTodos() {
		TypedQuery<Socio> q = getEm().createQuery("SELECT p FROM Socio AS p", Socio.class);
		return q.getResultList();
	}

}
