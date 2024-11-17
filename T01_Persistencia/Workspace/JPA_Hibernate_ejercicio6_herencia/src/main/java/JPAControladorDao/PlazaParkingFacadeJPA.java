package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;

public interface PlazaParkingFacadeJPA extends AbstractFacadeJPA<PlazaParking> {
	public List<PlazaParking> mostrarTodos();
}
