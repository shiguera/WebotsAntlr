// Generated from Robot.g4 by ANTLR 4.13.2

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RobotParser}.
 */
public interface RobotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RobotParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(RobotParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobotParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(RobotParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link RobotParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAvanza(RobotParser.AvanzaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link RobotParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAvanza(RobotParser.AvanzaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link RobotParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGira(RobotParser.GiraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link RobotParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGira(RobotParser.GiraContext ctx);
}