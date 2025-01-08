package JPAControladorDao;

import java.util.List;

import entidades.Titulo;
import jakarta.persistence.*;

public interface TituloFacade extends AbstractFacadeJPA<Titulo> {
	public List<Titulo> mostrarTodos();
	public List<Titulo> consulta1();
}
