package JPAControladorDao;

import java.util.List;

import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeJPAImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacadeJPA {

	public ProyectoFacadeJPAImpl() {
		super(Proyecto.class);
	}

	@Override
	public List<Proyecto> mostrarTodos(){
		TypedQuery<Proyecto> q = getEm().createQuery("SELECT p FROM Proyecto AS p", Proyecto.class);
		return q.getResultList();
	}
	

}
