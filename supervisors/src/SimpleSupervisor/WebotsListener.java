// Generated from Webots.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WebotsParser}.
 */
public interface WebotsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WebotsParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(WebotsParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link WebotsParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(WebotsParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAvanza(WebotsParser.AvanzaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAvanza(WebotsParser.AvanzaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGira(WebotsParser.GiraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGira(WebotsParser.GiraContext ctx);
}