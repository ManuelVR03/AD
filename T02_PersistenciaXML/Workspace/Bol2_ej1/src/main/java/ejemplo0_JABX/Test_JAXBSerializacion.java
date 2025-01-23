package ejemplo0_JABX;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Test_JAXBSerializacion {

	private static final String PROVINCIA_DAT_FILE = "./Salidas/provincia.xml";
	
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Provincia.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Provincia provincia = fillProvincia();
		
		marshaller.marshal(provincia, System.out);
		
		FileOutputStream fos = new FileOutputStream(PROVINCIA_DAT_FILE);
		marshaller.marshal(provincia, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Provincia provinciaAux = (Provincia) unmarshaller.unmarshal(new File(PROVINCIA_DAT_FILE));
		System.out.println("****** Provincia cargado desde fichero XML ********");
		System.out.println(provinciaAux);

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
