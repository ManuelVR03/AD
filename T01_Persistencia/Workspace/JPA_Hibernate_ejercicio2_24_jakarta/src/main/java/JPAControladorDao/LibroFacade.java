package JPAControladorDao;

import java.util.List;

import entity.Libro;

public interface LibroFacade extends AbstractFacadeJPA<Libro> {
	public List<Libro> mostrarTodos();
}
