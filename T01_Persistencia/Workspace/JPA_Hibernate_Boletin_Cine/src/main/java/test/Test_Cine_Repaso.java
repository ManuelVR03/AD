package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import JPAControladorDao.*;
import entidades.Pelicula;
import jakarta.persistence.*;

public class Test_Cine_Repaso {

	public static void main(String[] args) {

		EntradaFacadeImpl ef = new EntradaFacadeImpl();
		PaseFacadeImpl psf = new PaseFacadeImpl();
		PeliculaFacadeImpl plf = new PeliculaFacadeImpl();
		SalaFacadeImpl sf = new SalaFacadeImpl();

		/*
		 * 1. Mostrar todos los géneros de los que nunca se haya proyectado una película
		 * en el multicine.
		 */

		System.out.println("**** Consulta 1 ****");
		TypedQuery<Tuple> query1 = psf.getEm().createQuery("SELECT DISTINCT pl.genero FROM Pelicula AS pl WHERE pl.genero NOT IN (SELECT ps.pelicula.genero FROM Pase AS ps)", Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for (Tuple t: resultQuery1)
			System.out.println("El género " + t.get(0) + " nunca se ha proyectado");
		System.out.println();

		/*
		 * 2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación
		 * de todas las películas.
		 */

		System.out.println("**** Consulta 2 ****");
		TypedQuery<Tuple> query2 = psf.getEm().createQuery("SELECT pl.titulo, pl.codpelicula, COUNT(ps.codpase), SUM(e.pvp) FROM Pelicula AS pl LEFT JOIN pl.pases AS ps LEFT JOIN ps.entradas AS e GROUP BY pl.titulo, pl.codpelicula ORDER BY pl.codpelicula", Tuple.class);
		List<Tuple> resultQuery2 = query2.getResultList();
		for (Tuple t: resultQuery2)
			if(t.get(3) == null)
				System.out.println("Película: " + t.get(0) + " Código: " + t.get(1) + " Pases: " + t.get(2) + " Recaudación: 0€");
			else
				System.out.println("Película: " + t.get(0) + " Código: " + t.get(1) + " Pases: " + t.get(2) + " Recaudación: " + t.get(3) + "€");
		System.out.println();
		

		/*
		 * 3. Mostrar cuántas salas distintas existen, donde se proyectan películas de
		 * un género determinado.
		 */

		System.out.println("**** Consulta 3 ****");
		TypedQuery<Tuple> query3 = psf.getEm().createQuery("SELECT pl.genero, COUNT(DISTINCT ps.sala) FROM Pelicula AS pl LEFT JOIN pl.pases AS ps GROUP BY pl.genero", Tuple.class);
		List<Tuple> resultQuery3 = query3.getResultList();
		for (Tuple t: resultQuery3)
			System.out.println("El género " + t.get(0) + " se ha proyectado en " + t.get(1) + " salas");
		System.out.println();

		/*
		 * 4. Obtener la información de todas las salas de cine en las que se haya
		 * proyectado alguna película de género TERROR o COMEDIA y cuya fecha de
		 * producción haya sido posterior a 2008. El listado debe aparecer ordenado por
		 * número de asientos en orden descendente.
		 */

		System.out.println("**** Consulta 4 ****");
		TypedQuery<Tuple> query4 = psf.getEm().createQuery("SELECT DISTINCT s.codsala, s.numasiporfilas*s.numfilas AS numAsientos FROM Sala AS s JOIN s.pases AS ps WHERE ps.pelicula.genero = 'TERROR' OR ps.pelicula.genero = 'COMEDIA' AND ps.pelicula.fechaProd > :fecha ORDER BY numAsientos DESC", Tuple.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date miFecha = sdf.parse("2008-12-31");
			query4.setParameter("fecha", miFecha);
			List<Tuple> resultQuery4 = query4.getResultList();
			for (Tuple t: resultQuery4)
				System.out.println("Sala: " + t.get(0) + " Número de asientos: " + t.get(1));
		}catch(ParseException e) {}
		System.out.println();

		/*
		 * 5. Mostrar un listado con la información de las películas proyectadas en
		 * salas DOLBY.
		 */

		System.out.println("**** Consulta 5 ****");
		TypedQuery<Tuple> query5 = psf.getEm().createQuery("SELECT DISTINCT pl.codpelicula, pl.fechaProd, pl.genero, pl.titulo FROM Pelicula AS pl JOIN pl.pases AS ps WHERE ps.sala.tipoSonido = 'DOLBY' ORDER BY pl.codpelicula", Tuple.class);
		List<Tuple> resultQuery5 = query5.getResultList();
		for (Tuple t: resultQuery5)
			System.out.println("Código: " + t.get(0) + " Fecha Producción: " + t.get(1) + " Género: " + t.get(2) + " Título: " + t.get(3));
		System.out.println();

		/*
		 * 6. Obtener un listado de todas las películas que han sido proyectadas en más
		 * de 5 ocasiones.
		 */

		
		System.out.println("**** Consulta 6 ****");
		TypedQuery<Tuple> query6 = psf.getEm().createQuery("SELECT DISTINCT pl.titulo FROM Pelicula AS pl JOIN pl.pases AS ps GROUP BY pl.titulo HAVING COUNT(ps) > 2", Tuple.class);
		List<Tuple> resultQuery6 = query6.getResultList();
		for (Tuple t: resultQuery6)
			System.out.println("Pelicula: " + t.get(0));
		System.out.println();
			
		
		/*
		 * 7. Obtener un listado con la recaudación total de las salas de cine agrupada
		 * por tipo de pase durante el mes de junio de 2006.
		 */

		

		/*
		 * 8. Mostrar un listado con la información de todas las películas proyectadas
		 * en salas de más de 100 asientos y con una venta de entradas de al menos el
		 * 50% del total del aforo de la sala.
		 */

		

		/*
		 * 9. A partir de un código de sala seleccionado, devolver el número de
		 * películas diferentes que se han proyectado en esa sala.
		 */
		
		
		
		/*
		 * Seleccionar todas las películas de la bbdd
		 */
		
		Query estatica1 = plf.getEm().createNamedQuery("Pelicula.findAll");
		System.out.println(estatica1.getResultList());
		

	}

}
