package JPAControladorDao;

import java.util.List;

import entidades.Entrada;
import jakarta.persistence.TypedQuery;

public class EntradaFacadeImpl extends AbstractFacadeJPAImpl<Entrada> implements EntradaFacade{

	public EntradaFacadeImpl() {
		super(Entrada.class);
	}
	
	@Override
	public List<Entrada> mostrarTodos(){
		TypedQuery<Entrada> q = getEm().createQuery("SELECT e FROM Entrada AS e", Entrada.class);
		return q.getResultList();
	}
}
