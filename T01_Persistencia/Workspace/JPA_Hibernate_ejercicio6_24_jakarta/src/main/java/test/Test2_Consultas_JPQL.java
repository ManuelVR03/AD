package test;

import java.util.List;

import entidades.*;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import JPAControladorDao.*;

public class Test2_Consultas_JPQL {

	public static void main(String[] args) {
		
		PlazaParkingFacadeJPAImpl pf = new PlazaParkingFacadeJPAImpl();
		DireccionFacadeJPAImpl df = new DireccionFacadeJPAImpl();
		EmpleadoFacadeJPAImpl ef = new EmpleadoFacadeJPAImpl();
		DepartamentoFacadeJPAImpl dpf = new DepartamentoFacadeJPAImpl();
		ProyectoFacadeJPAImpl prf = new ProyectoFacadeJPAImpl();
		
		/*
		 * Ejercicio 1: Crea un método con consulta JPQL y uso de createQuery que
		 * devuelva todos los empleados de la empresa.
		 * 
		 * Ejecución de sentencias JPQL con createQuery
		 * en el método mostrarTodos
		 */
		
		System.out.println("****                                                ****");
		System.out.println("** Ejercicio 1 CONSULTAS: MOSTRAR todos LOS EMPLEADOS **");
		System.out.println("****                                                ****");
		
		List<Empleado> listaEmpleados = ef.mostrarTodos();
		System.out.println(listaEmpleados);
		
		/*
		 * Ejercicio 2: Crea un método que devuelva todos Los proyectos
		 * del depto de código 1
		 * 
		 * Ejecución de sentencias JPQL (con createQuery)
		 * con parámetros dinámicos
		 */

		System.out.println("****                                                           ****");
		System.out.println("** Ejercicio 2 CONSULTA: MOSTRAR todos Los proyectos del depto 1 **");
		System.out.println("****                                                           ****");
		System.out.println(prf.buscarProyectosDeDepto(1));
		
		
		/*
		 * Ejercicio extra: 
		 */
		
		System.out.println("****                                                                                  ****");
		System.out.println("** Ejercicio extra CONSULTA: MOSTRAR todos Los proyectos del depto de nombre 'contabilidad' **");
		System.out.println("****                                                                                  ****");
		System.out.println(prf.buscarProyectosDeDeptoNombre("contabilidad"));
		System.out.println(prf.buscarProyectosDeDeptoNombreAnidado("contabilidad"));
		
		/*
		 * Ejercicio 3: Crea un método que devuelva todos los empleados del depto1 
		 */
		
		System.out.println("****                                                                ****");
		System.out.println("** Ejercicio 3 CONSULTA: MOSTRAR todos todos los empleados del depto1 **");
		System.out.println("****                                                                ****");
		System.out.println(dpf.buscarEmpleadosPorDepto(1));
		
		/*
		 * Ejercicio 4: Crea una consulta estática findAll que devuelva todos los empleados
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio4 ***");
		Query query = ef.getEm().createNamedQuery("Empleado.findAll");
		Query query2 = ef.getEm().createNamedQuery(Empleado.BUSCAR_TODOS_EMPLEADOS);
		System.out.println(query.getResultList());
		System.out.println(query2.getResultList());
		
		/*
		 * Ejercicio 5: Crea varias consultas estáticas en Departamento
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio5 ***");
		Query query3 = dpf.getEm().createNamedQuery(Departamento.BUSCAR_CODDEPT).setParameter("cod", 1);
		Query query4 = dpf.getEm().createNamedQuery(Departamento.ORDENAR_DESC_NOMBRE);
		System.out.println(query3.getResultList());
		System.out.println(query4.getResultList());
		
		/*
		 * Ejercicio 6: Consulta que devuelva el máximo y el mínimo código de empleado
		 */
		
		/*
		 * SELECT MAX(e.codEmpleado), MIN(e.codEmpleado) FROM Empleado e
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio 6 ***");
		TypedQuery<Tuple> queryEj6 = ef.getEm().createQuery("SELECT MAX(e.codEmpleado), MIN(e.codEmpleado) FROM Empleado e", Tuple.class);
		Tuple queryResult = queryEj6.getSingleResult();
		System.out.println("El max es: " + queryResult.get(0) + " El min es: " + queryResult.get(1));
		
		/*
		 * Ejercicio 7: consulta que devuelva el nombre y apellidos de los empleados.
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio 7 ***");
		TypedQuery<Tuple> queryEj7 = ef.getEm().createQuery("SELECT e.nombre, e.apellidos FROM Empleado e", Tuple.class);
		List<Tuple> queryList7 = queryEj7.getResultList();
		for (Tuple empleado: queryList7)
			System.out.println(empleado.get(0) + " " + empleado.get(1));
		//Query prueba = ef.getEm().createQuery("SELECT e.nombre, e.apellidos FROM Empleado e", Tuple.class);
		//System.out.println(prueba.getResultList());
		
		/*
		 * Ejercicio 8: Crea una consulta nativa de SQL que devuelva todas las direcciones
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio 8 ***");
		Query query8 = df.getEm().createNativeQuery("SELECT * FROM DIRECCION", Direccion.class);
		System.out.println(query8.getResultList());
		
		
		
		
	}

}
