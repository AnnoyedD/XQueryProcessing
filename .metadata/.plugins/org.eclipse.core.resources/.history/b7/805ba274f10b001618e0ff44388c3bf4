// Generated from edu\u005Cucsd\antlrtutorial\antlrtutorial\XQuery.g4 by ANTLR 4.3
package yili_yu.edu.ucsd.yili_yu;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import xml.to.dom.*;

/**
 * This class provides an empty implementation of {@link XQueryListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class XQueryProcessor extends XQueryBaseListener {
	 ParseTreeProperty<ArrayList<Node>> values = new ParseTreeProperty<>();
	 ArrayList<XMLTree> domList = new ArrayList<>();
	 /**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			ArrayList<Node> result = new ArrayList<>();
			for (Node i : sub){
				result.add(XMLTreefunction.getParent(XMLTreefunction.getParent(i)));
			}
			XMLTreefunction.unique(result);
			values.put(ctx, result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFRp(@NotNull XQueryParser.FRpContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFRp(@NotNull XQueryParser.FRpContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqSlash(@NotNull XQueryParser.XqSlashContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqSlash(@NotNull XQueryParser.XqSlashContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpDot(@NotNull XQueryParser.RpDotContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			ArrayList<Node> result = new ArrayList<>();
			for (Node i : sub){
				result.add(XMLTreefunction.getParent(i));
			}
			XMLTreefunction.unique(result);
			values.put(ctx, result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpDot(@NotNull XQueryParser.RpDotContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpText(@NotNull XQueryParser.RpTextContext ctx) { 
			ArrayList<Node> sub = values.get(ctx);
			ArrayList<Node> result = new ArrayList<>();
			for (Node i : sub){
				result.add(XMLTreefunction.getTxt(i));
			}
			values.put(ctx, result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpText(@NotNull XQueryParser.RpTextContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterLetClause(@NotNull XQueryParser.LetClauseContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitLetClause(@NotNull XQueryParser.LetClauseContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpConcat(@NotNull XQueryParser.RpConcatContext ctx) { 
			ArrayList<Node> sub = values.get(ctx);
			values.put(ctx.getChild(0), sub);
			values.put(ctx.getChild(2), sub);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpConcat(@NotNull XQueryParser.RpConcatContext ctx) { 
			ParseTree target = ctx.getChild(0);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			target = ctx.getChild(2);
			result.addAll(values.get(target));
			values.removeFrom(target);
			values.put(ctx, result);
			
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondOr(@NotNull XQueryParser.CondOrContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondOr(@NotNull XQueryParser.CondOrContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpAttr(@NotNull XQueryParser.RpAttrContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			ArrayList<Node> result = new ArrayList<>();
			String attName = ctx.getChild(1).getText();
			for (Node i : sub){
				result.add(XMLTreefunction.attrib(i, attName));
			}
			values.put(ctx, result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpAttr(@NotNull XQueryParser.RpAttrContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqVar(@NotNull XQueryParser.XqVarContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqVar(@NotNull XQueryParser.XqVarContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFNot(@NotNull XQueryParser.FNotContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFNot(@NotNull XQueryParser.FNotContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFParen(@NotNull XQueryParser.FParenContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFParen(@NotNull XQueryParser.FParenContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFOr(@NotNull XQueryParser.FOrContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFOr(@NotNull XQueryParser.FOrContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFValEqual(@NotNull XQueryParser.FValEqualContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFValEqual(@NotNull XQueryParser.FValEqualContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqLet(@NotNull XQueryParser.XqLetContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqLet(@NotNull XQueryParser.XqLetContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterApSlash(@NotNull XQueryParser.ApSlashContext ctx) {
			String nameStr = ctx.getChild(2).getText();
			String fileName = nameStr.substring(1, nameStr.length()-1);
			XMLTree curXMLTree = null;
			for (XMLTree i : domList){
				if (i.getFileName() == fileName){
					curXMLTree = i;
					break;
				}
			}
			if (curXMLTree == null){
				curXMLTree = new XMLTree(fileName);
				domList.add(curXMLTree);
			}
			
			ArrayList<Node> result = new ArrayList<>();
			Node root = XMLTreefunction.getRoot(curXMLTree.getDoc());
			
			if (ctx.slash.getText().equals("//")){
				result.addAll(XMLTreefunction.getDescendant(root));
			}
			else{
				result.addAll(XMLTreefunction.getChildren(root));
			}
			
			values.put(ctx.getChild(5), result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitApSlash(@NotNull XQueryParser.ApSlashContext ctx) {
			ParseTree target = ctx.getChild(5);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			values.put(ctx, result);
		}
		
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqAp(@NotNull XQueryParser.XqApContext ctx) { 
			
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqAp(@NotNull XQueryParser.XqApContext ctx) { 
			ParseTree target = ctx.getChild(0);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			values.put(ctx, result);
			System.out.println(result.size());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpSlash(@NotNull XQueryParser.RpSlashContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			values.put(ctx.getChild(0), sub);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpSlash(@NotNull XQueryParser.RpSlashContext ctx) {
			ParseTree target = ctx.getChild(2);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			values.put(ctx, result);
			
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterForClause(@NotNull XQueryParser.ForClauseContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitForClause(@NotNull XQueryParser.ForClauseContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			ArrayList<Node> result = new ArrayList<>();
			String tagName = ctx.getText();
			for (Node i : sub){
				if (XMLTreefunction.getTag(i).equals(tagName)){
					result.add(i);
				}
			}
			values.put(ctx, result);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx) { 
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondAnd(@NotNull XQueryParser.CondAndContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondAnd(@NotNull XQueryParser.CondAndContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpFilter(@NotNull XQueryParser.RpFilterContext ctx) {
			ArrayList<Node> sub = values.get(ctx);
			values.put(ctx.getChild(0), sub);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpFilter(@NotNull XQueryParser.RpFilterContext ctx) { 
			ParseTree target = ctx.getChild(2);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			values.put(ctx, result);
			
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterXqConcat(@NotNull XQueryParser.XqConcatContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitXqConcat(@NotNull XQueryParser.XqConcatContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) { 
			ArrayList<Node> sub = values.get(ctx);
			values.put(ctx.getChild(1), sub);
		}
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx) {
			ParseTree target = ctx.getChild(1);
			ArrayList<Node> result = values.get(target);
			values.removeFrom(target);
			values.put(ctx, result);
			
			interDataTrans(ctx.getParent());
		}

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterCondNot(@NotNull XQueryParser.CondNotContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitCondNot(@NotNull XQueryParser.CondNotContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterFAnd(@NotNull XQueryParser.FAndContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitFAnd(@NotNull XQueryParser.FAndContext ctx) { }

		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void visitTerminal(@NotNull TerminalNode node) { }
		/**
		 * {@inheritDoc}
		 *
		 * <p>The default implementation does nothing.</p>
		 */
		@Override public void visitErrorNode(@NotNull ErrorNode node) { }
		
		private void interDataTrans(@NotNull ParserRuleContext ctx){
			if (ctx.getChildCount()>=3 && 
					(ctx.getChild(1).getText().equals("/") || 
					ctx.getChild(1).getText().equals("//") || 
					ctx.getChild(1).getText().equals("["))){
				ArrayList<Node> sub = values.get(ctx.getChild(0));
				ArrayList<Node> subRes = new ArrayList<>();
				if (ctx.getChild(1).getText().equals("/")){
					for (Node i : sub){
						subRes.addAll(XMLTreefunction.getChildren(i));
					}
				}
				if(ctx.getChild(1).getText().equals("//")){
					for (Node i : sub){
						subRes.addAll(XMLTreefunction.getDescendant(i));
					}
				}
				if(ctx.getChild(1).getText().equals("[")){
					subRes.addAll(sub);
				}
				values.put(ctx.getChild(1), subRes);
			}
		}
}
