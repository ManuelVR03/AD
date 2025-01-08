package JPAControladorDao;

import java.util.List;

import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TituloFacadeImpl extends AbstractFacadeJPAImpl<Titulo> implements TituloFacade {

	public TituloFacadeImpl() {
		super(Titulo.class);
	}

	@Override
	public List<Titulo> mostrarTodos(){
		TypedQuery<Titulo> q = getEm().createQuery("SELECT t FROM Titulo AS t", Titulo.class);
		return q.getResultList();
	}
	
	@Override
	public List<Titulo> consulta1(){
		TypedQuery<Titulo> query1 = getEm().createQuery("SELECT t FROM Titulo AS t WHERE (t.genero = 'business' OR t.genero = 'psychology') AND t.tirada-t.ventas <= 0 ORDER BY t.titulo", Titulo.class);
		return query1.getResultList();
	}

}
