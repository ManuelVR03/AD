package test;

import java.util.List;

import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test1_Uso_de_EntityManager {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager();

		// EntityManager emanager2 =
		// Persistence.createEntityManagerFactory("Persistencia").createEntityManager();

		Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);

		System.out.print("llegamos...");

		emanager.getTransaction().begin();
		emanager.persist(l1); // El que realiza el insert .persist();
		l1.setTitulo("JPA e Hibernate");
		emanager.flush();
		emanager.persist(l2);
		emanager.persist(l3);
		emanager.persist(l4);
		emanager.getTransaction().commit();

		boolean gestionada = emanager.contains(l1);
		System.out.println("l1 está gestionada " + gestionada);

		emanager.getTransaction().begin();
		l1.setTitulo("nuevo cambio");
		boolean gestionadaNueva = emanager.contains(l1);
		System.out.println("l1 está en una nueva transacción, ¿sigue gestionada? " + gestionadaNueva);
		emanager.getTransaction().commit();

		emanager.getTransaction().begin();
		Libro libroBuscado = emanager.find(Libro.class, "200");
		System.out.println(libroBuscado);
		emanager.getTransaction().commit();

		libroBuscado.setTitulo("el árbol de la vida");
		libroBuscado = emanager.find(Libro.class, "200");
		System.out.println(libroBuscado);

		TypedQuery<Libro> query = emanager.createQuery("Select e from Libro e", Libro.class);
		List<Libro> list = query.getResultList();
		System.out.println(list);

		emanager.getTransaction().begin();
		emanager.persist(libroBuscado);
		libroBuscado.setTitulo("hoy es viernes");
		emanager.refresh(libroBuscado);
		emanager.getTransaction().commit();
		System.out.println("**Compruebo si ha modificado el titulo**");
		System.out.println("**Gracias al refresh ha revertido los cambios");
		List<Libro> list2 = query.getResultList();
		System.out.println(list2);

		emanager.getTransaction().begin();
		libroBuscado.setAutor("pepito");
		emanager.merge(libroBuscado);
		emanager.getTransaction().commit();

		emanager.getTransaction().begin();
		emanager.detach(l4);

		l4.setAutor("Juanito");
		query = emanager.createQuery("Select e from Libro e ", Libro.class);
		System.out.println("Consulta: " + query.getResultList());
		System.out.println("****l4 está persistida: " + emanager.contains(l4));

		emanager.merge(l4);
		System.out.println("consulta despueś del merge: " + query.getResultList());
		System.out.println("****l4 pasa a estado manage " + emanager.contains(l4));
		System.out.println("l4 sigue sin estar en el contexto de persistencia, " 
		+ "aunque haga una actualización con merge");
		
		System.out.println("vamos a buscar el libro 400 con find y haremos que pase al contexto de persistencia");
		l4 = emanager.find(Libro.class, "400");
		System.out.println("l4 pasa a estado manage " + emanager.contains(l4));
		emanager.getTransaction().commit();
		
		emanager.close();
		emfactory.close();
	}

}
