package JPAControladorDao;

import java.util.List;

import entidades.Grupo;
import jakarta.persistence.TypedQuery;

public class GrupoFacadeJPAImpl extends AbstractFacadeJPAImpl<Grupo> implements GrupoFacadeJPA {

	public GrupoFacadeJPAImpl() {
		super(Grupo.class);
	}

	@Override
	public List<Grupo> mostrarTodos(){
		TypedQuery<Grupo> q = getEm().createQuery("SELECT g FROM EMPLEADO AS g", Grupo.class);
		return q.getResultList();
	}
	

}
