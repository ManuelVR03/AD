package test;

import java.util.List;

import entidades.*;
import jakarta.persistence.Query;
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
		
		
	}

}
