package ejercicio4_JABX;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Test_JAXBSerializacion {

	private static final String PROVINCIA_DAT_FILE = "./Salidas/pais.xml";
	
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Pais.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Pais pais = fillPais();
		
		marshaller.marshal(pais, System.out);
		
		FileOutputStream fos = new FileOutputStream(PROVINCIA_DAT_FILE);
		marshaller.marshal(pais, fos);
		fos.close();
		
		

	}
	
	private static Pais fillPais() {
		Pais pais = new Pais();
		pais.setNombre("España");
        pais.setCapital("Madrid");
        pais.setFechaCenso(LocalDate.of(2023, 1, 1));
        pais.setContinente("Europa");
        pais.setHabitantes(47450795);
        pais.setImportancia(5);
		return pais;
	}

}
