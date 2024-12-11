package JPAControladorDao;

import java.util.List;

import entidades.Empleado;

public interface EmpleadoFacade extends AbstractFacadeJPA<Empleado> {
	public List<Empleado> mostrarTodos();
	public List<Empleado> empleadoOficina(String pais);
}
