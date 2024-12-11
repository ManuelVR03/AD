package JPAControladorDao;

import java.util.List;

import entidades.Pedido;

public interface PedidoFacade extends AbstractFacadeJPA<Pedido> {
	public List<Pedido> mostrarTodos();
}
