package JPAControladorDao;

import java.util.List;

import entidades.Pago;
import jakarta.persistence.TypedQuery;

public class PagoFacadeImpl extends AbstractFacadeJPAImpl<Pago> implements PagoFacade {

	public PagoFacadeImpl() {
		super(Pago.class);
	}

	@Override
	public List<Pago> mostrarTodos(){
		TypedQuery<Pago> q = getEm().createQuery("SELECT p FROM Pago AS p", Pago.class);
		return q.getResultList();
	}
	

}
