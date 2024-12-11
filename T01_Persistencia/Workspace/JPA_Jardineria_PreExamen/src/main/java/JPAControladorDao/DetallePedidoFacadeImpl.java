package JPAControladorDao;

import java.util.List;

import entidades.DetallePedido;
import jakarta.persistence.TypedQuery;

public class DetallePedidoFacadeImpl extends AbstractFacadeJPAImpl<DetallePedido> implements DetallePedidoFacade {

	public DetallePedidoFacadeImpl() {
		super(DetallePedido.class);
	}

	@Override
	public List<DetallePedido> mostrarTodos(){
		TypedQuery<DetallePedido> q = getEm().createQuery("SELECT dp FROM DetallePedido AS dp", DetallePedido.class);
		return q.getResultList();
	}
	

}
