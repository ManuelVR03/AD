package JPAControladorDao;

import java.util.List;

import entidades.Libro;

public interface LibroFacade extends AbstractFacadeJPA<Libro> {
	public List<Libro> mostrarTodos();
}
