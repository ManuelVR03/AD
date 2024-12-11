package JPAControladorDao;

import java.util.List;

import entidades.Cliente;
import jakarta.persistence.TypedQuery;

public class ClienteFacadeImpl extends AbstractFacadeJPAImpl<Cliente> implements ClienteFacade {

	public ClienteFacadeImpl() {
		super(Cliente.class);
	}

	@Override
	public List<Cliente> mostrarTodos(){
		TypedQuery<Cliente> q = getEm().createQuery("SELECT c FROM Cliente AS c", Cliente.class);
		return q.getResultList();
	}
	

}
