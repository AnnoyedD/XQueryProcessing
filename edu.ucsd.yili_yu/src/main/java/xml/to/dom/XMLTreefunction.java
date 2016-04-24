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
	
	public static ArrayList<Node> getChildren(Node parent) {
		ArrayList<Node> children = new ArrayList<Node>();
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
	
	public static Node getTxt(Node n){return null;}
	
	public static ArrayList<Node> getDescendant(Node subRoot){return getChildren(subRoot);}
	
	public static Node attrib(Node n, String attName){return n;} //unsure about the return type
			
	public static ArrayList<Node> unique(ArrayList<Node> list){return list;}
	
	public static ArrayList<Node> concatenate(ArrayList<Node> listA, ArrayList<Node> listB){return null;}
	
	public static boolean filterEq(ArrayList<Node> listA, ArrayList<Node> listB){return true;}

	public static boolean filterIs(ArrayList<Node> listA, ArrayList<Node> listB){return true;}
	
}
