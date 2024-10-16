package JPAControladorDao;

import java.util.List;

import entidades.Libro;
import jakarta.persistence.TypedQuery;

public class LibroFacadeImpl extends AbstractFacadeJPAImpl<Libro> implements LibroFacade{

	public LibroFacadeImpl() {
		super(Libro.class);
		
	}
	
	@Override
	public List<Libro> mostrarTodos() {
		TypedQuery<Libro> q = getEm().createQuery("SELECT p FROM Libro AS p", Libro.class);
		return q.getResultList();
	}

}
