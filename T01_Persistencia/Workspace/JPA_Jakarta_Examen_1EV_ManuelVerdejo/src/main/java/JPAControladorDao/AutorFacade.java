package JPAControladorDao;

import java.util.List;

import entidades.Autor;

public interface AutorFacade extends AbstractFacadeJPA<Autor> {
	public List<Autor> mostrarTodos();
}
