package JPAControladorDao;

import java.util.List;
import jakarta.persistence.*;

import entidades.Editorial;

public interface EditorialFacade extends AbstractFacadeJPA<Editorial> {
	public List<Editorial> mostrarTodos();
	public List<Tuple> consulta2();
}
