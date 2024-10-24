package JPAControladorDao;

import java.util.List;

import entidades.Expediente;

public interface ExpedienteFacadeJPA extends AbstractFacadeJPA<Expediente> {
	public List<Expediente> mostrarTodos();
}
