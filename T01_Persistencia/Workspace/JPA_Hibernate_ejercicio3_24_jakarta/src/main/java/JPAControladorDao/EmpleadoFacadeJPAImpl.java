package JPAControladorDao;

import java.util.List;

import entidades.Empleado;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeJPAImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacadeJPA {

	public EmpleadoFacadeJPAImpl() {
		super(Empleado.class);
	}

	@Override
	public List<Empleado> mostrarTodos(){
		TypedQuery<Empleado> q = getEm().createQuery("SELECT e FROM EMPLEADO AS e", Empleado.class);
		return q.getResultList();
	}
	

}
