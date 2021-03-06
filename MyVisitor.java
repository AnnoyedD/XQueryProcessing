package xqueryprocessor.yili_yu;

import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import xml.*;

public class MyVisitor extends XQueryBaseVisitor<ArrayList<Node>> {
	
	ParseTreeProperty<ArrayList<Node>> values = new ParseTreeProperty<>(); //Return values, [ACT1,ACT2,ACT3...]
	ArrayList<XMLTree> domList = new ArrayList<>();
	HashMap<String,Node> context = new HashMap<>(); //Binding variables, ["a":ACT1,"b":SPEAKER2...]
	
	@Override public ArrayList<Node> visitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override public ArrayList<Node> visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) { 
		System.out.println("visitXqFLWR");
		
		return visit(ctx.getChild(0)); 
	}

	@Override public ArrayList<Node> visitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) { 
		System.out.println("visitRpDotDot "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub){
			result.add(XMLTreefunction.getParent(XMLTreefunction.getParent(i)));
		}
		XMLTreefunction.unique(result);
		
		return result; 
	}

	@Override public ArrayList<Node> visitFRp(@NotNull XQueryParser.FRpContext ctx) { 
		System.out.println("visitFRp "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);

		return visit(ctx.getChild(0)); 
	}

	@Override public ArrayList<Node> visitXqSlash(@NotNull XQueryParser.XqSlashContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitVarBind(@NotNull XQueryParser.VarBindContext ctx) { 
		System.out.println("visitVarBind");
		return visitChildren(ctx); 
	}

	@Override public ArrayList<Node> visitApSlash(@NotNull XQueryParser.ApSlashContext ctx) { 
		System.out.println("visitApSlash "+ctx.getText());
		
		String nameStr = ctx.getChild(2).getText();
		String fileName = nameStr.substring(1, nameStr.length()-1);
		XMLTree curXMLTree = null;
		
		for (XMLTree i : domList){
			if (i.getFileName().equals(fileName)){
				curXMLTree = i;
				break;
			}
		}
		if (curXMLTree == null){
			System.out.println("Create new XMLTree");
			curXMLTree = new XMLTree(fileName);
			domList.add(curXMLTree);
		}
		
		ArrayList<Node> root = new ArrayList<>();
		root.add(XMLTreefunction.getRoot(curXMLTree.getDoc()));
		
		if (ctx.slash.getText().equals("/")){
			values.put(ctx.getChild(5), slashHelper(root));
		}
		else if(ctx.slash.getText().equals("//")){
			values.put(ctx.getChild(5), slashSlashHelper(root));
		}
		
		return visit(ctx.getChild(5)); 
	}

	@Override public ArrayList<Node> visitRpDot(@NotNull XQueryParser.RpDotContext ctx) { 
		System.out.println("visitRpDot "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub){
			result.add(XMLTreefunction.getParent(i));
		}
		XMLTreefunction.unique(result);
		
		return result; 
	}

	@Override public ArrayList<Node> visitRpText(@NotNull XQueryParser.RpTextContext ctx) { 
		System.out.println("visitRpText: " +ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : sub){
			result.add(XMLTreefunction.getTxt(i));
		}//optimize: result=sub
		
		return result; 
	}

	@Override public ArrayList<Node> visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpConcat(@NotNull XQueryParser.RpConcatContext ctx) { 
		System.out.println("visitRpConcat "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> result = visit(ctx.getChild(0));
		result.addAll(visit(ctx.getChild(2)));
		
		return result;
	}

	@Override public ArrayList<Node> visitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitCondOr(@NotNull XQueryParser.CondOrContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpAttr(@NotNull XQueryParser.RpAttrContext ctx) { 
		System.out.println("visitRpAttr "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();
		String attName = ctx.getChild(1).getText();
		for (Node i : sub){
			result.add(XMLTreefunction.attrib(i, attName));
		}
		
		return result; 
	}

	@Override public ArrayList<Node> visitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitXqVar(@NotNull XQueryParser.XqVarContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitFNot(@NotNull XQueryParser.FNotContext ctx) { 
		System.out.println("visitFNot "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		ArrayList<Node> filter = visit(ctx.getChild(1));
		if (filter.size()>0){
			return new ArrayList<Node>();
		}
		else{
			filter.add(null);
			return filter;
		}
	}

	@Override public ArrayList<Node> visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitFParen(@NotNull XQueryParser.FParenContext ctx) { 
		System.out.println("visitFParen "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		
		return visit(ctx.getChild(1)); 
	}

	@Override public ArrayList<Node> visitFOr(@NotNull XQueryParser.FOrContext ctx) { 
		System.out.println("visitFOr "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		if (left.size()>0){
			return left;
		}
		if (right.size()>0){
			return right;
		}
		return left; //left size==0: indicating false
	}

	@Override public ArrayList<Node> visitFValEqual(@NotNull XQueryParser.FValEqualContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx) { 
		System.out.println("visitRpWildcard "+ctx.getText());
		
		ArrayList<Node> result = values.get(ctx);
		values.removeFrom(ctx);
		return result;
	}

	@Override public ArrayList<Node> visitXqLet(@NotNull XQueryParser.XqLetContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitXqAp(@NotNull XQueryParser.XqApContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) { 
		System.out.println("visitReturnClause");
		return visitChildren(ctx); 
	}

	@Override public ArrayList<Node> visitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) { 
		System.out.println("visitRpSlash "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		if (ctx.slash.getText().equals("/")){
			values.put(ctx.getChild(2), slashHelper(left));
		}
		else if(ctx.slash.getText().equals("//")){
			values.put(ctx.getChild(2), slashSlashHelper(left));
		}
		
		return visit(ctx.getChild(2)); 
	}

	@Override public ArrayList<Node> visitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitForClause(@NotNull XQueryParser.ForClauseContext ctx) { 
		System.out.println("visitForClause");
		
		bindHelper(ctx.getChild(1),3);//3 indicates the index of the next brother
		return visitChildren(ctx); 
	}
	
	private void bindHelper(ParseTree tree, int idx){
		String key = tree.getChild(0).getText();
		System.out.println("============"+key+"===============");
		
		ArrayList<Node> sub = values.get(tree);
		for (Node i : sub){
			context.put(key, i);
			
			if (tree.getParent().getChildCount()>idx){ //check whether the next varBind exist
				bindHelper(tree.getParent().getChild(idx), idx+2);
			}
			else{
				int count = tree.getParent().getChildCount(); 
				
				manulWalk(tree.getParent().getParent().getChild(1)); //If no more varBind, traverse letClause|whereClause|returnClause
			}
			
			context.remove(key);
		}
	}

	@Override public ArrayList<Node> visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) { 
		System.out.println("visitRpTagName "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		ArrayList<Node> result = new ArrayList<>();  
		String tagName = ctx.getText();
		for (Node i : sub){
			if (XMLTreefunction.getTag(i).equals(tagName)){
				result.add(i);
			}
		}
		System.out.println(result.size());
		return result; 
	}

	@Override public ArrayList<Node> visitCondAnd(@NotNull XQueryParser.CondAndContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpFilter(@NotNull XQueryParser.RpFilterContext ctx) { 
		System.out.println("visitRpFilter "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> temp = visit(ctx.getChild(0));
		
		ArrayList<Node> result = new ArrayList<>();
		ArrayList<Node> single = new ArrayList<>();
		for (Node i : temp){
			single.add(i);
			values.put(ctx.getChild(2), single);
			ArrayList<Node> filter = visit(ctx.getChild(2));
			if (filter.size()>0){//filter size==0:false;filter size>0: true
				result.add(i);
			}
			single.remove(0);
		}
		
		return result; 
	}

	@Override public ArrayList<Node> visitXqConcat(@NotNull XQueryParser.XqConcatContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) { 
		System.out.println("visitRpParenExpr "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(1), sub);
		return visit(ctx.getChild(1)); 
	}

	@Override public ArrayList<Node> visitCondNot(@NotNull XQueryParser.CondNotContext ctx) { return visitChildren(ctx); }

	@Override public ArrayList<Node> visitFAnd(@NotNull XQueryParser.FAndContext ctx) { 
		System.out.println("visitFAnd "+ctx.getText());
		
		ArrayList<Node> sub = values.get(ctx);
		values.removeFrom(ctx);
		values.put(ctx.getChild(0), sub);
		ArrayList<Node> left = visit(ctx.getChild(0));
		values.put(ctx.getChild(2), sub);
		ArrayList<Node> right = visit(ctx.getChild(2));
		
		if (left.size()==0){
			return left;
		} 
		if (right.size()==0){
			return right;
		}
		return left;//left size >0: indicating true
	}
	
	private ArrayList<Node> slashHelper(ArrayList<Node> prec){
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : prec){
			result.addAll(XMLTreefunction.getChildren(i));
		}
		return XMLTreefunction.unique(result);
	}
	
	private ArrayList<Node> slashSlashHelper(ArrayList<Node> prec){
		ArrayList<Node> result = new ArrayList<>();
		for (Node i : prec){
			result.addAll(XMLTreefunction.getDescendant(i));
		}
		return XMLTreefunction.unique(result);
	}
}
