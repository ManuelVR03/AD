package JPAControladorDao;

import java.util.List;

import entidades.Proyecto;

public interface ProyectoFacadeJPA extends AbstractFacadeJPA<Proyecto> {
	public List<Proyecto> mostrarTodos();
	public List<Proyecto> buscarProyectosDeDepto(Integer dep);
	public List<Proyecto> buscarProyectosDeDeptoNombre(String depNombre);
	public List<Proyecto> buscarProyectosDeDeptoNombreAnidado(String depNombre);
}
