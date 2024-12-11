package JPAControladorDao;

import java.util.List;

import entidades.Oficina;

public interface OficinaFacade extends AbstractFacadeJPA<Oficina> {
	public List<Oficina> mostrarTodos();
}
