// Generated from SimpleLog.g4 by ANTLR 4.13.2

    package EjemploAntlr_Log;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLogParser}.
 */
public interface SimpleLogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLogParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SimpleLogParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLogParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SimpleLogParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLogParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleLogParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLogParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleLogParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLogParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SimpleLogParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLogParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SimpleLogParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLogParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(SimpleLogParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLogParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(SimpleLogParser.LogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(SimpleLogParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(SimpleLogParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(SimpleLogParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(SimpleLogParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(SimpleLogParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link SimpleLogParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(SimpleLogParser.StringExprContext ctx);
}