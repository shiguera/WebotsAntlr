// Generated from Complete.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompleteParser}.
 */
public interface CompleteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompleteParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(CompleteParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(CompleteParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CompleteParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CompleteParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CompleteParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CompleteParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CompleteParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CompleteParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(CompleteParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(CompleteParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(CompleteParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(CompleteParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(CompleteParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(CompleteParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(CompleteParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(CompleteParser.While_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompleteParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(CompleteParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompleteParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(CompleteParser.LogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moveForward}
	 * labeled alternative in {@link CompleteParser#avanza}.
	 * @param ctx the parse tree
	 */
	void enterMoveForward(CompleteParser.MoveForwardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moveForward}
	 * labeled alternative in {@link CompleteParser#avanza}.
	 * @param ctx the parse tree
	 */
	void exitMoveForward(CompleteParser.MoveForwardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pivotAngle}
	 * labeled alternative in {@link CompleteParser#gira}.
	 * @param ctx the parse tree
	 */
	void enterPivotAngle(CompleteParser.PivotAngleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pivotAngle}
	 * labeled alternative in {@link CompleteParser#gira}.
	 * @param ctx the parse tree
	 */
	void exitPivotAngle(CompleteParser.PivotAngleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(CompleteParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(CompleteParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(CompleteParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(CompleteParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(CompleteParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(CompleteParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(CompleteParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(CompleteParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(CompleteParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(CompleteParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(CompleteParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(CompleteParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(CompleteParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(CompleteParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(CompleteParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(CompleteParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(CompleteParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(CompleteParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(CompleteParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link CompleteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(CompleteParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(CompleteParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(CompleteParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(CompleteParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(CompleteParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(CompleteParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(CompleteParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(CompleteParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(CompleteParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(CompleteParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(CompleteParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNilAtom(CompleteParser.NilAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link CompleteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNilAtom(CompleteParser.NilAtomContext ctx);
}