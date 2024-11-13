package tests;

import daos.EmpleadoFacadeJPAImpl;
import entidades.*;

public class Test_herencia_table_per_class {

	public static void main(String[] args) {
		
		Empleado e1 = new Contratado("001", "Manuel", "Verdejo", 2486.92f, "Convenio Alto Standing");
		Empleado e2 = new Contratado("002", "Raúl", "Navarro", 1877.33f, "Convenio Coca-Cola");
		Empleado e3 = new Becario("003", "Paco", "Candela", "Manuel", 9.66f);
		Empleado e4 = new Becario("004", "Jesus", "Heredia", "Raúl", 4.13f);
		
		EmpleadoFacadeJPAImpl ef = new EmpleadoFacadeJPAImpl();
		
		ef.create(e1);
		ef.create(e2);
		ef.create(e3);
		ef.create(e4);

	}

}
