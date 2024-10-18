package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import jakarta.persistence.TypedQuery;

public class DepartamentoFacadeJPAImpl extends AbstractFacadeJPAImpl<Departamento> implements DepartamentoFacadeJPA {

	public DepartamentoFacadeJPAImpl() {
		super(Departamento.class);
	}

	@Override
	public List<Departamento> mostrarTodos(){
		TypedQuery<Departamento> q = getEm().createQuery("SELECT d FROM Departamento AS d", Departamento.class);
		return q.getResultList();
	}
	

}
