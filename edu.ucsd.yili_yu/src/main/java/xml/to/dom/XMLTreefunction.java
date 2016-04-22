package xml.to.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLTreefunction {

	public static Node getRoot(Document doc){
		return (Node)doc.getDocumentElement();
	}
	
	public static List<Node> getChildren(Node parent) {
		List<Node> children = new ArrayList<Node>();
		Node childNode = parent.getFirstChild();
		for (; childNode != null;) {
			if (childNode.getNodeType() == Node.ELEMENT_NODE)
				children.add(childNode);
			childNode = childNode.getNextSibling();;
		}
		return children;
	}
	
	public static Node getParent(Node child) {
		Node parent = child.getParentNode();
		while (parent.getNodeType() != Node.ELEMENT_NODE) {
			parent = parent.getParentNode();
		}
		return parent;
	}
	
	public static String getTag(Node n) {
		return n.getNodeName();
	}
	

}
