package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import JPAControladorDao.*;
import entidades.*;
import jakarta.persistence.*;

public class Test_Consultas {

	public static void main(String[] args) {
		
		AutorestituloFacadeImpl atf = new AutorestituloFacadeImpl();
		AutorFacadeImpl af = new AutorFacadeImpl();
		EditorialFacadeImpl ef = new EditorialFacadeImpl();
		TituloFacadeImpl tf = new TituloFacadeImpl();
		
		System.out.println("*** Consulta 1 ***");
		List<Titulo> result1 = tf.consulta1();
		for(Titulo t: result1)
			System.out.println(t);
		System.out.println();
		
		System.out.println("*** Consulta 2 ***");
		List<Tuple> result2 = ef.consulta2();
		for(Tuple t: result2)
			System.out.println(t.get(0) + " Número de libros publicados: " + t.get(1));
		System.out.println();
		
		System.out.println("*** Consulta 3 ***");
		int autores = 1;
		List<Tuple> result3 = atf.consulta3(autores);
		for (Tuple t: result3)
			System.out.println("Código: " + t.get(0) + " Título: " + t.get(1) + " Género: " + t.get(2) + " Precio: " + t.get(3) + "€ Número de autores: " + t.get(4));
		System.out.println();
		
		System.out.println("*** Ejercicio 4 ***");
		Editorial e = (Editorial) ef.getEm().createNamedQuery("Editorial.miLibro").getSingleResult();
		List<Autorestitulo> autorestitulo = new ArrayList<>();
		AutorestituloPK atPK1 = new AutorestituloPK("a1", "t6");
		AutorestituloPK atPK2 = new AutorestituloPK("a2", "t6");
		Autor a1 = (Autor) af.getEm().createNamedQuery("Autor.autor1").getSingleResult();
		Autor a2 = (Autor) af.getEm().createNamedQuery("Autor.autor2").getSingleResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date fecha = sdf.parse("2024-01-01");
			Titulo t = new Titulo("t6", 10., fecha, "terror", 22.4, "Nuevo Libro", 15., "Mi Libro", 15., e);
			Autorestitulo at1 = new Autorestitulo(atPK1, 3, 10, a1, t);
			Autorestitulo at2 = new Autorestitulo(atPK2, 3, 10, a2, t);
			autorestitulo.add(at1);
			autorestitulo.add(at2);
			t.setAutorestitulos(autorestitulo);
			tf.create(t);
			atf.create(at1);
			atf.create(at2);
		}catch(ParseException ex) {}
		TypedQuery<Titulo> query4 = tf.getEm().createQuery("SELECT t FROM Titulo AS t", Titulo.class);
		for(Titulo t4: query4.getResultList())
			System.out.println(t4);
	}

}
