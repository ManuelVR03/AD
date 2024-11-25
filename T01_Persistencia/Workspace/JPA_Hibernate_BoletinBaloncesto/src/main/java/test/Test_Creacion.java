package test;

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
		TypedQuery<Tuple> query1 = ef.getEm().createQuery("SELECT DISTINCT tej.equipo.nombreEquipo, SUM(p.puntosLocal) FROM TempEquipoJugador AS tej JOIN tej.temporada.partidos AS p WHERE tej.temporada.nombre = '2009_2010' GROUP BY tej.equipo.nombreEquipo", Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for(Tuple t: resultQuery1) {
			System.out.println("El equipo " + t.get(0) + " tiene " + t.get(1) + " puntos en la temporada 2009_2010");
		}
		
		 /* 2) ¿En qué equipos jugó el Sr Rafael Martinez en la
		 * temporada 2009-2010? Mostrar el nombre del equipo y el salario en miles de
		 * euros (1PUNTO) */
		
		 /* 3) Nombres de los jugadores que han cambiado de equipo en esta
		 * temporada (2010_2011) (2 PUNTOS) */
		
		 /* 4) Nombres de los jugadores que han cambiado
		 * de equipo en la misma temporada . Muestra el nombre del jugador, la temporada
		 * y el no de veces que ha cambiado.(2 PUNTOS) */
		
		 /* 5) Obener un listado de los
		 * jugadores que no han cambiado de equipo nunca.En el listado tiene que
		 * aparecer el código y nombre de dicho jugador. (1 PUNTO ) */
		
		 /* 6) Obtener los
		 * códigos de los jugadores que jueguen en el equipo 'e1' donde su sueldo maximo
		 * en cualquier temporada sea menor o igual que el menor sueldo de cualquier
		 * jugador de la temporada 't2'. (2 PUNTOS)
		 */
	}

}
