package xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTreefunction {

	public static Node getRoot(Document doc) {
		return (Node) doc.getDocumentElement();
	}

	public static ArrayList<Node> getChildren(Node parent) {
		ArrayList<Node> children = new ArrayList<Node>();
		Node childNode = parent.getFirstChild();
		for (; childNode != null;) {
			if (childNode.getNodeType() == Node.ELEMENT_NODE)
				children.add(childNode);
			childNode = childNode.getNextSibling();
			;
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

	public static Node getTxt(Node n) {
		if(n.getNodeType() == Node.TEXT_NODE)
			return n;
		return null;
	}

	public static Node makeText(String str, Document doc) {	
		return doc.createTextNode(str);
	}

	public static Node makeElement(String name, ArrayList<Node> nodeList, Document outDoc) {
		Node element_node = outDoc.createElement(name);
		for (Node n : nodeList) {
			if (n != null && n.getNodeType() != Node.DOCUMENT_NODE) {
				boolean deep = true;
				Node child = outDoc.importNode(n, deep);
				element_node.appendChild(child);
			}
		}
		return element_node;
	}
	public static ArrayList<Node> getDescendant(Node subRoot) {
		List<Node> descendants = new ArrayList<Node>();
		Queue<Node> level = new LinkedList<Node>();
		level.offer(subRoot);
		while (!level.isEmpty()) {
			Node curr = level.poll();
			descendants.add(curr);
			NodeList next_generation = curr.getChildNodes();
			if (next_generation != null) {
				for (int i = 0; i < next_generation.getLength(); i++) {
					level.offer(next_generation.item(i));
				}
			}
		}
		return (ArrayList<Node>) descendants;

	}

	public static Node attrib(Node n, String attName) {
		if ((n.getNodeType() == Node.ATTRIBUTE_NODE) && (n.getNodeValue().equals(attName))) {
			return n;
		}
		return null;
	} // unsure about the return type

	public static ArrayList<Node> unique(ArrayList<Node> list) {
		return list;
	}

	public static ArrayList<Node> concatenate(ArrayList<Node> listA, ArrayList<Node> listB) {
		return null;
	}

	public static boolean filterEq(ArrayList<Node> listA, ArrayList<Node> listB) {
		return true;
	}

	public static boolean filterIs(ArrayList<Node> listA, ArrayList<Node> listB) {
		return true;
	}

}
