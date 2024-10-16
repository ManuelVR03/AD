package test;

import java.util.List;

import JPAControladorDao.LibroFacadeImpl;
import JPAControladorDao.SocioFacadeImpl;
import entidades.*;

public class Test1_Facade_en_consola {

	public static void main(String[] args) {
		LibroFacadeImpl lf = new LibroFacadeImpl();
		SocioFacadeImpl sf = new SocioFacadeImpl();
		
		Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);
		
		lf.create(l1);
		lf.create(l2);
		lf.create(l3);
		lf.create(l4);
		List<Libro> listaLibros = lf.mostrarTodos();
		System.out.println(listaLibros);
		
		Socio s1 = new Socio(100, "socio1", "apellido1");
		Socio s2 = new Socio(200, "socio2", "apellido2");
		Socio s3 = new Socio(300, "socio3", "apellido3");
		Socio s4 = new Socio(400, "socio4", "apellido4");
		
		sf.create(s1);
		sf.create(s2);
		sf.create(s3);
		sf.create(s4);
		List<Socio> listaSocios = sf.mostrarTodos();
		System.out.println(listaSocios);
		
		s1.setNombre("Manuel");
		s1.setApellidos("Verdejo Ramírez");
		sf.update(s1);
		System.out.println(listaSocios);
		
		System.out.println("***********************");
		System.out.println("El nombre del primer socio es: " + sf.find(100).getNombre());
		
		System.out.println("***********************");
		System.out.println("Vamos a buscar al último socio y lo vamos a eliminar");
		sf.remove(sf.find(400));
		System.out.println("Socio eliminado con Éxito.");
		
		

	}

}
