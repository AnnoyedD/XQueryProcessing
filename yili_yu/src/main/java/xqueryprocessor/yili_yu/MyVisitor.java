package xqueryprocessor.yili_yu;

import java.util.*;
import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import xml.*;

public class MyVisitor extends XQueryBaseVisitor<ArrayList<Node>> {

	ParseTreeProperty<ArrayList<Node>> values = new ParseTreeProperty<>(); // Return
																			// values,
																			// [ACT1,ACT2,ACT3...]
	HashMap<String, Node> context = new HashMap<>(); // Binding variables,
														// ["a":ACT1,"b":SPEAKER2...]
	HashMap<String, ArrayList<Node>> context_let = new HashMap<>();
	HashMap<String, ArrayList<Node>> context_temp = new HashMap<>();

	private XMLTree inXMLTree = null;
	private Document inDoc = null;
	private XMLTree outXMLTree = null;
	private Document outDoc = null;

	@Override
	public ArrayList<Node> visitXqJoin(@NotNull XQueryParser.XqJoinContext ctx) {
		 System.out.println("visitXqJoin " + ctx.getText());
		// System.out.println(ctx.getChild(1).getText());
		ArrayList<Node> res =  visit(ctx.getChild(1));
		 System.out.println("return visitXqJoin ");
		for(Node r: res){
			print(XMLTreefunction.getChildren(r), "v");
		}
		return res;
	}

	private HashMap<Integer, List<Node>> getHashMap(ArrayList<Node> leftTuples, ArrayList<Integer> left_attr_index) {
		HashMap<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		for (Node tuple : leftTuples) {
			// combine all key attributes together into key

			String lkey = "";
			ArrayList<Node> children = XMLTreefunction.getChildren(tuple);
			for (int attr : left_attr_index) {
				// System.out.println(attr+" attr");
				Node attrNode = children.get(attr);
				//text content of attrNode
				String tmp = attrNode.getTextContent();
				//children of attrNode
				for(Node c: XMLTreefunction.getChildren(attrNode)){
					tmp+=c.getNodeName();
				}
				lkey += tmp;
			}

			int key = lkey.hashCode();
			// System.out.println("lkey "+lkey);

			if (map.containsKey(key)) {

				map.get(key).add(tuple);
				// System.out.println("lkey "+lkey+" num "+map.get(key).size());
			} else {
				List<Node> value = new ArrayList<Node>();
				value.add(tuple);
				map.put(key, value);
			}
		}
		return map;
	}

	private ArrayList<Integer> getAttributesIndex(ArrayList<Node> left_attributes, Node tuple) {
		//System.out.println("getAttributesIndex ");
		ArrayList<Integer> left_index = new ArrayList<Integer>();
		ArrayList<Node> sampleChildren = XMLTreefunction.getChildren(tuple);
		// System.out.println("sampleChildren.size() "+sampleChildren.size());
		for (int i = 0; i < left_attributes.size(); i++) {
			String left_att = left_attributes.get(i).getTextContent();
			for (int c = 0; c < sampleChildren.size(); c++) {
				// System.out.println("getAttributesIndex
				// "+sampleChildren.get(c).getNodeName()+" "+left_att);
				if (sampleChildren.get(c).getNodeName().equals(left_att)) {
					left_index.add(c);
					break;
				}
			}
		}
		// for(int i: left_index){
		// System.out.print("index "+i);
		// }
		// System.out.println();
		return left_index;
	}

	private void print(ArrayList<Node> list, String name) {
		if (list == null) {
			System.out.println(name + " list is null");
			return;
		}
		if (list.size() == 0)
			System.out.println(name + " list is empty");
		System.out.print(name);
		for (Node n : list) {
			System.out.print(" nodeName:" + n.getNodeName()+" ");
		}
		System.out.println();
	}

	@Override
	public ArrayList<Node> visitXqImpJoin(@NotNull XQueryParser.XqImpJoinContext ctx) {
		System.out.println("visitXqImpJoin " + ctx.getText());
		ArrayList<Node> result = new ArrayList<Node>();

		ArrayList<Node> leftTuples = visit(ctx.getChild(0));
		// System.out.print("leftTuples ");
		// print(XMLTreefunction.getChildren(leftTuples.get(0)), "leftTuples");
		// print(leftTuples, "leftTuples");
		ArrayList<Node> rightTuples = visit(ctx.getChild(2));
		// print(rightTuples, "rightTuples");
		ArrayList<Node> left_attributes = visit(ctx.getChild(5));
		//print(left_attributes, "left_attributes");
		ArrayList<Node> right_attributes = visit(ctx.getChild(9));
		// print(right_attributes, "right_attributes");
		if (left_attributes.size() != right_attributes.size()) {
			System.out.println("error in indexes for join");
			System.exit(-1);
		}

		// index of each attr's position in children of a sample tuple

		ArrayList<Integer> left_index = getAttributesIndex(left_attributes, leftTuples.get(0));
		ArrayList<Integer> right_index = getAttributesIndex(right_attributes, rightTuples.get(0));

		// key is the combinations of all minor keys
		HashMap<Integer, List<Node>> leftMap = getHashMap(leftTuples, left_index);

		for (int rNode = 0; rNode < rightTuples.size(); rNode++) {
			Node rTuple = rightTuples.get(rNode);
			// combine all key attributes together into rkey

			String key = "";
			ArrayList<Node> children = XMLTreefunction.getChildren(rTuple);
			for (int attr : right_index) {
				Node attrNode = children.get(attr);
				//text content of attrNode
				String tmp = attrNode.getTextContent();
				//children of attrNode
				for(Node c: XMLTreefunction.getChildren(attrNode)){
					tmp+=c.getNodeName();
				}
				key += tmp;
			}

		
			int rkey = key.hashCode();
			// System.out.println("rkey "+key);

			if (leftMap.containsKey(rkey)) {
				// System.out.println("left map contains key");
				// System.out.println("contains rkey "+rkey);
				List<Node> values = leftMap.get(rkey);
				// join each n in values with rTuple;
				// add their children together
				// make a new element
				/// System.out.println("values's size "+values.size());
				for (Node n : values) {

					boolean flag = false;
					ArrayList<Node> l_children = XMLTreefunction.getChildren(n);
					ArrayList<Node> r_children = XMLTreefunction.getChildren(rTuple);

					int count = 0;
					for (int attri = 0; attri < left_index.size(); attri++) {
						Node l_child = l_children.get(left_index.get(attri));
						Node r_child = r_children.get(right_index.get(attri));
						Node tmp_left = XMLTreefunction.makeElement(r_child.getNodeName(),
								XMLTreefunction.getChildren(l_child), outDoc);

						if (tmp_left.isEqualNode(r_child)) {
							count++;
						}
						// System.out.println();
					}

					if (count == left_index.size())
						flag = true;
					if (flag == true) {

						ArrayList<Node> new_children = new ArrayList<Node>();
						new_children.addAll(l_children);
						new_children.addAll(r_children);
						Node newTuple = XMLTreefunction.makeElement("tuple", new_children, outDoc);
						result.add(newTuple);
					}
				}
			}
		}
		// print(result, "result");
		for (Node r : result) {
			Node first = r.getFirstChild().getNextSibling();
			Node second = first.getNextSibling().getNextSibling();
			System.out.println("Impjoin result "+first.getNodeName() + " " + first.getTextContent() + " " + second.getNodeName() + " "
					+ second.getTextContent());
		}
		System.out.println("result " + result.size());
		
		return result;
	}

	@Override
	public ArrayList<Node> visitIndexing(@NotNull XQueryParser.IndexingContext ctx) {
		// return visitChildren(ctx);
		System.out.println(" Indexing");
		ArrayList<Node> result = new ArrayList<Node>();
		List<String> items = Arrays.asList(ctx.getText().split("\\s*,\\s*"));
		for (String s : items) {
			System.out.println(s);
			Node n = XMLTreefunction.makeText(s, inDoc);
			result.add(n);

		}
		return result;
	}

	public void generateResult(ArrayList<Node> result) {
		System.out.println("generate result " + result.size());
		outDoc.appendChild(result.get(0));
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the file name for result: ");
			String resFile = scanner.nextLine();

			// Use a Transformer for output
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();

			DOMSource source = new DOMSource(outDoc);
			StreamResult res = new StreamResult(resFile);
			transformer.transform(source, res);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Override
	public ArrayList<Node> visitLetVarBind(@NotNull XQueryParser.LetVarBindContext ctx) {
		// System.out.println("visitLetVarBind");
		ArrayList<Node> result = visit(ctx.getChild(2));
		String key = ctx.getChild(0).getText();
		context_let.put(key, result);
		return null;
	}

	@Override
	public ArrayList<Node> visitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) {
		// System.out.println("visitCondValEqual " + ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));

		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (valEqual(left, right)) {
			result.add(null);
		}
		return result;
	}

	@Override
	public ArrayList<Node> visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) {
		// System.out.println("visitWhereClause"+ctx.getText());
		// context_temp.clear();
		ArrayList<String> where_keys = new ArrayList<>();
		for (String k : context_let.keySet()) {
			if (ctx.getText().contains(k + "/") || ctx.getText().contains(k + " ")) {
				where_keys.add(k);
				context_temp.put(k, new ArrayList<Node>());
			}
		}

		boolean flag = whereHelper(where_keys, 0, ctx);

		for (String k : where_keys) {
			context_let.remove(k);
			context_let.put(k, XMLTreefunction.unique(context_temp.get(k)));
		}

		if (flag) {
			ParseTree parent = ctx.getParent();
			visit(parent.getChild(parent.getChildCount() - 1));
		}
		return null;// return visitChildren(ctx);
	}

	private boolean whereHelper(ArrayList<String> keyVal, int i, XQueryParser.WhereClauseContext ctx) {
		boolean flag = false;
		if (i < keyVal.size()) {
			String key = keyVal.get(i);
			ArrayList<Node> nodes = context_let.get(key);
			for (Node n : nodes) {
				context.put(key, n);
				if (whereHelper(keyVal, i + 1, ctx))
					flag = true;
				context.remove(key);
			}
		} else {
			ArrayList<Node> result = visit(ctx.getChild(1));
			if (result.size() > 0) {
				flag = true;
				ArrayList<Node> res;
				for (String k : keyVal) {
					res = new ArrayList<Node>(context_temp.get(k));
					res.add(context.get(k));
					context_temp.put(k, res);
				}
				return true;
			}
			return false;
		}
		return flag;
	}

	@Override
	public ArrayList<Node> visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) {
		// System.out.println("visitXqParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) {
		System.out.println("visitXqFLWR");

		ParseTree res = ctx.getChild(ctx.getChildCount() - 1);
		values.put(res, new ArrayList<Node>());

		visit(ctx.getChild(0));

		ArrayList<Node> result = values.get(res);
		values.removeFrom(res);
		if (result.size() == 0)
			System.out.println("visitXqFLWR is empty");
		return result;
	}

	@Override
	public ArrayList<Node> visitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) {
		// System.out.println("visitRpDotDot " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub) {
			result.add(XMLTreefunction.getParent(XMLTreefunction.getParent(i)));
		}
		XMLTreefunction.unique(result);

		return result;
	}

	@Override
	public ArrayList<Node> visitFRp(@NotNull XQueryParser.FRpContext ctx) {
		// System.out.println("visitFRp " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);

		return visit(ctx.getChild(0));
	}

	@Override
	public ArrayList<Node> visitXqSlash(@NotNull XQueryParser.XqSlashContext ctx) {
		// System.out.println("visitXqSlash " + ctx.getText());

		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slash_list = slashHelper(xq_list);
		values.put(ctx.getChild(2), slash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}

	@Override
	public ArrayList<Node> visitVarBind(@NotNull XQueryParser.VarBindContext ctx) {
		// System.out.println("visitVarBind");

		ArrayList<Node> result = visit(ctx.getChild(2));

		String key = ctx.getChild(0).getText();
		// System.out.println("Variable binding: "+key);

		ParseTree parent = ctx.getParent();
		int childCount = parent.getChildCount();
		int idx = whichChild(parent, ctx);

		for (Node i : result) {
			context.put(key, i);
			if (childCount > idx + 2) { // check whether the next varBind exist
				visit(parent.getChild(idx + 2));
			} else {
				bindHelper(ctx);
			}
			context.remove(key);
		}
		return null;
	}

	private int whichChild(ParseTree parent, ParseTree child) {
		int childCount = parent.getChildCount();
		for (int i = 0; i < childCount; i++) {
			if (parent.getChild(i).equals(child))
				return i;
		}
		return -1;
	}

	@Override
	public ArrayList<Node> visitApSlash(@NotNull XQueryParser.ApSlashContext ctx) {
		// System.out.println("visitApSlash " + ctx.getText());

		String nameStr = ctx.getChild(2).getText();
		String fileName = nameStr.substring(1, nameStr.length() - 1);

		if (inXMLTree == null) {
			// System.out.println("Create new XMLTree");
			inXMLTree = new XMLTree(fileName);
			inDoc = inXMLTree.getDoc();

			outXMLTree = new XMLTree();
			outDoc = outXMLTree.getDoc();
			// System.out.println("Create result xml/doc: "+outDoc);
		}

		ArrayList<Node> root = new ArrayList<>();
		root.add(XMLTreefunction.getRoot(inDoc));

		if (ctx.slash.getText().equals("/")) {
			values.put(ctx.getChild(5), slashHelper(root));
		} else if (ctx.slash.getText().equals("//")) {
			values.put(ctx.getChild(5), slashSlashHelper(root));
		}

		return visit(ctx.getChild(5));
	}

	@Override
	public ArrayList<Node> visitRpDot(@NotNull XQueryParser.RpDotContext ctx) {
		// System.out.println("visitRpDot " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub) {
			result.add(XMLTreefunction.getParent(i));
		}
		XMLTreefunction.unique(result);

		return result;
	}

	@Override
	public ArrayList<Node> visitRpText(@NotNull XQueryParser.RpTextContext ctx) {
		// System.out.println("visitRpText");

		ArrayList<Node> sub = values.get(ctx);

		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub) {
			Node txt = XMLTreefunction.getTxt(i);
			if (txt != null) {
				result.add(txt);
			}
		} // optimize: result=sub

		return result;
	}

	@Override
	public ArrayList<Node> visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) {
		// System.out.println("visitXqTagName " + ctx.getText());
		String tagName = ctx.getChild(1).getText();
		ArrayList<Node> xq_children_list = visit(ctx.getChild(4));
		Node node = XMLTreefunction.makeElement(tagName, xq_children_list, outDoc);
		ArrayList<Node> ret_list = new ArrayList<Node>();
		ret_list.add(node);
		return ret_list;
	}

	@Override
	public ArrayList<Node> visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) {
		// System.out.println("visitLetClause");
		int count = ctx.getChildCount();
		for (int i = 1; i < count; i += 2) {
			visit(ctx.getChild(i));
		}
		bindHelper(ctx.getChild(count - 1));
		return null;
	}

	@Override
	public ArrayList<Node> visitRpConcat(@NotNull XQueryParser.RpConcatContext ctx) {
		// System.out.println("visitRpConcat " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> result = visit(ctx.getChild(0));
		result.addAll(visit(ctx.getChild(2)));

		return result;
	}

	@Override
	public ArrayList<Node> visitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx) {
		// return visitChildren(ctx);
		// System.out.println("visitFIdEqual" + ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (idEqual(left, right))
			result.add(null);
		return result;

	}

	@Override
	public ArrayList<Node> visitCondOr(@NotNull XQueryParser.CondOrContext ctx) {

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		if (left.size() > 0) {
			return left;
		}
		if (right.size() > 0) {
			return right;
		}
		return left; // left size==0: indicating false

	}

	@Override
	public ArrayList<Node> visitRpAttr(@NotNull XQueryParser.RpAttrContext ctx) {
		// System.out.println("visitRpAttr " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		String attName = ctx.getChild(1).getText();
		for (Node i : sub) {
			result.add(XMLTreefunction.attrib(i, attName));
		}

		return result;
	}

	@Override
	public ArrayList<Node> visitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx) {
		// System.out.println("visitCondEmpty" + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(1));
		ArrayList<Node> result = new ArrayList<Node>();
		if (xq_list.size() == 0)
			result.add(null);
		return result;
	}

	@Override
	public ArrayList<Node> visitXqVar(@NotNull XQueryParser.XqVarContext ctx) {

		if (context.containsKey(ctx.getText())) {
			Node inode = context.get(ctx.getText());
			ArrayList<Node> singletonList = new ArrayList<>();
			singletonList.add(inode);
			return singletonList;
		} else if (context_let.containsKey(ctx.getText())) {
			return context_let.get(ctx.getText());
		}
		return null;
	}

	@Override
	public ArrayList<Node> visitFNot(@NotNull XQueryParser.FNotContext ctx) {
		// System.out.println("visitFNot " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		ArrayList<Node> filter = visit(ctx.getChild(1));
		if (filter.size() > 0) {
			return new ArrayList<Node>();
		} else {
			filter.add(null);
			return filter;
		}
	}

	@Override
	public ArrayList<Node> visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) {
		// System.out.println("visitCondSomeSatis");

		values.put(ctx, new ArrayList<Node>());
		visit(ctx.getChild(0));
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);

		return result;
	}

	@Override
	public ArrayList<Node> visitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) {
		// System.out.println("visitCondIdEqual"+ ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (idEqual(left, right))
			result.add(null);
		return result;

	}

	@Override
	public ArrayList<Node> visitFParen(@NotNull XQueryParser.FParenContext ctx) {
		// System.out.println("visitFParen " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);

		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitFOr(@NotNull XQueryParser.FOrContext ctx) {
		// System.out.println("visitFOr " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		if (left.size() > 0) {
			return left;
		}
		if (right.size() > 0) {
			return right;
		}
		return left; // left size==0: indicating false
	}

	@Override
	public ArrayList<Node> visitFValEqual(@NotNull XQueryParser.FValEqualContext ctx) {
		// System.out.println("visitFValEqual " + ctx.getText());
		// return visitChildren(ctx);
		ArrayList<Node> left = visit(ctx.getChild(0));
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (valEqual(left, right))
			result.add(null);
		return result;
	}

	@Override
	public ArrayList<Node> visitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx) {
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		return result;
	}

	@Override
	public ArrayList<Node> visitXqLet(@NotNull XQueryParser.XqLetContext ctx) {
		// System.out.println("visitXqLet");

		values.put(ctx, new ArrayList<Node>());
		visit(ctx.getChild(0));

		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		return result;
	}

	@Override
	public ArrayList<Node> visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) {
		// System.out.println("visitXqStringConstant " + ctx.getText())
		String txt = ctx.getText();
		Node text_node = XMLTreefunction.makeText(txt.substring(1, txt.length() - 1), outDoc);
		ArrayList<Node> textNode = new ArrayList<Node>();
		textNode.add(text_node);
		return textNode;
	}

	@Override
	public ArrayList<Node> visitXqAp(@NotNull XQueryParser.XqApContext ctx) {
		// System.out.println("visitXqAp " + ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) {
		// System.out.println("visitReturnClause " + ctx.getText());
		ArrayList<Node> old_list = values.get(ctx);
		ArrayList<Node> append_list = visit(ctx.getChild(1));
		ArrayList<Node> new_list = new ArrayList<Node>(old_list);
		new_list.addAll(append_list);
		values.removeFrom(ctx);
		values.put(ctx, new_list);
		return null;
	}

	@Override
	public ArrayList<Node> visitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) {
		// System.out.println("visitCondParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) {
		// System.out.println("visitRpSlash " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);

		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		if (ctx.slash.getText().equals("/")) {
			values.put(ctx.getChild(2), slashHelper(left));
		} else if (ctx.slash.getText().equals("//")) {
			values.put(ctx.getChild(2), slashSlashHelper(left));
		}

		return visit(ctx.getChild(2));
	}

	@Override
	public ArrayList<Node> visitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) {
		// System.out.println("visitXqSlashSlash " + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slashslash_list = slashSlashHelper(xq_list);
		values.put(ctx.getChild(2), slashslash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}

	@Override
	public ArrayList<Node> visitForClause(@NotNull XQueryParser.ForClauseContext ctx) {
		// System.out.println("visitForClause");

		visit(ctx.getChild(1));
		return null;
	}

	private void bindHelper(ParseTree tree) {
		ParseTree parent = tree.getParent();
		String flag = parent.getChild(0).getText();
		ParseTree grand = parent.getParent();
		if (flag.equals("some")) {
			ArrayList<Node> result = visit(grand.getChild(2));
			if (result.size() > 0) {
				values.put(grand, result);
			}
		} else if ((flag.equals("let")) && (grand.getChildCount() == 2)) {
			ArrayList<Node> sub = visit(grand.getChild(1));
			ArrayList<Node> result = values.get(grand);
			result.addAll(sub);
			values.put(grand, result);
		} else {
			int idx = whichChild(grand, parent);
			visit(grand.getChild(idx + 1));
		}
	}

	@Override
	public ArrayList<Node> visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) {
		// System.out.println("visitRpTagName " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		String tagName = ctx.getText();
		for (Node i : sub) {
			if (XMLTreefunction.getTag(i).equals(tagName)) {
				result.add(i);
			}
		}

		return result;
	}

	@Override
	public ArrayList<Node> visitCondAnd(@NotNull XQueryParser.CondAndContext ctx) {
		// System.out.println("visitCondAnd " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		if (left.size() == 0)
			return left;
		else if (right.size() == 0)
			return right;
		else
			return left;// left size==0: indicating false
	}

	@Override
	public ArrayList<Node> visitRpFilter(@NotNull XQueryParser.RpFilterContext ctx) {
		// System.out.println("visitRpFilter " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> temp = visit(ctx.getChild(0));

		ArrayList<Node> result = new ArrayList<>();
		for (Node i : temp) {
			ArrayList<Node> children = new ArrayList<Node>();
			children.addAll(XMLTreefunction.getChildren(i));

			values.put(ctx.getChild(2), children);
			ArrayList<Node> filter = visit(ctx.getChild(2));
			if (filter.size() > 0) {// filter size==0:false;filter size>0: true
				result.add(i);
			}
		}

		return result;
	}

	@Override
	public ArrayList<Node> visitXqConcat(@NotNull XQueryParser.XqConcatContext ctx) {
		// System.out.println("visitXqConcat"+ctx.getText());
		ArrayList<Node> result = visit(ctx.getChild(0));
		result.addAll(visit(ctx.getChild(2)));
		return result;
	}

	@Override
	public ArrayList<Node> visitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) {
		// System.out.println("visitRpParenExpr " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitCondNot(@NotNull XQueryParser.CondNotContext ctx) {
		// System.out.println("visitCondNot"+ctx.getText());
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		ArrayList<Node> filter = visit(ctx.getChild(1));
		if (filter.size() > 0) {
			return new ArrayList<Node>();
		} else {
			filter.add(null);
			return filter;
		}
	}

	@Override
	public ArrayList<Node> visitFAnd(@NotNull XQueryParser.FAndContext ctx) {
		// System.out.println("visitFAnd " + ctx.getText());
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));

		if (left.size() == 0) {
			return left;
		}
		if (right.size() == 0) {
			return right;
		}
		return left;// left size >0: indicating true
	}

	@Override
	public ArrayList<Node> visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx) {
		// System.out.println("visitSomeClause");

		visit(ctx.getChild(1));
		return null;
	}

	private ArrayList<Node> slashHelper(ArrayList<Node> prec) {
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : prec) {
			result.addAll(XMLTreefunction.getChildren(i));
		}
		return XMLTreefunction.unique(result);
	}

	private ArrayList<Node> slashSlashHelper(ArrayList<Node> prec) {
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : prec) {
			result.addAll(XMLTreefunction.getDescendant(i));
		}
		return XMLTreefunction.unique(result);
	}

	private Boolean valEqual(ArrayList<Node> left, ArrayList<Node> right) {
		// return visitChildren(ctx);
		for (Node l : left) {
			for (Node r : right) {
				if (l.isEqualNode(r)) {
					return true;
				}
			}
		}
		return false;
	}

	private Boolean idEqual(ArrayList<Node> left, ArrayList<Node> right) {
		// return visitChildren(ctx);
		for (Node l : left) {
			for (Node r : right) {
				if (l.equals(r)) {
					return true;
				}
			}
		}
		return false;
	}
}
