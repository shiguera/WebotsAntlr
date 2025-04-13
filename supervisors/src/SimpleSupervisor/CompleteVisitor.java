// Generated from Complete.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompleteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompleteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompleteParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(CompleteParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CompleteParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(CompleteParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CompleteParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(CompleteParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(CompleteParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(CompleteParser.Stat_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(CompleteParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompleteParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(CompleteParser.LogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moveForward}
	 * labeled alternative in {@link CompleteParser#avanza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveForward(CompleteParser.MoveForwardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pivotAngle}
	 * labeled alternative in {@link CompleteParser#gira}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotAngle(CompleteParser.PivotAngleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sound}
	 * labeled alternative in {@link CompleteParser#alerta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSound(CompleteParser.SoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code penDown}
	 * labeled alternative in {@link CompleteParser#pintar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenDown(CompleteParser.PenDownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code penUp}
	 * labeled alternative in {@link CompleteParser#no_pintar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenUp(CompleteParser.PenUpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(CompleteParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(CompleteParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(CompleteParser.MultiplicationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(CompleteParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(CompleteParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(CompleteParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(CompleteParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(CompleteParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(CompleteParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(CompleteParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(CompleteParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(CompleteParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(CompleteParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(CompleteParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(CompleteParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilAtom(CompleteParser.NilAtomContext ctx);
}