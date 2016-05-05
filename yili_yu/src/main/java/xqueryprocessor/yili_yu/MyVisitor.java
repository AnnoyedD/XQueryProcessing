package xqueryprocessor.yili_yu;

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
		System.out.println("visitCondValEqual " + ctx.getText());
		ArrayList<Node> left = visit(ctx.getChild(0));
		ArrayList<Node> right = visit(ctx.getChild(2));
		ArrayList<Node> result = new ArrayList<Node>();
		if (valEqual(left, right))
			result.add(null);
		return result;
	}

	@Override
	public ArrayList<Node> visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) {
		// todo
		System.out.println("visitWhereClause" + ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) {
		System.out.println("visitXqParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) {
		System.out.println("visitXqFLWR" + ctx.getText());

		return visit(ctx.getChild(0));
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
		System.out.println("visitXqSlash" + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slash_list = slashHelper(xq_list);
		values.put(ctx.getChild(2), slash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}

	@Override
	public ArrayList<Node> visitVarBind(@NotNull XQueryParser.VarBindContext ctx) {
		System.out.println("visitVarBind" + ctx.getText());
		return visitChildren(ctx);
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

		return visit(ctx.getChild(5));
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
		System.out.println("visitRpText: " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub) {
			result.add(XMLTreefunction.getTxt(i));
		} // optimize: result=sub

		return result;
	}

	@Override
	public ArrayList<Node> visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) {
		//todo
		System.out.println("visitXqTagName" + ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) {
		//todo
		return visitChildren(ctx);
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
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitXqVar(@NotNull XQueryParser.XqVarContext ctx) {
		System.out.println("visitXqVar" + ctx.getText());
		Node inode = context.get(ctx.getText());
		ArrayList<Node> singletonList = (ArrayList<Node>) Collections.singletonList(inode);
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

	@Override
	public ArrayList<Node> visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) {
		System.out.println("visitCondSomeSatis " + ctx.getText());
		return visitChildren(ctx);
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

	@Override
	public ArrayList<Node> visitXqLet(@NotNull XQueryParser.XqLetContext ctx) {
		System.out.println("visitXqLet " + ctx.getText());
		return visitChildren(ctx);
	}

	@Override
	public ArrayList<Node> visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) {
		System.out.println("visitXqStringConstant " + ctx.getText());
		Node text_node = XMLTreefunction.makeText(ctx.getText(), inDoc);
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
		System.out.println("visitReturnClause" + ctx.getText());
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
		System.out.println("visitCondParenExpr" + ctx.getText());
		return visit(ctx.getChild(1));
	}

	@Override
	public ArrayList<Node> visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) {
		System.out.println("visitRpSlash " + ctx.getText());

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
		System.out.println("visitXqSlashSlash " + ctx.getText());
		ArrayList<Node> xq_list = visit(ctx.getChild(0));
		ArrayList<Node> slashslash_list = slashSlashHelper(xq_list);
		values.put(ctx.getChild(2), slashslash_list);
		ArrayList<Node> rp_list = visit(ctx.getChild(2));
		return rp_list;
	}

	@Override
	public ArrayList<Node> visitForClause(@NotNull XQueryParser.ForClauseContext ctx) {
		System.out.println("visitForClause" + ctx.getText());

		bindHelper(ctx.getChild(1), 3);// 3 indicates the index of the next
										// brother
		return visitChildren(ctx);
	}

	private void bindHelper(ParseTree tree, int idx) {
		String key = tree.getChild(0).getText();
		System.out.println("============" + key + "===============");

		ArrayList<Node> sub = values.get(tree);
		for (Node i : sub) {
			context.put(key, i);

			if (tree.getParent().getChildCount() > idx) { // check whether the
															// next varBind
															// exist
				bindHelper(tree.getParent().getChild(idx), idx + 2);
			} else {
				int count = tree.getParent().getChildCount();

				// manulWalk(tree.getParent().getParent().getChild(1)); //If no
				// more varBind, traverse letClause|whereClause|returnClause
			}

			context.remove(key);
		}
	}

	@Override
	public ArrayList<Node> visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) {
		System.out.println("visitRpTagName " + ctx.getText());

		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		String tagName = ctx.getText();
		for (Node i : sub) {
			if (XMLTreefunction.getTag(i).equals(tagName)) {
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
