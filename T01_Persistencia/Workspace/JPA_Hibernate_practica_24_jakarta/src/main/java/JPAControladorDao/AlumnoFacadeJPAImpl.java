package JPAControladorDao;

import java.util.List;

import entidades.Alumno;
import jakarta.persistence.TypedQuery;

public class AlumnoFacadeJPAImpl extends AbstractFacadeJPAImpl<Alumno> implements AlumnoFacadeJPA {

	public AlumnoFacadeJPAImpl() {
		super(Alumno.class);
	}

	@Override
	public List<Alumno> mostrarTodos(){
		TypedQuery<Alumno> q = getEm().createQuery("SELECT a FROM EMPLEADO AS a", Alumno.class);
		return q.getResultList();
	}
	

}
