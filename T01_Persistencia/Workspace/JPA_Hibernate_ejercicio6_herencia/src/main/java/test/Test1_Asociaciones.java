package test;

import entidades.*;
import JPAControladorDao.*;

public class Test1_Asociaciones {

	public static void main(String[] args) {

			Direccion d1 = new Direccion(1l, "calle1", "ciudad1", "pais1", 41001l);
			Direccion d2 = new Direccion(2l, "calle2", "ciudad2", "pais2", 41201l);
			Direccion d3 = new Direccion(3l, "Calle Camelia", "Sevilla", "España", 41008l);
			Direccion d4 = new Direccion(4l, "Calle Relator", "Sevilla", "España", 41003l);
			
			PlazaParking p1 = new PlazaParking("p100", 1, 00);
			PlazaParking p2 = new PlazaParking("p101", 1, 01);
			PlazaParking p3 = new PlazaParking("p110", 1, 02);
			PlazaParking p4 = new PlazaParking("p111", 1, 03);
			
			Empleado e1 = new Contratado("e1", "Luisa", "Jimenez", d1, 1387.55f, "Convenio colectivo");
			Empleado e2 = new Contratado("e2", "Luis", "RUS", d2, 832.76f, "Convenio Arboleda");
			Empleado e3 = new Contratado("e3", "Manuel", "Verdejo", d3, p3, 1836.45f, "Convenio Ingenieros");
			Empleado e4 = new Becario("e4", "Lucía", "Villar", d4, p4, "Manuel", 25.35f);
			
			Departamento dep1 = new Departamento(1, "contabilidad", 10000.);
			Departamento dep2 = new Departamento(2, "nuevas incorporaciones", 5000.);
			
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
			df.create(d3);
			df.create(d4);
			
			//Creo las plazas
			pf.create(p1);
			pf.create(p2);
			pf.create(p3);
			pf.create(p4);
			
			//Creo los empleados
			e1.setPlaza(p1);
			p1.setEmpleado(e1);
			ef.create(e1);
			
			e2.setPlaza(p2);
			p2.setEmpleado(e2);
			ef.create(e2);
			
			p3.setEmpleado(e3);
			ef.create(e3);
			
			p4.setEmpleado(e4);
			ef.create(e4);
			
			//Creo un depto y le asigno 2 empleados
			dep1.addEmpleado(e1);
			dep1.addEmpleado(e2);
			dpf.create(dep1);
			
			dep2.addEmpleado(e3);
			dep2.addEmpleado(e4);
			dpf.create(dep2);
			
			//Proyectos
			dep1.addProyecto(pr1);
			dep1.addProyecto(pr2);
			prf.create(pr1);
			prf.create(pr2);

			
			
	}
}
