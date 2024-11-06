package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import entidades.Empleado;

public interface DepartamentoFacadeJPA extends AbstractFacadeJPA<Departamento> {
	public List<Departamento> mostrarTodos();
	public List<Empleado> buscarEmpleadosPorDepto(Integer dep);
}
