package JPAControladorDao;

import java.util.List;

import entidades.Direccion;
import jakarta.persistence.TypedQuery;

public class DireccionFacadeJPAImpl extends AbstractFacadeJPAImpl<Direccion> implements DireccionFacadeJPA {

	public DireccionFacadeJPAImpl() {
		super(Direccion.class);
	}

	@Override
	public List<Direccion> mostrarTodos(){
		TypedQuery<Direccion> q = getEm().createQuery("SELECT d FROM Direccion AS d", Direccion.class);
		return q.getResultList();
	}
	

}
