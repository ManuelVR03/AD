package test;

import entidades.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test1_Asociaciones_OnetoOneUnidireccional {

	public static void main(String[] args) {

		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager = emfactory.createEntityManager();

			Direccion d1 = new Direccion(1l, "calle1", "ciudad1", "pais1", 41001l);
			Direccion d2 = new Direccion(2l, "calle2", "ciudad2", "pais2", 41201l);
			PlazaParking p1 = new PlazaParking("p100", 1, 00);
			PlazaParking p2 = new PlazaParking("p101", 1, 01);
			Empleado e1 = new Empleado("e1", "Luisa", "Jimenez", d1, p1);
			Empleado e2 = new Empleado("e2", "Luis", "RUS", d2, p2);

			emanager.getTransaction().begin();
			emanager.persist(d1);
			emanager.persist(p1);
			emanager.persist(e1);
			//en el objeto tengo que relacionar el parking con el empleado con un set.
			p1.setEmpleado(e1);
			System.out.println("Empleado asignado a parking1 es (con un set): " + p1.getEmpleado());
			emanager.getTransaction().commit();
			
			emanager.getTransaction().begin();
			emanager.persist(d2);
			emanager.persist(p2);
			emanager.persist(e2);
			p2.setEmpleado(e2);
			System.out.println("Empleado asignado a parking1 es (con un set): " + p2.getEmpleado());
			emanager.getTransaction().commit();

			System.out.println("** Empleados de la BD: **");
			TypedQuery<Empleado> query = emanager.createQuery("Select e from Empleado e ", Empleado.class);
			System.out.println(query.getResultList());
			
			emanager.close();
			emfactory.close();
		} catch (Exception e) {
			System.out.println("**Ha ocurrido un error al crear la BD**");
		}

	}

}
