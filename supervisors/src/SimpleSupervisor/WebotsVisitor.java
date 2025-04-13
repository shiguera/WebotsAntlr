// Generated from Webots.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WebotsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WebotsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WebotsParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(WebotsParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Avanza}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvanza(WebotsParser.AvanzaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gira}
	 * labeled alternative in {@link WebotsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGira(WebotsParser.GiraContext ctx);
}