package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import entidades.Empleado;
import jakarta.persistence.TypedQuery;

public class DepartamentoFacadeJPAImpl extends AbstractFacadeJPAImpl<Departamento> implements DepartamentoFacadeJPA {

	public DepartamentoFacadeJPAImpl() {
		super(Departamento.class);
	}

	@Override
	public List<Departamento> mostrarTodos(){
		TypedQuery<Departamento> q = getEm().createQuery("SELECT d FROM Departamento AS d", Departamento.class);
		return q.getResultList();
	}
	
	@Override
	public List<Empleado> buscarEmpleadosPorDepto(Integer dep){
		TypedQuery<Empleado> q = getEm().createQuery("SELECT d.empleados FROM Departamento d WHERE d.codDep"
				+ "=:seleccionado", Empleado.class);
		q.setParameter("seleccionado", dep);
		return q.getResultList();
	}

}
