// Generated from RoboLang.g4 by ANTLR 4.13.2

    package lenguaje;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RoboLangParser}.
 */
public interface RoboLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RoboLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(RoboLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RoboLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(RoboLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link RoboLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAvanza(RoboLangParser.AvanzaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link RoboLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAvanza(RoboLangParser.AvanzaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link RoboLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGira(RoboLangParser.GiraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link RoboLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGira(RoboLangParser.GiraContext ctx);
}