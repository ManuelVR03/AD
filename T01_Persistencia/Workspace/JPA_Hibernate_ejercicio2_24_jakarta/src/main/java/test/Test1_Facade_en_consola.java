package test;

import java.util.List;

import JPAControladorDao.LibroFacadeImpl;
import entity.Libro;

public class Test1_Facade_en_consola {

	public static void main(String[] args) {
		LibroFacadeImpl lf = new LibroFacadeImpl();
		
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

	}

}
