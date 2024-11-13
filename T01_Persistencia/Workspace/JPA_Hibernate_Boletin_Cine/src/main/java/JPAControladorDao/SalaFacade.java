package JPAControladorDao;

import java.util.List;

import entidades.Sala;

public interface SalaFacade extends AbstractFacadeJPA<Sala>{

	public List<Sala> mostrarTodos();
}
