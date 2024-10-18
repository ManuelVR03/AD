package test;

import entidades.*;
import JPAControladorDao.*;

public class Test2_Asociaciones_OnetoManyUnidireccional {

	public static void main(String[] args) {

			Direccion d1 = new Direccion(1l, "calle1", "ciudad1", "pais1", 41001l);
			Direccion d2 = new Direccion(2l, "calle2", "ciudad2", "pais2", 41201l);
			
			PlazaParking p1 = new PlazaParking("p100", 1, 00);
			PlazaParking p2 = new PlazaParking("p101", 1, 01);
			
			Empleado e1 = new Empleado("e1", "Luisa", "Jimenez", d1);
			Empleado e2 = new Empleado("e2", "Luis", "RUS", d2);
			
			Departamento dep1 = new Departamento(1, "contabilidad", 10000.);
			
			PlazaParkingFacadeJPAImpl pf = new PlazaParkingFacadeJPAImpl();
			DireccionFacadeJPAImpl df = new DireccionFacadeJPAImpl();
			EmpleadoFacadeJPAImpl ef = new EmpleadoFacadeJPAImpl();
			DepartamentoFacadeJPAImpl dpf = new DepartamentoFacadeJPAImpl();
			
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
			dpf.create(dep1);
			dep1.addEmpleado(e1);
			dep1.addEmpleado(e2);
			
	}
}
