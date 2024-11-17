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
		
		System.out.println("Consulta de prueba:");
		TypedQuery<Empleado> query = ef.getEm().createQuery("SELECT e FROM Empleado AS e", Empleado.class);
		List<Empleado> resultQuery = query.getResultList();
		for(Empleado e: resultQuery) {
			System.out.println(e.toString());
		}
		
		
		
		
	}

}
