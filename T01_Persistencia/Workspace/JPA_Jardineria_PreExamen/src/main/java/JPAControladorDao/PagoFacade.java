package JPAControladorDao;

import java.util.List;

import entidades.Pago;

public interface PagoFacade extends AbstractFacadeJPA<Pago> {
	public List<Pago> mostrarTodos();
}
