// Generated from Asignment.g4 by ANTLR 4.13.2

    package EjemploAntlr_Asignment;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AsignmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AsignmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AsignmentParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(AsignmentParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AsignmentParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(AsignmentParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AsignmentParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(AsignmentParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link AsignmentParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AsignmentParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(AsignmentParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(AsignmentParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(AsignmentParser.StringExprContext ctx);
}