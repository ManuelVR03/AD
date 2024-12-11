package JPAControladorDao;

import java.util.List;

import entidades.Empleado;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacade {

	public EmpleadoFacadeImpl() {
		super(Empleado.class);
	}

	@Override
	public List<Empleado> mostrarTodos(){
		TypedQuery<Empleado> q = getEm().createQuery("SELECT e FROM Empleado AS e", Empleado.class);
		return q.getResultList();
	}
	
	// Consulta: Obtener los empleados que trabajan en oficinas en paises diferentes a un pais especifico y que no tiene un jefe asignado
	@Override
	public List<Empleado> empleadoOficina(String pais){
		//TypedQuery<Empleado> query = getEm().createQuery("SELECT e FROM Empleado AS e WHERE e.oficina.pais != :pais GROUP BY e HAVING COUNT(e.empleado) = 0", Empleado.class).setParameter("pais", pais);
		TypedQuery<Empleado> query = getEm().createQuery("SELECT e FROM Empleado AS e WHERE e.oficina.pais != :pais AND e.empleado IS NULL", Empleado.class).setParameter("pais", pais);
		return query.getResultList();
		
	}

}
