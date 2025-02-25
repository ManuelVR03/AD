package ejemplo6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dom.DomXML;

public class Test_JAXBSerializacion {

	public static void main(String[] args) {
		String ruta = "./Fuentes/personas.bin";
		crearArchivoBinario(ruta);
		List<Persona> personas = fillPersonas(ruta);

		try {
			DomXML documento = new DomXML();
			crearDocumentoDesdeCero(documento, personas);
			documento.escribirArchivo("./Salidas/personas.xml");
			System.out.println(documento.convertirString());
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}

	}

	private static void crearArchivoBinario(String rutaArchivo) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			oos.writeObject(new Persona("Javier Mendoza Jimenez", 28, true));
			oos.writeObject(new Persona("Salvador Buena", 21, false));
			oos.writeObject(new Persona("Jose Angulo", 19, true));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Persona> fillPersonas(String rutaArchivo) {
		List<Persona> personas = new ArrayList<Persona>();
		Persona p;

		try {
			FileInputStream fis = new FileInputStream(rutaArchivo);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);

			while (bis.available() > 0) {
				p = (Persona) ois.readObject();
				personas.add(p);
			}

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

	private static void crearDocumentoDesdeCero(DomXML documentoNuevo, List<Persona> personas) {

		Document documento = documentoNuevo.getDocumento();
		Element personasE = documento.createElement("personas");
		documento.appendChild(personasE);

		for (Persona p : personas) {
			Element persona = documento.createElement("persona");

			Element nombre = documento.createElement("nombre");
			nombre.setTextContent(p.getNombre());
			persona.appendChild(nombre);

			Element edad = documento.createElement("edad");
			edad.setTextContent((p.getEdad()).toString());
			persona.appendChild(edad);

			Element soltero = documento.createElement("soltero");
			if (p.getSoltero())
				soltero.setTextContent("Soltero");
			else
				soltero.setTextContent("Casado");
			persona.appendChild(soltero);

			personasE.appendChild(persona);
		}

	}

}
