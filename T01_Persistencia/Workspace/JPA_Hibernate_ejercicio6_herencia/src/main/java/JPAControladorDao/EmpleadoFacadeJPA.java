package JPAControladorDao;

import java.util.List;

import entidades.Empleado;

public interface EmpleadoFacadeJPA extends AbstractFacadeJPA<Empleado> {
	public List<Empleado> mostrarTodos();
}
