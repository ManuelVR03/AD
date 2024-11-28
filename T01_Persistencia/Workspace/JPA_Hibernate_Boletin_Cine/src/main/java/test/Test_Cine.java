package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		TypedQuery<Tuple> query1 = plf.getEm().createQuery(
				"SELECT DISTINCT pl.genero FROM Pelicula AS pl WHERE pl.genero NOT IN (SELECT DISTINCT p.pelicula.genero FROM Pase AS p)",
				Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for (Tuple item : resultQuery1) {
			System.out.println("El género: " + item.get(0) + " nunca ha sido proyectado.");
		}

		/*
		 * 2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación
		 * de todas las películas.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 2 ***");
		/*TypedQuery<Tuple> query2 = plf.getEm()
				.createQuery(
						"SELECT pl.titulo, pl.codpelicula, COUNT(DISTINCT p.codpase), SUM(e.pvp) FROM Pelicula AS pl "
								+ "JOIN pl.pases AS p JOIN p.entradas AS e GROUP BY pl.titulo, pl.codpelicula",
						Tuple.class);*/
		TypedQuery<Tuple> query2 = plf.getEm().createQuery("SELECT DISTINCT p.titulo, p.codpelicula, COUNT(DISTINCT ps.codpase), SUM(e.pvp) FROM Pelicula AS p LEFT JOIN p.pases AS ps LEFT JOIN ps.entradas AS e GROUP BY p.titulo, p.codpelicula ORDER BY p.codpelicula", Tuple.class);
		List<Tuple> resultQuery2 = query2.getResultList();
		Object pvp;
		for (Tuple item : resultQuery2) {
			if(item.get(3) == null) {
				pvp = 0;
			}else
				pvp = item.get(3);
			System.out.println("Título: " + item.get(0) + " Código: " + item.get(1) + " Número de Pases: " + item.get(2)
					+ " Recaudación: " + pvp + "€");
		}

		/*
		 * 3. Mostrar cuántas salas distintas existen, donde se proyectan películas de
		 * un género determinado.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 3 ***");
		// TypedQuery<Tuple> query3 = sf.getEm().createQuery("SELECT COUNT(DISTINCT
		// s.codsala) FROM Sala AS s JOIN s.pases AS p JOIN p.pelicula AS pl WHERE
		// pl.genero = :seleccionado", Tuple.class);
		// TypedQuery<Tuple> query3 = sf.getEm().createQuery("SELECT COUNT(DISTINCT
		// p.sala.codsala) FROM Pase AS p WHERE p.pelicula.genero = :seleccionado",
		// Tuple.class);
		TypedQuery<Tuple> query3 = sf.getEm().createQuery(
				"SELECT COUNT(DISTINCT p.sala.codsala) FROM Pelicula AS pl JOIN pl.pases AS p WHERE pl.genero = :seleccionado",
				Tuple.class);
		// Elegir entre ACCION, BELICO, C.FICCION, COMEDIA, TERROR
		String genero3 = "C.FICCION";
		query3.setParameter("seleccionado", genero3);
		Tuple resultQuery3 = query3.getSingleResult();
		System.out.println(resultQuery3.get(0));

		/*
		 * 4. Obtener la información de todas las salas de cine en las que se haya
		 * proyectado alguna película de género TERROR o COMEDIA y cuya fecha de
		 * producción haya sido posterior a 2008. El listado debe aparecer ordenado por
		 * número de asientos en orden descendente.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 4 ***");
		TypedQuery<Tuple> query4 = sf.getEm().createQuery(
				"SELECT DISTINCT s.codsala, s.numasiporfilas, s.numfilas, s.tipoSonido FROM Sala AS s JOIN s.pases as p "
				+ "WHERE (p.pelicula.genero = :parametro1 OR p.pelicula.genero = :parametro2) AND p.pelicula.fechaProd > :parametro3 ORDER BY s.numasiporfilas DESC",
				Tuple.class);
		Date fecha4;
		SimpleDateFormat formato4 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha4 = formato4.parse("31/12/2008");
		} catch (ParseException e) {
			fecha4 = null;
		}
		query4.setParameter("parametro1", "TERROR").setParameter("parametro2", "COMEDIA").setParameter("parametro3",
				fecha4);
		List<Tuple> resultQuery4 = query4.getResultList();
		for (Tuple item : resultQuery4) {
			System.out.println("Código: " + item.get(0) + " Asientos por filas: " + item.get(1) + " Número filas: "
					+ item.get(2) + " Tipo Sonido: " + item.get(3));
		}

		/*
		 * 5. Mostrar un listado con la información de las películas proyectadas en
		 * salas DOLBY.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 5 ***");
		TypedQuery<Tuple> query5 = plf.getEm().createQuery(
				"SELECT DISTINCT pl.codpelicula, pl.fechaProd, pl.genero, pl.titulo FROM Pelicula as pl JOIN pl.pases as p WHERE p.sala.tipoSonido = :parametro1",
				Tuple.class);
		query5.setParameter("parametro1", "DOLBY");
		List<Tuple> resultQuery5 = query5.getResultList();
		for (Tuple item : resultQuery5) {
			System.out.println("Código: " + item.get(0) + " Fecha: " + item.get(1) + " Género: " + item.get(2)
					+ " 	Título: " + item.get(3));
		}

		/*
		 * 6. Obtener un listado de todas las películas que han sido proyectadas en más
		 * de 5 ocasiones.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 6 ***");
		TypedQuery<Tuple> query6 = plf.getEm().createQuery(
				"SELECT DISTINCT pl.codpelicula, pl.titulo FROM Pelicula as pl JOIN pl.pases AS p GROUP BY pl.codpelicula, pl.titulo HAVING COUNT(p.codpase) > 5",
				Tuple.class);
		List<Tuple> resultQuery6 = query6.getResultList();
		for (Tuple item : resultQuery6) {
			System.out.println("Código: " + item.get(0) + " Título: " + item.get(1));
		}

		/*
		 * 7. Obtener un listado con la recaudación total de las salas de cine agrupada
		 * por tipo de pase durante el mes de junio de 2006.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 7 ***");
		TypedQuery<Tuple> query7 = sf.getEm().createQuery(
				"SELECT p.tipoPase, SUM(e.pvp) FROM Pase AS p JOIN p.entradas AS e WHERE p.fechaPase >= :parametro1 AND p.fechaPase <= :parametro2 GROUP BY p.tipoPase",
				Tuple.class);
		Date fecha7, fecha72;
		try {
			fecha7 = formato4.parse("01/06/2006");
			fecha72 = formato4.parse("30/06/2006");
		} catch (ParseException e) {
			fecha7 = null;
			fecha72 = null;
		}
		query7.setParameter("parametro1", fecha7).setParameter("parametro2", fecha72);
		List<Tuple> queryResult7 = query7.getResultList();
		for (Tuple item : queryResult7) {
			System.out.println("Tipo pase: " + item.get(0) + " Recaudación: " + item.get(1) + "€");
		}

		/*
		 * 8. Mostrar un listado con la información de todas las películas proyectadas
		 * en salas de más de 100 asientos y con una venta de entradas de al menos el
		 * 50% del total del aforo de la sala.
		 */

		System.out.println();
		System.out.println("*** Ejercicio 8 ***");
		TypedQuery<Tuple> query8 = plf.getEm().createQuery(
				"SELECT DISTINCT p.pelicula.codpelicula, p.pelicula.titulo FROM Pase AS p JOIN p.entradas AS e "
				+ "WHERE p.sala.numasiporfilas * p.sala.numfilas > 100 GROUP BY p.pelicula.codpelicula, p.pelicula.titulo, p.sala.numasiporfilas, p.sala.numfilas "
				+ "HAVING SUM(e.pvp) >= p.sala.numasiporfilas * p.sala.numfilas * 0.5",
				Tuple.class);
		List<Tuple> resultQuery8 = query8.getResultList();
		for (Tuple item : resultQuery8) {
			System.out.println("Código: " + item.get(0) + " Título: " + item.get(1));
		}

		/*
		 * 9. A partir de un código de sala seleccionado, devolver el número de
		 * películas diferentes que se han proyectado en esa sala.
		 */
		
		System.out.println();
		System.out.println("*** Ejercicio 9 ***");
		TypedQuery<Tuple> query9 = sf.getEm().createQuery("SELECT COUNT(DISTINCT p.pelicula.codpelicula) FROM Pase AS p WHERE p.sala.codsala = :parametro1", Tuple.class);
		query9.setParameter("parametro1", 4);
		Tuple queryResult9 = query9.getSingleResult();
		System.out.println("Se han proyectado " + queryResult9.get(0) + " películas.");

	}

}
