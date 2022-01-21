package main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dom.DomNewDocument;
import dom.DomReader;

public class main {

	public static void main(String[] args) {

		//Crating a new xml document
		DomNewDocument domNewDocument = new DomNewDocument();
		domNewDocument.generateDocument("files/productos.xml");
		
		//reading an existing xml document
		DomReader domReader = new DomReader("files/productos.xml");
		domReader.readDocument();
	}

}
