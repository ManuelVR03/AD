package JPAControladorDao;

import java.util.List;

import entidades.Direccion;

public interface DireccionFacadeJPA extends AbstractFacadeJPA<Direccion> {
	public List<Direccion> mostrarTodos();
}
