package JPAControladorDao;

import java.util.List;

import entidades.Temporada;

public interface TemporadaFacade extends AbstractFacadeJPA<Temporada>{

	public List<Temporada> mostrarTodos();
}
