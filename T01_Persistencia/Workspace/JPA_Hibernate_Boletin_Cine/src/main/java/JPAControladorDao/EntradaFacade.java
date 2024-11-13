package JPAControladorDao;

import java.util.List;

import entidades.Entrada;

public interface EntradaFacade extends AbstractFacadeJPA<Entrada>{

	public List<Entrada> mostrarTodos();
}
