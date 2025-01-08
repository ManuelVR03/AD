package JPAControladorDao;

import java.util.List;

import entidades.Editorial;
import jakarta.persistence.*;

public class EditorialFacadeImpl extends AbstractFacadeJPAImpl<Editorial> implements EditorialFacade {

	public EditorialFacadeImpl() {
		super(Editorial.class);
	}

	@Override
	public List<Editorial> mostrarTodos(){
		TypedQuery<Editorial> q = getEm().createQuery("SELECT e FROM Editorial AS e", Editorial.class);
		return q.getResultList();
	}
	
	@Override
	public List<Tuple> consulta2(){
		TypedQuery<Tuple> query2 = getEm().createQuery("SELECT e, COUNT(t.codtitulo) FROM Editorial AS e LEFT JOIN e.titulos AS t GROUP BY e ORDER BY e.ciudad DESC, e.nombre ASC", Tuple.class);
		return query2.getResultList();
	}
	

}
