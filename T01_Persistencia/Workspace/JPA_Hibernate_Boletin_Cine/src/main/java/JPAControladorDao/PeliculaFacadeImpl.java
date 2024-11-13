package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;
import jakarta.persistence.TypedQuery;

public class PeliculaFacadeImpl extends AbstractFacadeJPAImpl<Pelicula> implements PeliculaFacade{

	public PeliculaFacadeImpl() {
		super(Pelicula.class);
	}
	
	@Override
	public List<Pelicula> mostrarTodos(){
		TypedQuery<Pelicula> q = getEm().createQuery("SELECT p FROM Pelicula AS p", Pelicula.class);
		return q.getResultList();
	}
}
