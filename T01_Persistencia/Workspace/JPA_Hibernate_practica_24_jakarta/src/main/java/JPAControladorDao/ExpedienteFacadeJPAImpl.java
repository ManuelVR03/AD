package JPAControladorDao;

import java.util.List;

import entidades.Expediente;
import jakarta.persistence.TypedQuery;

public class ExpedienteFacadeJPAImpl extends AbstractFacadeJPAImpl<Expediente> implements ExpedienteFacadeJPA {

	public ExpedienteFacadeJPAImpl() {
		super(Expediente.class);
	}

	@Override
	public List<Expediente> mostrarTodos(){
		TypedQuery<Expediente> q = getEm().createQuery("SELECT e FROM EMPLEADO AS e", Expediente.class);
		return q.getResultList();
	}
	

}
