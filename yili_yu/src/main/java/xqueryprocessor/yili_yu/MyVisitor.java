package xqueryprocessor.yili_yu;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import xml.*;
import xqueryprocessor.yili_yu.XQueryParser.CondValEqualContext;

public class MyVisitor extends XQueryBaseVisitor<ArrayList<Node>> {

	ParseTreeProperty<ArrayList<Node>> values = new ParseTreeProperty<>(); // Return
																			// values,
																			// [ACT1,ACT2,ACT3...]
	ArrayList<XMLTree> domList = new ArrayList<>();
	HashMap<String, Node> context = new HashMap<>(); // Binding variables,
														// ["a":ACT1,"b":SPEAKER2...]
	private XMLTree curXMLTree = null;
	private Document inDoc = null;
	private Document outDoc = null;// makeElement(outDoc)

	@Override
	public ArrayList<Node> visitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) {
		//System.out.println("visitCondValEqual " + ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));
		
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (valEqual(left, right)){
			System.out.println("equal reach------------");
			result.add(null);
		}
		return result;
	}

	@Override public ArrayList<Node> visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) { 
		System.out.println("visitWhereClause ");
		
		ArrayList<Node> result = visit(ctx.getChild(1));
		if (result.size()>0){
			ParseTree parent = ctx.getParent();
			visit(parent.getChild(parent.getChildCount()-1));
		}
		return null;//return visitChildren(ctx); 
	}

	@Override
	public ArrayList<Node> visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) {
		System.out.println("visitXqParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override public ArrayList<Node> visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) { 
		System.out.println("visitXqFLWR");
		
		ParseTree res = ctx.getChild(ctx.getChildCount()-1);
		values.put(res, new ArrayList<Node>());
		
		visit(ctx.getChild(0));
		
		ArrayList<Node> result = values.get(res);
		values.removeFrom(res);
		System.out.println("888888888888888888"+result.get(0).toString());
		
		return result;
	}

	@Override
	public ArrayList<Node> visitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) {
		System.out.println("visitRpDotDot " + ctx.getText());

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
		System.out.println("visitFRp " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);

		return visit(ctx.getChild(0));
	}

	@Override
	public ArrayList<Node> visitXqSlash(@NotNull XQueryParser.XqSlashContext ctx) {
		//System.out.println("visitXqSlash" + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slash_list = slashHelper(xq_list);
		values.put(ctx.getChild(2), slash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}


	@Override public ArrayList<Node> visitVarBind(@NotNull XQueryParser.VarBindContext ctx) { 
		System.out.println("visitVarBind");
		
		ArrayList<Node> result = visit(ctx.getChild(2));
		
		String key = ctx.getChild(0).getText();
		System.out.println("Variable binding: "+key);
		
		ParseTree parent = ctx.getParent();
		int childCount = parent.getChildCount();
		int idx = whichChild(parent, ctx);
		
		for (Node i : result){
			System.out.println("binding "+i.getFirstChild().getTextContent()+"==============");
			context.put(key, i);
			//System.out.println("============="+i.getTextContent()+"==============");
			if (childCount>idx+2){ //check whether the next varBind exist
				visit(parent.getChild(idx+2));
			}
			else{
				bindHelper(ctx);
			}
			context.remove(key);
		} 
		return null;
	}
	
	private int whichChild(ParseTree parent, ParseTree child){
		int childCount = parent.getChildCount();
		for (int i=0;i<childCount;i++){
			if (parent.getChild(i).equals(child))
				return i;
		}
		return -1;
	}

	@Override
	public ArrayList<Node> visitApSlash(@NotNull XQueryParser.ApSlashContext ctx) {
		System.out.println("visitApSlash " + ctx.getText());

		String nameStr = ctx.getChild(2).getText();
		String fileName = nameStr.substring(1, nameStr.length() - 1);
		curXMLTree = null;

		for (XMLTree i : domList) {
			if (i.getFileName().equals(fileName)) {
				curXMLTree = i;
				break;
			}
		}
		if (curXMLTree == null) {
			System.out.println("Create new XMLTree");
			curXMLTree = new XMLTree(fileName);
			XMLTree outXMLTree = new XMLTree();
			outDoc = outXMLTree.getDoc();
			domList.add(curXMLTree);
		}

		ArrayList<Node> root = new ArrayList<>();
		inDoc = curXMLTree.getDoc();
		root.add(XMLTreefunction.getRoot(inDoc));

		if (ctx.slash.getText().equals("/")) {
			values.put(ctx.getChild(5), slashHelper(root));
		} else if (ctx.slash.getText().equals("//")) {
			values.put(ctx.getChild(5), slashSlashHelper(root));
		}
		ArrayList<Node> res = slashSlashHelper(root);
		System.out.println("*************"+res.size());
		return visit(ctx.getChild(5));
	}
	public void printResult(ArrayList<Node> inputList) throws TransformerException{
		outDoc.appendChild(inputList.get(0));
		 // Use a Transformer for output
	    TransformerFactory tFactory =
	    TransformerFactory.newInstance();
	    Transformer transformer = 
	    tFactory.newTransformer();

	    DOMSource source = new DOMSource(outDoc);
	    File file = new File("output1.xml");
	    StreamResult result = new StreamResult(file);
	    transformer.transform(source, result);
	}

	@Override
	public ArrayList<Node> visitRpDot(@NotNull XQueryParser.RpDotContext ctx) {
		System.out.println("visitRpDot " + ctx.getText());

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
		//System.out.println("visitRpText: " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		//System.out.println("sub size"+ sub.size());
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub) {
			//System.out.println("visitRpText func: "+XMLTreefunction.getTxt(i));
			if(XMLTreefunction.getTxt(i).getNodeType() == Node.TEXT_NODE)
				result.add(XMLTreefunction.getTxt(i));
		} // optimize: result=sub

		return result;
	}

	@Override
	public ArrayList<Node> visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) {
		System.out.println("visitXqTagName " + ctx.getText());
		String tagName = ctx.getChild(1).getText();
		ArrayList<Node> xq_children_list = visit(ctx.getChild(4));
		System.out.println("child's size"+xq_children_list.get(0).toString());
		Node node = XMLTreefunction.makeElement(tagName, xq_children_list, outDoc);
		System.out.println("node "+node.toString());
		ArrayList<Node> ret_list = new ArrayList<Node>();
		ret_list.add(node);
		return ret_list;
	}


	@Override public ArrayList<Node> visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) { 
		System.out.println("visitLetClause");
		
		visit(ctx.getChild(1));
		return null;
	}

	@Override
	public ArrayList<Node> visitRpConcat(@NotNull XQueryParser.RpConcatContext ctx) {
		System.out.println("visitRpConcat " + ctx.getText());

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
		System.out.println("visitFIdEqual" + ctx.getText());
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
		System.out.println("visitRpAttr " + ctx.getText());

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
		System.out.println("visitCondEmpty" + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(1));
		ArrayList<Node> result = new ArrayList<Node>();
		if (xq_list.size()==0)
			result.add(null);
		return result;
	}

	
	@Override public ArrayList<Node> visitXqVar(@NotNull XQueryParser.XqVarContext ctx) { 
		Node inode = context.get(ctx.getText());
		ArrayList<Node> singletonList = new ArrayList<>();
		singletonList.add(inode);
		return singletonList;

	}

	@Override
	public ArrayList<Node> visitFNot(@NotNull XQueryParser.FNotContext ctx) {
		System.out.println("visitFNot " + ctx.getText());

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


	@Override public ArrayList<Node> visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) { 
		System.out.println("visitCondSomeSatis");
		
		values.put(ctx, new ArrayList<Node>());
		visit(ctx.getChild(0));
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		
		return result; 
	}

	@Override
	public ArrayList<Node> visitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) {
		System.out.println("visitCondIdEqual"+ ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (idEqual(left, right))
			result.add(null);
		return result;

	}

	@Override
	public ArrayList<Node> visitFParen(@NotNull XQueryParser.FParenContext ctx) {
		System.out.println("visitFParen " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);

		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitFOr(@NotNull XQueryParser.FOrContext ctx) {
		System.out.println("visitFOr " + ctx.getText());

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
		System.out.println("visitFValEqual " + ctx.getText());
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
		System.out.println("visitRpWildcard " + ctx.getText());
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		return result;
	}

	@Override public ArrayList<Node> visitXqLet(@NotNull XQueryParser.XqLetContext ctx) { 
		System.out.println("visitXqLet");
		
		values.put(ctx, new ArrayList<Node>());
		visit(ctx.getChild(0));
		
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		return result; 
	}

	@Override
	public ArrayList<Node> visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) {
		//System.out.println("visitXqStringConstant " + ctx.getText());
		String text = ctx.getText();
		//System.out.println("StringConstant "+text);
		text = text.substring(1, text.length()-1);
		//System.out.println("StringConstant "+text);
		Node text_node = XMLTreefunction.makeText(text, inDoc);
		ArrayList<Node> textNode = new ArrayList<Node>();
		textNode.add(text_node);
		return textNode;
	}

	@Override
	public ArrayList<Node> visitXqAp(@NotNull XQueryParser.XqApContext ctx) {
		System.out.println("visitXqAp " + ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) {
		System.out.println("visitReturnClause"+ values.get(ctx).size());
		if(values.get(ctx).size()==0){
			System.out.println("lala");
			ArrayList<Node> new_list = visit(ctx.getChild(1));
			System.out.println("list"+new_list.size());
			for(Node n: new_list){
				System.out.println("old rtn: "+n.toString());
			}
			values.put(ctx, new_list);
			return null;
		}
		ArrayList<Node> old_list = values.get(ctx);
		for(Node n: old_list){
			System.out.println("old rtn: "+n.toString());
		}
		ArrayList<Node> append_list = visit(ctx.getChild(1));
		ArrayList<Node> new_list = new ArrayList<Node>(old_list);
		new_list.addAll(append_list);
		values.removeFrom(ctx);
		values.put(ctx, new_list);
		return null;
	}

	@Override
	public ArrayList<Node> visitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) {
		System.out.println("visitCondParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) {
		//System.out.println("visitRpSlash " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);

		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		if (ctx.slash.getText().equals("/")) {
			ArrayList<Node> list =  slashHelper(left);
			System.out.println(list.size());
			values.put(ctx.getChild(2), slashHelper(left));
		} else if (ctx.slash.getText().equals("//")) {
			values.put(ctx.getChild(2), slashSlashHelper(left));
		}

		return visit(ctx.getChild(2));
	}

	@Override
	public ArrayList<Node> visitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) {
		System.out.println("visitXqSlashSlash " + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slashslash_list = slashSlashHelper(xq_list);
		values.put(ctx.getChild(2), slashslash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}

	@Override public ArrayList<Node> visitForClause(@NotNull XQueryParser.ForClauseContext ctx) { 
		System.out.println("visitForClause");
		
		visit(ctx.getChild(1));
		return null;
	}

	private void bindHelper(ParseTree tree){
		ParseTree parent = tree.getParent();
		String flag = parent.getChild(0).getText();
		ParseTree grand = parent.getParent();
		if (flag.equals("some")){
			ArrayList<Node> result = visit(grand.getChild(2));
			if (result.size()>0){
				values.put(grand, result);
			}
		}
		else if ((flag.equals("let")) && (grand.getChildCount()==2)){
			ArrayList<Node> sub = visit(grand.getChild(1));
			ArrayList<Node> result = values.get(grand);
			result.addAll(sub);
			values.put(grand, result);
		}
		else{
			int idx = whichChild(grand, parent);
			visit(grand.getChild(idx+1));
		}
	}

	@Override
	public ArrayList<Node> visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) {
		//System.out.println("visitRpTagName " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		String tagName = ctx.getText();
		for (Node i : sub) {
		
			if (XMLTreefunction.getTag(i).equals(tagName)) {
				//System.out.println("visitRpTagName fuc:" + i.getNodeName());
				result.add(i);
			}
		}
		System.out.println(result.size());
		return result;
	}

	@Override
	public ArrayList<Node> visitCondAnd(@NotNull XQueryParser.CondAndContext ctx) {
		System.out.println("visitCondAnd " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		if (left.size() == 0)
			return left;
		else if(right.size()==0)
			return right;
		else 
			return left;// left size==0: indicating false
	}

	@Override
	public ArrayList<Node> visitRpFilter(@NotNull XQueryParser.RpFilterContext ctx) {
		System.out.println("visitRpFilter " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> temp = visit(ctx.getChild(0));

		ArrayList<Node> result = new ArrayList<>();
		ArrayList<Node> single = new ArrayList<>();
		for (Node i : temp) {
			single.add(i);
			values.put(ctx.getChild(2), single);
			ArrayList<Node> filter = visit(ctx.getChild(2));
			if (filter.size() > 0) {// filter size==0:false;filter size>0: true
				result.add(i);
			}
			single.remove(0);
		}

		return result;
	}

	@Override
	public ArrayList<Node> visitXqConcat(@NotNull XQueryParser.XqConcatContext ctx) {
		System.out.println("visitXqConcat"+ctx.getText());		
		ArrayList<Node> result = visit(ctx.getChild(0));
		for(Node n: result){
			System.out.println("concat1 "+n.toString());
		}
		result.addAll(visit(ctx.getChild(2)));
		return result;
	}

	@Override
	public ArrayList<Node> visitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) {
		System.out.println("visitRpParenExpr " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitCondNot(@NotNull XQueryParser.CondNotContext ctx) {
		System.out.println("visitCondNot"+ctx.getText());
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
		System.out.println("visitFAnd " + ctx.getText());
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

	@Override public ArrayList<Node> visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx) { 
		System.out.println("visitSomeClause");
		
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
			//System.out.println("l is"+l.getTextContent());
			for (Node r : right) {
				//System.out.println("r is"+r.getTextContent());
				if (l.isEqualNode(r)) {
					System.out.println("l is"+l.getTextContent());
					System.out.println("r is"+r.getTextContent());
					System.out.println("true");
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
