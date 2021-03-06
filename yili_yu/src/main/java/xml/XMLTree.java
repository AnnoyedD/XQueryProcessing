package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLTree {
	private String fileName;
	//private Element root;
	private Document doc;
	public Document getDocument(){
		return doc;
	}
	public XMLTree(){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			// dbf.setValidating(dtdValidate || xsdValidate);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			//root = doc.getDocumentElement();
			
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			// if (doc.hasChildNodes()) {

			// printNote(doc.getChildNodes());

			// }

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public XMLTree(String fileName) {
		this.fileName = fileName;
	
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			// dbf.setValidating(dtdValidate || xsdValidate);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(new File(this.fileName));
			//root = doc.getDocumentElement();
			
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			// if (doc.hasChildNodes()) {

			// printNote(doc.getChildNodes());

			// }

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Document getDoc(){
		return doc;
	}

	public String getFileName(){
		return fileName;
	}

	/*
	 * private static void printNote(NodeList nodeList) {
	 * 
	 * for (int count = 0; count < nodeList.getLength(); count++) {
	 * 
	 * Node tempNode = nodeList.item(count);
	 * 
	 * // make sure it's element node. if (tempNode.getNodeType() ==
	 * Node.ELEMENT_NODE) {
	 * 
	 * // get node name and value System.out.println("\nNode Name =" +
	 * tempNode.getNodeName() + " [OPEN]"); System.out.println("Node Value =" +
	 * tempNode.getTextContent());
	 * 
	 * if (tempNode.hasAttributes()) {
	 * 
	 * // get attributes names and values NamedNodeMap nodeMap =
	 * tempNode.getAttributes();
	 * 
	 * for (int i = 0; i < nodeMap.getLength(); i++) {
	 * 
	 * Node node = nodeMap.item(i); System.out.println("attr name : " +
	 * node.getNodeName()); System.out.println("attr value : " +
	 * node.getNodeValue());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (tempNode.hasChildNodes()) {
	 * 
	 * // loop again if has child nodes printNote(tempNode.getChildNodes());
	 * 
	 * }
	 * 
	 * System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
	 * 
	 * }
	 * 
	 * } }
	 */

}
