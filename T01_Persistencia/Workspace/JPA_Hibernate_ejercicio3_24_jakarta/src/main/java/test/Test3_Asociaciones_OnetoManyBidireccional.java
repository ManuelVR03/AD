package test;

import entidades.*;
import JPAControladorDao.*;

public class Test3_Asociaciones_OnetoManyBidireccional {

	public static void main(String[] args) {

			Direccion d1 = new Direccion(1l, "calle1", "ciudad1", "pais1", 41001l);
			Direccion d2 = new Direccion(2l, "calle2", "ciudad2", "pais2", 41201l);
			
			PlazaParking p1 = new PlazaParking("p100", 1, 00);
			PlazaParking p2 = new PlazaParking("p101", 1, 01);
			
			Empleado e1 = new Empleado("e1", "Luisa", "Jimenez", d1);
			Empleado e2 = new Empleado("e2", "Luis", "RUS", d2);
			
			Departamento dep1 = new Departamento(1, "contabilidad", 10000.);
			
			Proyecto pr1 = new Proyecto(1, "Junta de Andalucía");
			Proyecto pr2 = new Proyecto(2, "Turismo Conil");
			
			PlazaParkingFacadeJPAImpl pf = new PlazaParkingFacadeJPAImpl();
			DireccionFacadeJPAImpl df = new DireccionFacadeJPAImpl();
			EmpleadoFacadeJPAImpl ef = new EmpleadoFacadeJPAImpl();
			DepartamentoFacadeJPAImpl dpf = new DepartamentoFacadeJPAImpl();
			ProyectoFacadeJPAImpl prf = new ProyectoFacadeJPAImpl();
			
			//El orden es importante
			
			//Creo las direcciones
			df.create(d1);
			df.create(d2);
			
			//Creo las plazas
			pf.create(p1);
			pf.create(p2);
			
			//Creo los empleados
			e1.setPlaza(p1);
			p1.setEmpleado(e1);
			ef.create(e1);
			
			e2.setPlaza(p2);
			p2.setEmpleado(e2);
			ef.create(e2);
			
			//Creo un depto y le asigno 2 empleados
			dep1.addEmpleado(e1);
			dep1.addEmpleado(e2);
			dpf.create(dep1);
			
			//Proyectos
			dep1.addProyecto(pr1);
			dep1.addProyecto(pr2);
			prf.create(pr1);
			prf.create(pr2);

			
			
	}
}
