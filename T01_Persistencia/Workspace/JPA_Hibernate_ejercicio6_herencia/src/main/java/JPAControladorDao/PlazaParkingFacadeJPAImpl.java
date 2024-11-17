package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import jakarta.persistence.TypedQuery;

public class PlazaParkingFacadeJPAImpl extends AbstractFacadeJPAImpl<PlazaParking> implements PlazaParkingFacadeJPA {

	public PlazaParkingFacadeJPAImpl() {
		super(PlazaParking.class);
	}

	@Override
	public List<PlazaParking> mostrarTodos(){
		TypedQuery<PlazaParking> q = getEm().createQuery("SELECT p FROM PlazaParking AS p", PlazaParking.class);
		return q.getResultList();
	}
	

}
