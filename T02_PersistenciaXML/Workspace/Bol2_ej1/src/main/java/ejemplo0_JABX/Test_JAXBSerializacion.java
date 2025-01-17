package ejemplo0_JABX;

public class Test_JAXBSerializacion {

	private static final String PROVINCIA_DAT_FILE = "./Salidas/provincia.xml";
	
	public static void main(String[] args) {
		

	}
	
	private static Provincia fillProvincia() {
		String[] nombreLocalidad = {"Madrid", "Coslada"};
		int[] cpLocalidad = {28028, 28820};
		Localidad[] localidades = new Localidad[2];
		
		for(int i = 0; i<2; i++) {
			localidades[i] = new Localidad();
			localidades[i].setCp(cpLocalidad[i]);
			localidades[i].setNombre(nombreLocalidad[i]);
		}
		
		Provincia provincia = new Provincia();
		provincia.setNombre("Madrid");
		provincia.setLocalidad(localidades);
		
		return provincia;
	}

}
