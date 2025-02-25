package ejemplo6;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ejemplo5_JABX.Pais2;
import ejemplo5_JABX.Paises;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Test_JAXB {
	
private static final String PERSONAS_DAT_FILE = "./Salidas/personasJAXB.xml";
	
	public static void main(String[] args) throws JAXBException, IOException  {
		JAXBContext context = JAXBContext.newInstance(Personas.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Personas personas = fillPersonas("./Fuentes/personas.bin");
		
		marshaller.marshal(personas, System.out);
		
		FileOutputStream fos = new FileOutputStream(PERSONAS_DAT_FILE);
		marshaller.marshal(personas, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Personas personasAux = (Personas) unmarshaller.unmarshal(new File(PERSONAS_DAT_FILE));
		System.out.println("****** Paises cargado desde fichero XML ********");
		System.out.println(personasAux);
	}
	
	private static Personas fillPersonas(String rutaArchivo) {
		Personas personas = new Personas();
		Set<Persona> listaPersonas = new HashSet<>();

		try {
			FileInputStream fis = new FileInputStream(rutaArchivo);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);

			while (bis.available() > 0) {
				Persona p = (Persona) ois.readObject();
				listaPersonas.add(p);
			}
			
			personas.setPersonas(listaPersonas);

			ois.close();
			bis.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personas;
	}

}
