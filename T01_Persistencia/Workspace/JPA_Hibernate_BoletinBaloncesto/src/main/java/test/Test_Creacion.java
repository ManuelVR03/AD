package test;

import java.text.DecimalFormat;
import java.util.List;

import JPAControladorDao.*;
import jakarta.persistence.*;

public class Test_Creacion {

	public static void main(String[] args) {

		EquipoFacadeImpl ef = new EquipoFacadeImpl();
		JugadoresFacadeImpl jf = new JugadoresFacadeImpl();
		PartidoFacadeImpl pf = new PartidoFacadeImpl();
		PartidosJugadoresFacadeImpl pjf = new PartidosJugadoresFacadeImpl();
		TempEquipoJugadorFacadeImpl tejf = new TempEquipoJugadorFacadeImpl();
		TemporadaFacadeImpl tf = new TemporadaFacadeImpl();

		/*
		 * Realiza en JPQL los siguientes ejercicios : 
		 * 1) Obtener un listado de los
		 * nombres de los equipos con los puntos a favor obtenidos en la temporada
		 * 2009_2010. (2 PUNTOS)*/
		
		System.out.println("*** Consulta 1: ***");
		//TypedQuery<Tuple> query1 = ef.getEm().createQuery("SELECT e.nombreEquipo, SUM(CASE WHEN p.equipo1 = e THEN p.puntosLocal ELSE 0 END) + SUM(CASE WHEN p.equipo2 = e THEN p.puntosVisitante ELSE 0 END) FROM Partido AS p JOIN Equipo AS e ON (p.equipo1 = e OR p.equipo2 = e) WHERE p.temporadaBean.nombre = '2009_2010' GROUP BY e.nombreEquipo", Tuple.class);
		TypedQuery<Tuple> query1 = ef.getEm().createQuery("SELECT e.nombreEquipo, (SELECT SUM(p.puntosLocal) FROM Partido AS p WHERE p.equipo1 = e AND p.temporadaBean.nombre = '2009_2010') + (SELECT SUM(p.puntosVisitante) FROM Partido AS p WHERE p.equipo2 = e AND p.temporadaBean.nombre = '2009_2010') FROM Equipo AS e", Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for(Tuple t: resultQuery1) {
			System.out.println("El equipo " + t.get(0) + " tiene " + t.get(1) + " puntos en la temporada 2009_2010");
		}
		
		 /* 2) ¿En qué equipos jugó el Sr Rafael Martinez en la
		 * temporada 2009-2010? Mostrar el nombre del equipo y el salario en miles de
		 * euros (1PUNTO) */
		
		System.out.println();
		System.out.println("*** Consulta 2: ***");
		TypedQuery<Tuple> query2 = ef.getEm().createQuery("SELECT DISTINCT tej.equipo.nombreEquipo, tej.salario FROM TempEquipoJugador AS tej WHERE tej.jugadore.nombreJugador = 'Rafa Martinez' AND tej.temporada.nombre = '2009_2010'", Tuple.class);
		List<Tuple> resultQuery2 = query2.getResultList();
		DecimalFormat formato = new DecimalFormat("#,###");
		System.out.println("El Sr Rafael Martinez jugó en: ");
		for(Tuple t: resultQuery2) {
			System.out.println("El equipo " + t.get(0) + "con salario de " + formato.format(t.get(1)) + "€");
		}
		
		 /* 3) Nombres de los jugadores que han cambiado de equipo en esta
		 * temporada (2010_2011) (2 PUNTOS) */
		
		System.out.println();
		System.out.println("*** Consulta 3: ***");
		TypedQuery<Tuple> query3 = ef.getEm().createQuery("SELECT tej.jugadore.nombreJugador FROM TempEquipoJugador AS tej WHERE tej.temporada.nombre = '2010_2011' GROUP BY tej.jugadore.nombreJugador HAVING COUNT(DISTINCT tej.equipo) > 1", Tuple.class);
		List<Tuple> resultQuery3 = query3.getResultList();
		for(Tuple t: resultQuery3) {
			System.out.println("EL jugador " + t.get(0) + " se ha cambiado de equipo.");
		}
		
		 /* 4) Nombres de los jugadores que han cambiado
		 * de equipo en la misma temporada . Muestra el nombre del jugador, la temporada
		 * y el no de veces que ha cambiado.(2 PUNTOS) */
		
		System.out.println();
		System.out.println("*** Consulta 4: ***");
		TypedQuery<Tuple> query4 = ef.getEm().createQuery("SELECT DISTINCT tej.jugadore.nombreJugador, tej.temporada.nombre, COUNT(tej.equipo) FROM TempEquipoJugador AS tej GROUP BY tej.jugadore.nombreJugador, tej.temporada.nombre HAVING COUNT(DISTINCT tej.equipo) > 1", Tuple.class);
		List<Tuple> resultQuery4 = query4.getResultList();
		for(Tuple t: resultQuery4) {
			System.out.println("El jugador " + t.get(0) + " en la temporada " + t.get(1) + " ha cambiado " + t.get(2) + " veces de equipo");
		}
		
		 /* 5) Obener un listado de los
		 * jugadores que no han cambiado de equipo nunca.En el listado tiene que
		 * aparecer el código y nombre de dicho jugador. (1 PUNTO ) */
		
		System.out.println();
		System.out.println("*** Consulta 5: ***");
		TypedQuery<Tuple> query5 = ef.getEm().createQuery("SELECT tej.jugadore.codJugador, tej.jugadore.nombreJugador FROM TempEquipoJugador AS tej GROUP BY tej.jugadore.codJugador, tej.jugadore.nombreJugador HAVING COUNT(DISTINCT tej.equipo) = 1", Tuple.class);
		List<Tuple> resultQuery5 = query5.getResultList();
		for(Tuple t: resultQuery5) {
			System.out.println("Código " + t.get(0) + " de nombre " + t.get(1) + " no ha cambiado de equipo nunca");
		}
		
		 /* 6) Obtener los
		 * códigos de los jugadores que jueguen en el equipo 'e1' donde su sueldo maximo
		 * en cualquier temporada sea menor o igual que el menor sueldo de cualquier
		 * jugador de la temporada 't2'. (2 PUNTOS)
		 */
		
		System.out.println();
		System.out.println("*** Consulta 6: ***");
		TypedQuery<Tuple> query6 = ef.getEm().createQuery("SELECT tej.jugadore.codJugador FROM TempEquipoJugador AS tej WHERE tej.equipo.codEquipo = :equipo GROUP BY tej.jugadore.codJugador HAVING MAX(tej.salario) <= (SELECT MIN(tej2.salario) FROM TempEquipoJugador AS tej2 WHERE tej2.temporada.codTemp = :temporada)", Tuple.class);
		query6.setParameter("equipo", "e1").setParameter("temporada", "t2");
		List<Tuple> resultQuery6 = query6.getResultList();
		for(Tuple t: resultQuery6) {
			System.out.println("Código jugador -> " + t.get(0));
		}
	}

}
