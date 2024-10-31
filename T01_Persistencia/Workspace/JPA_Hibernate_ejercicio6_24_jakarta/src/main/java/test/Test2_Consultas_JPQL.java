package test;

import java.util.List;

import entidades.*;
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
	}

}
