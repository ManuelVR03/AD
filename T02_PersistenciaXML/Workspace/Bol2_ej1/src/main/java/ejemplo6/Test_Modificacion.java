package ejemplo6;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dom.DomXML;

public class Test_Modificacion {

	public static void main(String[] args) {
		
		try {
			DomXML documento = new DomXML("./Salidas/personas.xml");
			NodeList persona = (NodeList)(XPathFactory.newInstance().newXPath().evaluate("//persona[nombre='Jose Angulo']", documento.getDocumento(), XPathConstants.NODE));
			for (int i = 0; i < persona.getLength(); i++) {
				if (persona.item(i).getNodeName() == "nombre")
					persona.item(i).setTextContent("Lucía Villar");
			}
			documento.escribirArchivo("./Salidas/personasModificado.xml");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
