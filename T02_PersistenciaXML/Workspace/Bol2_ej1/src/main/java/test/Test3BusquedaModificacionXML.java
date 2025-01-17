package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
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
			if(nodoClase2 instanceof Element) {
				System.out.println(nodoClase2.getTextContent());
			}
			
			// Muestra todos los estudiantes
			System.out.println("Xpath muestra ...");
			XPath xpath = XPathFactory.newInstance().newXPath();
			String xPathExpression = "/clase/estudiante";
			NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento.getDocumento(), XPathConstants.NODESET);
			for (int i=0;i<nodos.getLength();i++) {
				System.out.println(nodos.item(i).getNodeName() + " : " + nodos.item(i).getTextContent());
			}
			System.out.println();
			
			// Añade una nueva etiqueta llamada beca a ese estudiante.
			// Crea estudiantesmodificado.xml con esta nueva información
			// Muestralo en pantalla
			/*System.out.println("******************************************************************************");
			Document nuevoDocumento = documento.getDocumento();
			Element beca = nuevoDocumento.createElement("Beca");
			beca.setTextContent("Si");
			nodoClase2.appendChild(beca);
			documento.escribirArchivo("./Salidas/estudiantesmodificado.xml");
			DomXML nuevoDocumentoLectura = new DomXML("./Salidas/estudiantesmodificado.xml");
			System.out.println(nuevoDocumentoLectura.convertirString());*/
			System.out.println("******************************************************************************");
			Element beca = documento.getDocumento().createElement("Beca");
			beca.setTextContent("Si");
			nodoClase2.appendChild(beca);
			documento.escribirArchivo("./Salidas/estudiantesmodificado.xml");
			System.out.println(documento.convertirString());
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
