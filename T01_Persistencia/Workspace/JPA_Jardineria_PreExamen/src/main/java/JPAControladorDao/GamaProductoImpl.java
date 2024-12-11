package JPAControladorDao;

import java.util.List;

import entidades.GamaProducto;
import jakarta.persistence.TypedQuery;

public class GamaProductoImpl extends AbstractFacadeJPAImpl<GamaProducto> implements GamaProductoFacade {

	public GamaProductoImpl() {
		super(GamaProducto.class);
	}

	@Override
	public List<GamaProducto> mostrarTodos(){
		TypedQuery<GamaProducto> q = getEm().createQuery("SELECT gp FROM GamaProducto AS gp", GamaProducto.class);
		return q.getResultList();
	}
	

}
