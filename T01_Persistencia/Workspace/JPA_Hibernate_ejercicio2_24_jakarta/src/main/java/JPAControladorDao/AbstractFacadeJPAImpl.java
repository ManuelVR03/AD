package JPAControladorDao;

import entity.Libro;
import jakarta.persistence.EntityManager;
import util.UtilJPA;

public abstract class AbstractFacadeJPAImpl<T> implements AbstractFacadeJPA<T>{

	private Class<T> entityClass;
	protected EntityManager em;
	
	public AbstractFacadeJPAImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		em = UtilJPA.getEntityManager();
	}
	
	@Override
	public Boolean create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al GUARDAR, clave duplicada");
			return false;
		}
		
	}
	
	@Override
	public Boolean update(T entity) {
		return null;
	}
	
	@Override
	public void remove(T entity) {
		
	}
	
	@Override
	public T find(Object id) {
		em.getTransaction().begin();
		try {
			T buscado = em.find(T.class, id);
			System.out.println(buscado);
			return buscado;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al BUSCAR, clave no válida");
			return T;
		}
	}

	@Override
	public EntityManager getEm() {
		return null;
	}
}


