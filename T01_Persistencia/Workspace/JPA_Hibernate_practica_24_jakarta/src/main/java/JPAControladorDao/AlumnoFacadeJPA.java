package JPAControladorDao;

import java.util.List;

import entidades.Alumno;

public interface AlumnoFacadeJPA extends AbstractFacadeJPA<Alumno> {
	public List<Alumno> mostrarTodos();
}
