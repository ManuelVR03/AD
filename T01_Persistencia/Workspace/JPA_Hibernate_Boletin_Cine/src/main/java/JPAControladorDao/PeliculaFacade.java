package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;

public interface PeliculaFacade extends AbstractFacadeJPA<Pelicula>{

	public List<Pelicula> mostrarTodos();
}
