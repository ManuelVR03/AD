package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dom.DomXML;

public class Test2LeerficheroXML {

	public static void main(String[] args) throws SAXException, IOException {
		try {
			DomXML documento = new DomXML("estudiantes.xml");
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		

	}

}
