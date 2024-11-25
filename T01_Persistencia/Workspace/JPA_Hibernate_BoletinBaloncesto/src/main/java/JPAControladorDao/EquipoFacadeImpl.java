package JPAControladorDao;

import java.util.List;

import entidades.Equipo;
import jakarta.persistence.TypedQuery;

public class EquipoFacadeImpl extends AbstractFacadeJPAImpl<Equipo> implements EquipoFacade{

	public EquipoFacadeImpl() {
		super(Equipo.class);
	}
	
	@Override
	public List<Equipo> mostrarTodos() {
		TypedQuery<Equipo> q = getEm().createQuery("SELECT e FROM Equipo AS e", Equipo.class);
		return q.getResultList();
	}
}
