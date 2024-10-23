package JPAControladorDao;

import java.util.List;

import entidades.Proyecto;

public interface ProyectoFacadeJPA extends AbstractFacadeJPA<Proyecto> {
	public List<Proyecto> mostrarTodos();
}
