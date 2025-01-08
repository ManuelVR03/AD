package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dom.DomXML;

// BOLETIN XML: Ejercicio 1: Crear un fichero XML desde el principio
// 							 llamado entradas.xml

public class Test1CreacionficheroXML {

	public static void main(String[] args) {

		try {
			DomXML documentoNuevo = new DomXML();
			crearDocumentoDesdeCero(documentoNuevo);
			documentoNuevo.escribirArchivo("./Salidas/entradas.xml");
			// System.out.println(documentoNuevo.convertirString());
			// documentoNuevo.escribirArchivo(System.out);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void crearDocumentoDesdeCero(DomXML documentoNuevo) {
		
		Document documento = documentoNuevo.getDocumento();
		// Creamos el elemento principal
		Element entrada = documento.createElement("entrada");
		// Añadimos el elemento al nodo principal
		documento.appendChild(entrada);
		
		// Creamos el Elemento título
		Element titulo = documento.createElement("titulo");
		// Establecer atributos:
		// titulo.setAttribute("num", "001")
		titulo.setTextContent("Creacion de XML");
		// Indicamos que título desciende de entrada
		entrada.appendChild(titulo);
		
		// <autor>hashRaygoza</autor>
		Element autor = documento.createElement("autor");
		autor.setTextContent("hashRaygoza");
		entrada.appendChild(autor);
		
		// <fecha>2016-10-08</fecha>
		Element fecha = documento.createElement("fecha");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha1 = LocalDate.parse("2016-10-08", dtf);
		fecha.setTextContent(fecha1.format(dtf));
		entrada.appendChild(fecha);
		
		
		
		
		
	}

}
