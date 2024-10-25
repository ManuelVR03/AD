package test;

import java.util.List;

import entity.Libro;
import entity.Socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test3_Asociaciones_OnetoManyBidireccional {

	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager();
		
		Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);
		
		Socio s1 = new Socio(100, "socio1", "apellido1");
		Socio s2 = new Socio(200, "socio2", "apellido2");
		
		emanager.getTransaction().begin();
		emanager.persist(l1);
		emanager.persist(l2);
		emanager.persist(l3);
		emanager.persist(l4);
		emanager.persist(s1);
		emanager.persist(s2);
		emanager.getTransaction().commit();
		
		emanager.getTransaction().begin();
		l1.addSocio(s1);
		l2.addSocio(s1);
		l3.addSocio(s1);
		emanager.getTransaction().commit();
		
			
			
	}
}
