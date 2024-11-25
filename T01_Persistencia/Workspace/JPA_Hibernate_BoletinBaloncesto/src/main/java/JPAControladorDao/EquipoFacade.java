package JPAControladorDao;

import java.util.List;

import entidades.Equipo;

public interface EquipoFacade extends AbstractFacadeJPA<Equipo>{

	public List<Equipo> mostrarTodos();
}
