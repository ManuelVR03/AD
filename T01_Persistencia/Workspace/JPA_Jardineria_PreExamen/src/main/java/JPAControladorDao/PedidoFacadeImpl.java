package JPAControladorDao;

import java.util.List;

import entidades.Pedido;
import jakarta.persistence.TypedQuery;

public class PedidoFacadeImpl extends AbstractFacadeJPAImpl<Pedido> implements PedidoFacade {

	public PedidoFacadeImpl() {
		super(Pedido.class);
	}

	@Override
	public List<Pedido> mostrarTodos(){
		TypedQuery<Pedido> q = getEm().createQuery("SELECT p FROM Pedido AS p", Pedido.class);
		return q.getResultList();
	}
	

}
