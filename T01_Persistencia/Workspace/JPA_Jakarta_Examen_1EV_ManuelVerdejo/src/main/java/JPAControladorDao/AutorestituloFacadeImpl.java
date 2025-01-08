package JPAControladorDao;

import java.util.List;

import entidades.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutorestituloFacadeImpl extends AbstractFacadeJPAImpl<Autorestitulo> implements AutorestituloFacade {

	public AutorestituloFacadeImpl() {
		super(Autorestitulo.class);
	}

	@Override
	public List<Autorestitulo> mostrarTodos(){
		TypedQuery<Autorestitulo> q = getEm().createQuery("SELECT a FROM Autorestitulo AS a", Autorestitulo.class);
		return q.getResultList();
	}
	
	@Override
	public List<Tuple> consulta3(int autores) {
		TypedQuery<Tuple> query3 = getEm().createQuery("SELECT at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, at.titulo.precio, COUNT(at.autor) FROM Autorestitulo AS at GROUP BY at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, at.titulo.precio HAVING COUNT(at.autor) > :autores", Tuple.class);
		query3.setParameter("autores", autores);
		return query3.getResultList();
	}
	

}
