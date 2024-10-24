package test;

import java.util.Date;

import JPAControladorDao.AlumnoFacadeJPAImpl;
import JPAControladorDao.ExpedienteFacadeJPAImpl;
import JPAControladorDao.GrupoFacadeJPAImpl;
import entidades.*;

public class Test_Practica_JPA {

	public static void main(String[] args) {
		
		Expediente e1 = new Expediente(1, new Date());
		Expediente e2 = new Expediente(2, new Date());
		
		Alumno a1 = new Alumno(1, "Manuel", "Verdejo", "Ramírez", new Date());
		Alumno a2 = new Alumno(2, "Raúl", "Verdejo", "Navarro", new Date());
		
		Grupo g1 = new Grupo(1, "DAM");
		
		AlumnoFacadeJPAImpl af = new AlumnoFacadeJPAImpl();
		GrupoFacadeJPAImpl gf = new GrupoFacadeJPAImpl();
		ExpedienteFacadeJPAImpl ef = new ExpedienteFacadeJPAImpl();
		
		// Creo los expedientes
		ef.create(e1);
		ef.create(e2);
		
		// Creo los alumnos
		a1.setExpediente(e1);
		e1.setAlumno(a1);
		af.create(a1);
		
		a2.setExpediente(e2);
		e2.setAlumno(a2);
		af.create(a2);
		
		// Creo el grupo
		g1.addAlumno(a1);
		g1.addAlumno(a2);
		gf.create(g1);
		
	}

}
