package ejemplo5_JABX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Test_JAXBSerializacion {

	private static final String PAISES_DAT_FILE = "./Salidas/paises.xml";
	
	public static void main(String[] args) throws JAXBException, IOException  {
		JAXBContext context = JAXBContext.newInstance(Paises.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Paises paises = fillPaises();
		
		marshaller.marshal(paises, System.out);
		
		FileOutputStream fos = new FileOutputStream(PAISES_DAT_FILE);
		marshaller.marshal(paises, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Paises paisesAux = (Paises) unmarshaller.unmarshal(new File(PAISES_DAT_FILE));
		System.out.println("****** Paises cargado desde fichero XML ********");
		System.out.println(paisesAux);
	}
	
	public static Paises fillPaises() throws IOException {
		Paises paises = new Paises();
		Set<Pais2> listaPaises = new HashSet<>();
		String fichero = "./Fuentes/paises.txt";
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		while(br.ready()) {
			String linea = br.readLine();
			linea = linea.replaceAll(" ", "");
			String datos[] = linea.split(",");
			Pais2 pais = new Pais2();
			pais.setPais_Nombre(datos[0]);
			pais.setPais_Capital(datos[1]);
			LocalDate fecha = LocalDate.of(Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
			pais.setFechaCenso(fecha);
			pais.setPais_Continente(datos[5]);
			pais.setPais_Habitantes(Integer.parseInt(datos[6]));
			pais.setImportancia(Integer.parseInt(datos[7]));
			listaPaises.add(pais);
			
		}
		
		paises.setListaPaises(listaPaises);
		
		br.close();
		fr.close();
		
		return paises;
	}
	
}