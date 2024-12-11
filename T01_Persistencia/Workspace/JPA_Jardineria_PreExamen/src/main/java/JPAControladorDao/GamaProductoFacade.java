package JPAControladorDao;

import java.util.List;

import entidades.GamaProducto;

public interface GamaProductoFacade extends AbstractFacadeJPA<GamaProducto> {
	public List<GamaProducto> mostrarTodos();
}
