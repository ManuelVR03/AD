package JPAControladorDao;

import java.util.List;

import entidades.Grupo;

public interface GrupoFacadeJPA extends AbstractFacadeJPA<Grupo> {
	public List<Grupo> mostrarTodos();
}
