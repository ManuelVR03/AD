package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dom.DomXML;

public class Test3BusquedaModificacionXML {

	public static void main(String[] args) throws XPathExpressionException {
		try {
			DomXML documento = new DomXML("./Fuentes/estudiantes.xml");
			
			// Buscamos una etiqueta dentro del XML
			NodeList listaNodos = documento.getDocumento().getElementsByTagName("apodo");
			for (int i = 0; i < listaNodos.getLength(); i++) {
				Node nodo = listaNodos.item(i);
				if (nodo instanceof Element) {
					System.out.println(nodo.getTextContent());
				}
			}
			
			// Buscamos una etiqueta mediante XPath
			System.out.println("Xpath muestra todos los estudiantes");
			Node nodoClase = (Node)(XPathFactory.newInstance().newXPath().evaluate("/clase", documento.getDocumento(), XPathConstants.NODE));
			if(nodoClase != null) {
				System.out.println(nodoClase.getTextContent());
			}
			
			// Muestra los elementos del estudiante 493
			System.out.println("Xpath muestra los datos del estudiante 493");
			Node nodoClase2 = (Node)(XPathFactory.newInstance().newXPath().evaluate("//estudiante[@rollno='493']", documento.getDocumento(), XPathConstants.NODE));
			if(nodoClase != null) {
				System.out.println(nodoClase2.getTextContent());
			}
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
