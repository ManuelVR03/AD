package JPAControladorDao;

import java.util.List;

import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeJPAImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacadeJPA {

	public ProyectoFacadeJPAImpl() {
		super(Proyecto.class);
	}

	@Override
	public List<Proyecto> mostrarTodos(){
		TypedQuery<Proyecto> q = getEm().createQuery("SELECT p FROM Proyecto AS p", Proyecto.class);
		return q.getResultList();
	}
	
	@Override
	public List<Proyecto> buscarProyectosDeDepto(Integer dep){
		TypedQuery<Proyecto> q = getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.codDep"
				+ "=:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", dep);
		return q.getResultList(); 
	}
	
	@Override
	public List<Proyecto> buscarProyectosDeDeptoNombre(String depNombre){
		TypedQuery<Proyecto> q = getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.dnombre"
				+ "=:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", depNombre);
		return q.getResultList(); 
	}
	
	@Override
	public List<Proyecto> buscarProyectosDeDeptoNombreAnidado(String depNombre){
		TypedQuery<Proyecto> q = getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.codDep IN (SELECT d.codDep FROM Departamento d WHERE d.dnombre=:seleccionado)", Proyecto.class);
		q.setParameter("seleccionado", depNombre);
		return q.getResultList(); 
	}
	

}
