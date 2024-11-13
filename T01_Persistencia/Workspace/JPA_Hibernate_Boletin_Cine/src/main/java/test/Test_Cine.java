package test;

import java.util.List;

import JPAControladorDao.*;
import jakarta.persistence.*;

public class Test_Cine {

	public static void main(String[] args) {

		EntradaFacadeImpl ef = new EntradaFacadeImpl();
		PaseFacadeImpl psf = new PaseFacadeImpl();
		PeliculaFacadeImpl plf = new PeliculaFacadeImpl();
		SalaFacadeImpl sf = new SalaFacadeImpl();

		/*
		 * 1. Mostrar todos los géneros de los que nunca se haya proyectado una película
		 * en el multicine.
		 */
		
		System.out.println("*** Ejercicio 1 ***");
		TypedQuery<Tuple> query1 = plf.getEm().createQuery("SELECT DISTINCT pl.genero FROM Pelicula AS pl WHERE pl.genero NOT IN (SELECT DISTINCT p.pelicula.genero FROM Pase AS p)", Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for(Tuple item: resultQuery1) {
			System.out.println("El género: " + item.get(0) + " nunca ha sido proyectado.");
		}
		
		
		 /* 2. Mostrar los campos título, codpelicula, , cantidad de
		 * pases y recaudación de todas las películas.
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio 2 ***");
		TypedQuery<Tuple> query2 = plf.getEm().createQuery("SELECT pl.titulo, pl.codpelicula, COUNT(pl.pases), SUM(pl.pases.entradas.pvp) FROM Pelicula AS pl JOIN pl.pases JOIN pl.pases.entradas GROUP BY pl.titulo, p.codpelicula", Tuple.class);
		List<Tuple> resultQuery2 = query2.getResultList();
		for(Tuple item: resultQuery2) {
			System.out.println(item.get(0) + " " + item.get(1) + " " + item.get(2) + " " + item.get(3));
		}
		
		
		
		 /* 3. Mostrar cuántas salas
		 * distintas existen, donde se proyectan películas de un género determinado. 
		 * 4. Obtener la información de todos las salas de cine en las que se haya
		 * proyectado alguna película de género TERROR o COMEDIA y cuya fecha de
		 * producción haya sido posterior a 2008. El listado debe aparecer ordenado por
		 * número de asientos en orden descendente. 
		 * 5. Mostrar un listado con la
		 * información de las películas proyectadas en salas DOLBY. 
		 * 6. Obtener un
		 * listado de todas las películas que han sido proyectadas en más de 5
		 * ocasiones. 
		 * 7. Obtener un listado con la recaudación total de las salas de
		 * cine agrupada por tipo de pase durante el mes de junio de 2006. 
		 * 8. Mostrar un
		 * listado con la información de todas las películas proyectadas en salas de más
		 * de 100 asientos y con una venta de entradas de al menos el 50% del total del
		 * aforo de la sala. 
		 * 9. A partir de un código de sala seleccionado, devolver el
		 * número de películas diferentes que se han proyectado en esa sala.
		 */

	}

}
