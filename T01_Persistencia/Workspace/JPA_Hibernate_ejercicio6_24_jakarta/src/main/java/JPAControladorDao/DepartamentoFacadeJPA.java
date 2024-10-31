package JPAControladorDao;

import java.util.List;

import entidades.Departamento;

public interface DepartamentoFacadeJPA extends AbstractFacadeJPA<Departamento> {
	public List<Departamento> mostrarTodos();
}
