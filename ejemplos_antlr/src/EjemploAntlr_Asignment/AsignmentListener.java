// Generated from Asignment.g4 by ANTLR 4.13.2

    package EjemploAntlr_Asignment;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AsignmentParser}.
 */
public interface AsignmentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AsignmentParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(AsignmentParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AsignmentParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(AsignmentParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AsignmentParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AsignmentParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AsignmentParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AsignmentParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AsignmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(AsignmentParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link AsignmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(AsignmentParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link AsignmentParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AsignmentParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AsignmentParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AsignmentParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(AsignmentParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(AsignmentParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(AsignmentParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(AsignmentParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(AsignmentParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link AsignmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(AsignmentParser.StringExprContext ctx);
}