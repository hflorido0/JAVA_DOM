package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DomReader extends DefaultHandler {
	Document document;
	
	public DomReader() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			File file = new File ("files/productos.xml");
			document = builder.parse(file);
		} catch (ParserConfigurationException e) {
			System.out.println("Error parsing the xml");
		} catch (SAXException e) {
			System.out.println("Error generating xml");
		} catch (IOException e) {
			System.out.println("Error finding the file");
		}
	}

	public void readDocument() {
		//Getting root element
		Element root = document.getDocumentElement();
		System.out.println("root element - " + root.getNodeName());
		
		//Getting all products in a list
		NodeList products = root.getChildNodes();
		
		//loop over all products
		for (int i = 0; i < products.getLength(); i++) {
			
			//we get the product node in position "i"
			Node node = products.item(i);
			//we cast it into an Element object
			Element product = (Element) node;
			String name = product.getAttribute("name");
			
			//we get a list of nodes with tag price inside the product node
			//it's a list but with only 1 element
			NodeList prices = product.getElementsByTagName("price");
			Node priceNode = prices.item(0);
			
			//we get the price value
			String priceValue = priceNode.getTextContent();
			
			//we cast it into an Element object
			Element price = (Element) priceNode;
			String badge = price.getAttribute("badge");
			
			//we get a list of nodes with tag stock inside the product node
			//it's a list but with only 1 element
			NodeList stocks = product.getElementsByTagName("stock");
			Node stockNode = stocks.item(0);
			
			//we get the price value
			String stockValue = stockNode.getTextContent();
			
			//we cast it into an Element object
			Element stock = (Element) stockNode;
			String color = stock.getAttribute("color");
			String storage = stock.getAttribute("storage");
			
			//we print all the info:
			System.out.println(product.getNodeName() + " name: " + name);
			System.out.println("price: " + priceValue + " badge: " + badge);
			System.out.println("stock: " + stockValue + " color: " + color + " storage: " + storage);
			
		}
		
		
	}

}
