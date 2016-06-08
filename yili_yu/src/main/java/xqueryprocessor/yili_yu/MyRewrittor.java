package xqueryprocessor.yili_yu;

import java.util.*;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.w3c.dom.Node;

/**
* This class provides an empty implementation of {@link XQueryVisitor},
* which can be extended to create a visitor which only needs to handle a subset
* of the available methods.
*
* @param <T> The return type of the visit operation. Use {@link Void} for
* operations with no return type.
*/
public class  MyRewrittor extends XQueryBaseVisitor<String> {
	public class VarNode{
		String name;
		String pred;
		int childCount = 0;
		int label;
		ArrayList<VarNode> children = new ArrayList<>();
		
		public VarNode(String n, String p, int l){
			name = n;
			pred = p;
			label = l;
		}
		public void add(VarNode child){
			children.add(child);
			childCount++;
		}
	}
	
	VarNode root = null;
	HashMap<String, VarNode> varMap = new HashMap<>();
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) { return null; }

	@Override public String visitXqParenConcat(@NotNull XQueryParser.XqParenConcatContext ctx) { return null; }
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) {
		//simplify XQuery
		ArrayList<ParseTree> forList = new ArrayList<>();
		ArrayList<ParseTree> condList = new ArrayList<>();
		HashSet<String> tupleAttr = new HashSet<>();
		
		boolean flag = false;
		if (ctx.getChildCount()==3 && ctx.getChild(1).getChild(0).getText().equals("where")){
			flag = checkFor(ctx.getChild(0), forList);
			if (flag){
				flag = checkCond(ctx.getChild(1).getChild(1), condList, tupleAttr);
			}
			if (flag){
				flag = checkReturn(ctx.getChild(2).getChild(1));
			}
		}
		
		if (flag){
			String returnString = "return "+rewriteReturn(ctx.getChild(2).getChild(1), forList, tupleAttr);
			
			generateVarTree(forList);
			
			int[] plan = generateJoinPlan(condList);
			
			String result = rewriteFor(plan[0], forList, condList, tupleAttr);
			String secondFor, joinAttr;
			
			for (int i=1; i<root.childCount; i++){
				secondFor = rewriteFor(plan[i], forList, condList, tupleAttr);
				joinAttr = generateJoinAttr(i, plan, condList);
				result = "join(\n"+result+",\n\n"+secondFor+",\n\n"+joinAttr+")";
			}
			
			result = "for $tuple in \n"+result+"\n"+returnString;
			return result;
		}
		
		return null; 
	}
	
	private boolean checkFor(ParseTree ctx, ArrayList<ParseTree> forList){
		for (int i=1; i<ctx.getChildCount(); i+=2){
			forList.add(ctx.getChild(i));
			ParseTree varChild = ctx.getChild(i).getChild(2);
			if (!varChild.getText().startsWith("$") &&
					!varChild.getText().startsWith("doc") &&
					!varChild.getText().startsWith("document")){
				return false;
			}
		}
		return true;
	}
	
	private boolean checkCond(ParseTree ctx, ArrayList<ParseTree> condList, HashSet<String> tupleAttr){
		if (ctx.getText().startsWith("not") ||
				ctx.getText().startsWith("empty") ||
				ctx.getText().startsWith("some")){
			return false;
		}
		if (ctx.getChild(1).getText().equals("==") ||
				ctx.getChild(1).getText().equals("is") ||
				ctx.getChild(1).getText().equals("or")){
			return false;
		}
		if (ctx.getChild(1).getText().equals("=") || ctx.getChild(1).getText().equals("eq")){
			String left = ctx.getChild(0).getText();
			String right = ctx.getChild(2).getText();
			if (!((left.startsWith("$") && left.indexOf("/")<0) || left.startsWith("\""))){
				return false;
			}
			if (!((right.startsWith("$") && right.indexOf("/")<0) || right.startsWith("\""))){
				return false;
			}
			condList.add(ctx);
			if (left.startsWith("$") && right.startsWith("$")){
				tupleAttr.add(left);
				tupleAttr.add(right);
			}
			return true;
		}
		if (ctx.getChild(1).getText().equals("and")){
			return checkCond(ctx.getChild(0), condList, tupleAttr) && checkCond(ctx.getChild(2), condList, tupleAttr);
		}
		if (ctx.getText().startsWith("(")){
			return checkCond(ctx.getChild(1), condList, tupleAttr);
		}	
		return false;
	}

	private boolean checkReturn(ParseTree ctx){
		if (ctx.getText().startsWith("$") 
				|| ctx.getText().startsWith("doc") 
				|| ctx.getText().startsWith("document")){
			return true;
		}
		if (ctx.getChildCount()==9){
			return checkReturn(ctx.getChild(4));
		}
		if (ctx.getChildCount()==3 && ctx.getChild(1).getText().equals(",")){
			return checkReturn(ctx.getChild(0)) && checkReturn(ctx.getChild(2));
		}
		if (ctx.getChildCount()==3 && ctx.getChild(0).getText().equals("(")){
			return checkReturn(ctx.getChild(1));
		}
		return false;
	}
	
	private String rewriteReturn(ParseTree ctx, ArrayList<ParseTree> forList, HashSet<String> tupleAttr){
		String str = ctx.getText();
		if (ctx.getChildCount()==9){
			return "<"+ctx.getChild(1)+">{"+rewriteReturn(ctx.getChild(4), forList, tupleAttr)+"}</"+ctx.getChild(7)+">";
		}
		if (ctx.getChildCount()==3 && ctx.getChild(1).getText().equals(",")){
			return rewriteReturn(ctx.getChild(0), forList, tupleAttr)+", "+rewriteReturn(ctx.getChild(2), forList, tupleAttr);
		}
		if (ctx.getChildCount()==3 && ctx.getChild(0).getText().equals("(")){
			return "("+rewriteReturn(ctx.getChild(1), forList, tupleAttr)+")";
		}
		if (str.startsWith("$")){
			int ind = str.indexOf("/");
			String attr = "";
			if (ind>=0){
				attr = str.substring(0, ind);
			}
			else{
				attr = str;
			}
			tupleAttr.add(attr);
			
			String tag="";
			int ind2;
			for (ParseTree var : forList){
				if (var.getText().startsWith(attr)){
					tag = var.getChild(2).getText();
					ind2 = tag.lastIndexOf("/");
					if (ind2>=0){
						tag = tag.substring(ind2);
					}
				}
			}
			String result="";
			if (ind<0){
				result = "$tuple/"+attr.substring(1)+tag;
			}
			else{
				result = "$tuple/"+attr.substring(1)+tag+str.substring(ind);
			}
			
			return result;
		}
		if (str.startsWith("doc") || str.startsWith("document")){
			return str;
		}
		return ctx.getText();
	}
	
	private void generateVarTree(ArrayList<ParseTree> forList){
		String rp = forList.get(0).getChild(2).getText();
		int ind = rp.indexOf('/');
		if (ind>=0){
			root = new VarNode(rp.substring(0, ind), "", -1);
			varMap.put(rp.substring(0, ind), root);
		}
		else{
			root = new VarNode(rp, "", -1);
			varMap.put(rp, root);
		}

		VarNode parentNode, childNode;
		String parentVar, childVar, navPath;
		int parLabel;
		for (ParseTree bind : forList){
			childVar = bind.getChild(0).getText();
			rp = bind.getChild(2).getText();
			ind = rp.indexOf('/');
			if (ind>=0){
				parentVar = rp.substring(0, ind);
				navPath = rp.substring(ind+1);
			}
			else{
				parentVar = rp;
				navPath = "";
			}
			parentNode = varMap.get(parentVar);
			if (parentNode.equals(root)){
				parLabel = parentNode.childCount;
			}
			else{
				parLabel = parentNode.label;
			}
			childNode = new VarNode(childVar, navPath, parLabel);
			varMap.put(childVar, childNode);
			parentNode.add(childNode);
		}
	}
	
	private int[] generateJoinPlan(ArrayList<ParseTree> condList){
		int parNum = root.childCount;
		int[] plan = new int[parNum];
		boolean[][] edge = new boolean[parNum][parNum];
		boolean[] vertex = new boolean[parNum];
		
		for (int i=0; i<parNum; i++){
			vertex[i] = false;
			for (int j=0; j<parNum; j++){
				edge[i][j] = false;
			}
		}
		
		String leftVar, rightVar;
		VarNode leftNode, rightNode;
		for (ParseTree cond : condList){
			leftVar = cond.getChild(0).getText();
			rightVar = cond.getChild(2).getText();
			if (leftVar.startsWith("$") && rightVar.startsWith("$")){
				leftNode = varMap.get(leftVar);
				rightNode = varMap.get(rightVar);
				edge[leftNode.label][rightNode.label] = true;
				edge[rightNode.label][leftNode.label] = true;
			}
		}
		
		plan[0] = 0;
		vertex[0] = true;
		int ind = 1;
		boolean flag;
		while (ind<parNum){
			flag = false;
			for (int i=0; i<parNum; i++){
				if (!vertex[i] && edge[plan[ind-1]][i]){
					plan[ind++] = i;
					vertex[i] = true;
					flag = true;
					break;
				}
			}
			if (!flag){
				for (int i=0; i<parNum; i++){
					if (!vertex[i]){
						plan[ind++] = i;
					}
				}
				break;
			}
		}
		
		return plan;
	}
	
	private String rewriteFor(int ind, ArrayList<ParseTree> forList, ArrayList<ParseTree> condList, HashSet<String> tupleAttr){
		String forStr = "for ";
		String varName;
		VarNode varNode;
		for (ParseTree bind : forList){
			varName = bind.getChild(0).getText();
			varNode = varMap.get(varName);
			if (varNode.label==ind){
				if (forStr.length()==4){
					forStr += (bind.getChild(0).getText()+" in "+bind.getChild(2).getText());
				}
				else{
					forStr += (",\n"+bind.getChild(0).getText()+" in "+bind.getChild(2).getText());
				}
			}
		}
		
		String whereStr = "where ";
		for (ParseTree cond : condList){
			VarNode leftNode, rightNode;
			if (cond.getChild(0).getText().startsWith("\"")){
				varName = cond.getChild(2).getText();
				leftNode = varMap.get(varName);
				rightNode = leftNode;
			}
			else if (cond.getChild(2).getText().startsWith("\"")){
				varName = cond.getChild(0).getText();
				leftNode = varMap.get(varName);
				rightNode = leftNode;
			}
			else{
				varName = cond.getChild(0).getText();
				leftNode = varMap.get(varName);
				varName = cond.getChild(2).getText();
				rightNode = varMap.get(varName);
			}
			
			if (leftNode.label==rightNode.label && leftNode.label==ind){
				if (whereStr.length()==6){
					whereStr += (cond.getChild(0).getText()+" eq "+cond.getChild(2).getText());
				}
				else{
					whereStr += (" and \n"+cond.getChild(0).getText()+" eq "+cond.getChild(2).getText());
				}
			}
		}
		
		String returnStr = "return <tuple>{";
		for (String attr : tupleAttr){
			varNode = varMap.get(attr);
			if (varNode.label==ind){
				if (returnStr.length()==15){
					returnStr += ("<"+attr.substring(1)+">{"+attr+"}</"+attr.substring(1)+">");
				}
				else{
					returnStr += (",\n<"+attr.substring(1)+">{"+attr+"}</"+attr.substring(1)+">");
				}
			}
		}
		returnStr += "}</tuple>";
		
		String result = forStr;
		if (whereStr.length()>6){
			result += ("\n"+whereStr);
		}
		result += ("\n"+returnStr);
		
		return result;
	}
	
	private String generateJoinAttr(int index, int[] plan, ArrayList<ParseTree> condList){
		String left = "", right = "";
		String leftVar, rightVar;
		VarNode leftNode, rightNode;
		int ind = plan[index];
		for (ParseTree cond : condList){
			leftVar = cond.getChild(0).getText();
			rightVar = cond.getChild(2).getText();
			if (leftVar.startsWith("$") && rightVar.startsWith("$")){
				leftNode = varMap.get(leftVar);
				rightNode = varMap.get(rightVar);
				if (leftNode.label==ind && rightNode.label!=ind){
					leftNode = varMap.get(rightVar);
					rightNode = varMap.get(leftVar);
				}
				if (leftNode.label==ind || rightNode.label!=ind){
					continue;
				}
				for (int i=0; i<index; i++){
					if (plan[i]==leftNode.label){
						if (left.length()==0){
							left += leftVar.substring(1);
							right += rightVar.substring(1);
						}
						else{
							left += (","+leftVar.substring(1));
							right += (","+rightVar.substring(1));
						}
						break;
					}
				}
			}
		}
		return "["+left+"],["+right+"]";
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFRp(@NotNull XQueryParser.FRpContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqSlash(@NotNull XQueryParser.XqSlashContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVarBind(@NotNull XQueryParser.VarBindContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitApSlash(@NotNull XQueryParser.ApSlashContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpDot(@NotNull XQueryParser.RpDotContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpText(@NotNull XQueryParser.RpTextContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) {
		String res = visit(ctx.getChild(4));
		if (res==null) return null;
		return "<"+ctx.getChild(1).getText()+">{"+res+"}</"+ctx.getChild(7)+">";
	}
	

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpConcat(@NotNull XQueryParser.RpConcatContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondOr(@NotNull XQueryParser.CondOrContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpAttr(@NotNull XQueryParser.RpAttrContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqVar(@NotNull XQueryParser.XqVarContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqJoin(@NotNull XQueryParser.XqJoinContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFNot(@NotNull XQueryParser.FNotContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIndexing(@NotNull XQueryParser.IndexingContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFParen(@NotNull XQueryParser.FParenContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFOr(@NotNull XQueryParser.FOrContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFValEqual(@NotNull XQueryParser.FValEqualContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqLet(@NotNull XQueryParser.XqLetContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitLetVarBind(@NotNull XQueryParser.LetVarBindContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqAp(@NotNull XQueryParser.XqApContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqImpJoin(@NotNull XQueryParser.XqImpJoinContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitForClause(@NotNull XQueryParser.ForClauseContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondAnd(@NotNull XQueryParser.CondAndContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpFilter(@NotNull XQueryParser.RpFilterContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXqConcat(@NotNull XQueryParser.XqConcatContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCondNot(@NotNull XQueryParser.CondNotContext ctx) { return null; }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFAnd(@NotNull XQueryParser.FAndContext ctx) { return null; }
}
