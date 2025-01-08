package JPAControladorDao;

import java.util.List;

import entidades.Autorestitulo;
import jakarta.persistence.Tuple;

public interface AutorestituloFacade extends AbstractFacadeJPA<Autorestitulo> {
	public List<Autorestitulo> mostrarTodos();
	public List<Tuple> consulta3(int autores);
}
