package JPAControladorDao;

import java.util.List;

import entidades.Autor;
import jakarta.persistence.TypedQuery;

public class AutorFacadeImpl extends AbstractFacadeJPAImpl<Autor> implements AutorFacade {

	public AutorFacadeImpl() {
		super(Autor.class);
	}

	@Override
	public List<Autor> mostrarTodos(){
		TypedQuery<Autor> q = getEm().createQuery("SELECT a FROM Autor AS a", Autor.class);
		return q.getResultList();
	}
	

}
