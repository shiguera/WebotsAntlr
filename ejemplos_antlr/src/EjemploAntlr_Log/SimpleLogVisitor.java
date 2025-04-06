// Generated from SimpleLog.g4 by ANTLR 4.13.2

    package EjemploAntlr_Log;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLogParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(SimpleLogParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLogParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLogParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLogParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SimpleLogParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLogParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(SimpleLogParser.LogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(SimpleLogParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(SimpleLogParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(SimpleLogParser.StringExprContext ctx);
}