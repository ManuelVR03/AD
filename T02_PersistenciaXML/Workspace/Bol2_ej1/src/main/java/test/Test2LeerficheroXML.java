package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import dom.DomXML;

public class Test2LeerficheroXML {

	public static void main(String[] args) {
		try {
			DomXML documento = new DomXML("./Fuentes/estudiantes.xml");
			System.out.println("PRIMERA FORMA:");
			//documento.imprimirNodos(documento.getDocumento());
			System.out.println("SEGUNDA FORMA:");
			System.out.println(documento.convertirString());
			System.out.println("TERCERA FORMA:");
			documento.escribirArchivo();
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
