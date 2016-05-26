// Generated from xqueryprocessor/yili_yu/XQuery.g4 by ANTLR 4.3
package xqueryprocessor.yili_yu;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code condValEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondValEqual(@NotNull XQueryParser.CondValEqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqParenExpr}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqParenExpr(@NotNull XQueryParser.XqParenExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqFLWR(@NotNull XQueryParser.XqFLWRContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpDotDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDotDot(@NotNull XQueryParser.RpDotDotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fRp}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFRp(@NotNull XQueryParser.FRpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSlash(@NotNull XQueryParser.XqSlashContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#varBind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarBind(@NotNull XQueryParser.VarBindContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#someClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApSlash(@NotNull XQueryParser.ApSlashContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDot(@NotNull XQueryParser.RpDotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(@NotNull XQueryParser.RpTextContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqTagName}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqTagName(@NotNull XQueryParser.XqTagNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(@NotNull XQueryParser.LetClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpConcat}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpConcat(@NotNull XQueryParser.RpConcatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fIdEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFIdEqual(@NotNull XQueryParser.FIdEqualContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOr(@NotNull XQueryParser.CondOrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttr(@NotNull XQueryParser.RpAttrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condEmpty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEmpty(@NotNull XQueryParser.CondEmptyContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqVar}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqVar(@NotNull XQueryParser.XqVarContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqJoin(@NotNull XQueryParser.XqJoinContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fNot}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFNot(@NotNull XQueryParser.FNotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condSomeSatis}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondSomeSatis(@NotNull XQueryParser.CondSomeSatisContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#indexing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexing(@NotNull XQueryParser.IndexingContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condIdEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondIdEqual(@NotNull XQueryParser.CondIdEqualContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fParen}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFParen(@NotNull XQueryParser.FParenContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fOr}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFOr(@NotNull XQueryParser.FOrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fValEqual}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFValEqual(@NotNull XQueryParser.FValEqualContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpWildcard}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpWildcard(@NotNull XQueryParser.RpWildcardContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqLet(@NotNull XQueryParser.XqLetContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqStringConstant}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqStringConstant(@NotNull XQueryParser.XqStringConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#letVarBind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetVarBind(@NotNull XQueryParser.LetVarBindContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqAp(@NotNull XQueryParser.XqApContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqImpJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqImpJoin(@NotNull XQueryParser.XqImpJoinContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condParenExpr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondParenExpr(@NotNull XQueryParser.CondParenExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlash(@NotNull XQueryParser.RpSlashContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqSlashSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSlashSlash(@NotNull XQueryParser.XqSlashSlashContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(@NotNull XQueryParser.ForClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTagName(@NotNull XQueryParser.RpTagNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondAnd(@NotNull XQueryParser.CondAndContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(@NotNull XQueryParser.RpFilterContext ctx);

	/**
	 * Visit a parse tree produced by the {@code xqConcat}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqConcat(@NotNull XQueryParser.XqConcatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code rpParenExpr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParenExpr(@NotNull XQueryParser.RpParenExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNot(@NotNull XQueryParser.CondNotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code fAnd}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFAnd(@NotNull XQueryParser.FAndContext ctx);
}