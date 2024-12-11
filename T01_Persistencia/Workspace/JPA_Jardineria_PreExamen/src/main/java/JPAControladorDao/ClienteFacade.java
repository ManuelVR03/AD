package JPAControladorDao;

import java.util.List;

import entidades.Cliente;

public interface ClienteFacade extends AbstractFacadeJPA<Cliente> {
	public List<Cliente> mostrarTodos();
}
