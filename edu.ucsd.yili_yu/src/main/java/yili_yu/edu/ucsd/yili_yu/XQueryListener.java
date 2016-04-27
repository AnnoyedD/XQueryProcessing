// Generated from yili_yu/edu/ucsd/yili_yu/XQuery.g4 by ANTLR 4.3
package yili_yu.edu.ucsd.yili_yu;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code condValEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condValEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqParenExpr}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqParenExpr}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFRp(@NotNull XQueryParser.FRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFRp(@NotNull XQueryParser.FRpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqSlash(@NotNull XQueryParser.XqSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqSlash(@NotNull XQueryParser.XqSlashContext ctx);

	/**
	 * Enter a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApSlash(@NotNull XQueryParser.ApSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApSlash(@NotNull XQueryParser.ApSlashContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDot(@NotNull XQueryParser.RpDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDot(@NotNull XQueryParser.RpDotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(@NotNull XQueryParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(@NotNull XQueryParser.RpTextContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqTagName}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqTagName(@NotNull XQueryParser.XqTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqTagName}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(@NotNull XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(@NotNull XQueryParser.LetClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpConcat(@NotNull XQueryParser.RpConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpConcat(@NotNull XQueryParser.RpConcatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondOr(@NotNull XQueryParser.CondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondOr(@NotNull XQueryParser.CondOrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttr(@NotNull XQueryParser.RpAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttr(@NotNull XQueryParser.RpAttrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condEmpty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condEmpty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqVar}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqVar(@NotNull XQueryParser.XqVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqVar}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqVar(@NotNull XQueryParser.XqVarContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFNot(@NotNull XQueryParser.FNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFNot(@NotNull XQueryParser.FNotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condSomeSatis}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condSomeSatis}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condIdEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condIdEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFParen(@NotNull XQueryParser.FParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFParen(@NotNull XQueryParser.FParenContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFOr(@NotNull XQueryParser.FOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFOr(@NotNull XQueryParser.FOrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFValEqual(@NotNull XQueryParser.FValEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFValEqual(@NotNull XQueryParser.FValEqualContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpWildcard}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpWildcard}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqLet(@NotNull XQueryParser.XqLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqLet(@NotNull XQueryParser.XqLetContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqStringConstant}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqStringConstant}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqAp(@NotNull XQueryParser.XqApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqAp(@NotNull XQueryParser.XqApContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condParenExpr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condParenExpr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlash(@NotNull XQueryParser.RpSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlash(@NotNull XQueryParser.RpSlashContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqSlashSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqSlashSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(@NotNull XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(@NotNull XQueryParser.ForClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTagName(@NotNull XQueryParser.RpTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondAnd(@NotNull XQueryParser.CondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondAnd(@NotNull XQueryParser.CondAndContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(@NotNull XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(@NotNull XQueryParser.RpFilterContext ctx);

	/**
	 * Enter a parse tree produced by the {@code xqConcat}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqConcat(@NotNull XQueryParser.XqConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqConcat}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqConcat(@NotNull XQueryParser.XqConcatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNot(@NotNull XQueryParser.CondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNot(@NotNull XQueryParser.CondNotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFAnd(@NotNull XQueryParser.FAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFAnd(@NotNull XQueryParser.FAndContext ctx);
}