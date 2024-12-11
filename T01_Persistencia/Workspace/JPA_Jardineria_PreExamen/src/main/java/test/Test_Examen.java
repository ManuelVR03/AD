package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import JPAControladorDao.*;
import jakarta.persistence.*;
import entidades.*;

public class Test_Examen {

	public static void main(String[] args) {

		ClienteFacadeImpl cf = new ClienteFacadeImpl();
		DetallePedidoFacadeImpl dpf = new DetallePedidoFacadeImpl();
		EmpleadoFacadeImpl ef = new EmpleadoFacadeImpl();
		GamaProductoImpl gpf = new GamaProductoImpl();
		OficinaFacadeImpl of = new OficinaFacadeImpl();
		PagoFacadeImpl pf = new PagoFacadeImpl();
		PedidoFacadeImpl pdf = new PedidoFacadeImpl();
		ProductoFacadeImpl prf = new ProductoFacadeImpl();

		// + Consultas Teóricas +

		// -> Consultas estáticas

		// Consulta: Mostrar todos los clientes
		System.out.println("***** Consulta 1 *****");
		TypedQuery<Cliente> tQuery1 = cf.getEm().createNamedQuery("Cliente.findAll", Cliente.class);
		List<Cliente> lClientes1 = tQuery1.getResultList();
		for (Cliente c : lClientes1)
			System.out.println(c);
		System.out.println();

		// Consulta: Mostrar todos los clientes de la ciudad de Madrid
		System.out.println("***** Consulta 2 *****");
		TypedQuery<Cliente> tQuery2 = cf.getEm().createNamedQuery("ClientesMadrid", Cliente.class);
		List<Cliente> lClientes2 = tQuery2.getResultList();
		for (Cliente c : lClientes2)
			System.out.println(c);
		System.out.println();

		// Consulta: Mostrar todos los clientes de USA
		System.out.println("***** Consulta 3 *****");
		TypedQuery<Cliente> tQuery3 = cf.getEm().createNamedQuery(Cliente.CLIENTES_ESTADOUNIDENSES, Cliente.class);
		List<Cliente> lClientes3 = tQuery3.getResultList();
		for (Cliente c : lClientes3)
			System.out.println(c);

		// -> Consultas dinámicas con Tuplas

		// Consulta: Obtener el total de ventas (cantidad*precioUnidad) por cliente y
		// producto
		System.out.println("***** Consulta dinámica 1 *****");
		TypedQuery<Tuple> query1 = pdf.getEm().createQuery(
				"SELECT dp.pedido.cliente.nombreCliente, dp.producto.nombre, SUM(dp.cantidad*dp.precioUnidad) AS totalVenta FROM DetallePedido AS dp GROUP BY dp.pedido.cliente.nombreCliente, dp.producto.nombre",
				Tuple.class);
		List<Tuple> resultQuery1 = query1.getResultList();
		for (Tuple t : resultQuery1) {
			System.out.println("Cliente: " + t.get(0) + " Pedido: " + t.get(1) + " Total de Venta: " + t.get(2) + "€");
		}
		System.out.println();

		// Consulta: Obtener el numero de productos vendidos y el total de ventas por
		// gama de productos
		System.out.println("***** Consulta dinámica 2 *****");
		TypedQuery<Tuple> query2 = pdf.getEm().createQuery(
				"SELECT g.gama, COUNT(dp.producto), SUM(dp.cantidad*dp.precioUnidad) AS totalVenta FROM DetallePedido AS dp RIGHT JOIN dp.producto.gamaProducto AS g GROUP BY g.gama",
				Tuple.class);
		List<Tuple> resultQuery2 = query2.getResultList();
		for (Tuple t : resultQuery2) {
			if (t.get(2) == null)
				System.out.println("Gama: " + t.get(0) + " Productos vendidos: " + t.get(1) + " Total de venta: 0€");
			else
				System.out.println("Gama: " + t.get(0) + " Productos vendidos: " + t.get(1) + " Total de venta: "
						+ t.get(2) + "€");
		}
		System.out.println();

		// Consulta: Obtener los clientes con pedidos pendientes que no han realizado
		// pagos.
		System.out.println("***** Consulta dinámica 3 *****");
		TypedQuery<Tuple> query3 = pdf.getEm().createQuery(
				"SELECT pd.cliente.nombreCliente FROM Pedido AS pd LEFT JOIN pd.cliente.pagos AS pg WHERE pd.estado = 'Pendiente' GROUP BY pd.cliente.nombreCliente HAVING COUNT(pg) = 0",
				Tuple.class);
		List<Tuple> resultQuery3 = query3.getResultList();
		for (Tuple t : resultQuery3) {
			System.out.println("CLiente: " + t.get(0));
		}
		System.out.println();

		// Consulta: Obtener los empleados que trabajan en oficinas en paises diferentes
		// a un pais especifico y que no tiene un jefe asignado
		System.out.println("***** Consulta dinámica 4 *****");
		for (Empleado e : ef.empleadoOficina("Inglaterra")) {
			System.out.println(e);
		}
		System.out.println();

		// Consulta: Los productos con mas de 50 u en stock que no hayan sido vendidos en los ultimos 6 meses
		System.out.println("***** Consulta dinámica 5 *****");
		TypedQuery<Date> fecha = pdf.getEm().createQuery("SELECT MAX(pd.fechaPedido) FROM Pedido AS pd", Date.class);
		Date fin = fecha.getSingleResult();
		LocalDate inicio = fin.toLocalDate().minusMonths(6);
		TypedQuery<Producto> query5 = pdf.getEm().createQuery("SELECT p FROM Producto AS p WHERE p.cantidadEnStock > 50 AND p NOT IN (SELECT dp.producto FROM DetallePedido AS dp WHERE dp.pedido.fechaPedido >= :inicio AND dp.pedido.fechaPedido <= :fin)", Producto.class).setParameter("inicio", inicio).setParameter("fin", fin);
		for (Producto p: query5.getResultList()) {
			System.out.println(p);
		}
		System.out.println(fin);
		System.out.println(inicio);

	}

}
