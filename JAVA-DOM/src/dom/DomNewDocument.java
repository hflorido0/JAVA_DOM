package dom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomNewDocument {
	private Document document;
	
	public DomNewDocument() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println("ERROR generating doucment");
		}
	}
	

	public void generateDocument() {
		//PARENT NODE
		//root node
		Element products = document.createElement("products");
		document.appendChild(products);
		
		//CHILD NODES
		//child node into root node "products"
		Element product = document.createElement("product");
		products.appendChild(product);
		
		//FINAL NODES
		//child into product with attribute and content
		Element price = document.createElement("price");
		price.setAttribute("badge", "Euro");
		price.setTextContent("29.99");
		product.appendChild(price);
		
		//child into product with 2 attributes and content
		Element stock = document.createElement("stock");
		stock.setAttribute("color", "blue");
		stock.setAttribute("storage", "22");
		stock.setTextContent("32");
		product.appendChild(stock);
		
		//another child node for root node "products"
		product = document.createElement("product");
		
		//this one with attribute
		product.setAttribute("name", "product 2");
		products.appendChild(product);
		
		
		//child into product with attribute and content
		price = document.createElement("price");
		price.setAttribute("badge", "Dollar");
		price.setTextContent("14.95");
		product.appendChild(price);
		
		//child into product with 2 attributes and content
		stock = document.createElement("stock");
		stock.setAttribute("color", "red");
		stock.setAttribute("storage", "40");
		stock.setTextContent("21");
		product.appendChild(stock);
		
		
		generateXml();
		
		//Cnt + shift + F to beautify the xml generated
	}
	
	private void generateXml() {
		try {			
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			
			Source source = new DOMSource(document);
			File file = new File("files/productos.xml");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			Result result = new StreamResult(pw);
			
			transformer.transform(source, result);
		} catch (IOException e) {
			System.out.println("Error when creating writter file");
		} catch (TransformerException e) {
			System.out.println("Error transforming the document");
		}
	}
}
