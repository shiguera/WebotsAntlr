import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCompleteVisitor extends CompleteBaseVisitor<Value> {

   // store variables (there's only one global scope!)
   private Map<String, Value> memory = new HashMap<String, Value>();
	// store the robot
	static SimpleVehicle_4 robot;

    public MyCompleteVisitor(SimpleVehicle_4 robot) {
        MyCompleteVisitor.robot = robot;
    }

	     // used to compare floating point numbers
    public static final double SMALL_VALUE = 0.00000000001;

    // assignment/id overrides
    @Override
    public Value visitAssignment(CompleteParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());
        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(CompleteParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value = memory.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(CompleteParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(CompleteParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(CompleteParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(CompleteParser.NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(CompleteParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(CompleteParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(CompleteParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(CompleteParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr( CompleteParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case CompleteParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case CompleteParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case CompleteParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + CompleteParser.VOCABULARY.getDisplayName(ctx.op.getType()));
        }
    }

    @Override
    public Value visitAdditiveExpr( CompleteParser.AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case CompleteParser.PLUS:
                return left.isDouble() && right.isDouble() ?
                        new Value(left.asDouble() + right.asDouble()) :
                        new Value(left.asString() + right.asString());
            case CompleteParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + CompleteParser.VOCABULARY.getDisplayName(ctx.op.getType()));
        }
    }

    @Override
    public Value visitRelationalExpr( CompleteParser.RelationalExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case CompleteParser.LT:
                return new Value(left.asDouble() < right.asDouble());
            case CompleteParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case CompleteParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case CompleteParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + CompleteParser.VOCABULARY.getDisplayName(ctx.op.getType()));
        }
    }

    @Override
    public Value visitEqualityExpr( CompleteParser.EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case CompleteParser.EQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                        new Value(left.equals(right));
            case CompleteParser.NEQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                        new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + CompleteParser.VOCABULARY.getDisplayName(ctx.op.getType()));
        }
    }

    @Override
    public Value visitAndExpr(CompleteParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(CompleteParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    @Override
    public Value visitLog(CompleteParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(CompleteParser.If_statContext ctx) {

        List<CompleteParser.Condition_blockContext> conditions =  ctx.condition_block();

        boolean evaluatedBlock = false;

        for(CompleteParser.Condition_blockContext condition : conditions) {

            Value evaluated = this.visit(condition.expr());

            if(evaluated.asBoolean()) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block());
                break;
            }
        }

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(CompleteParser.While_statContext ctx) {

        Value value = this.visit(ctx.expr());

        while(value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }
    @Override
    public Value visitMoveForward(CompleteParser.MoveForwardContext ctx) {
        Value val1 = this.visit(ctx.expr(0));
        double v = val1.asDouble();
        Value val2 = this.visit(ctx.expr(1));
        double d = val2.asDouble();        
        System.out.println("AVANZA("+v+", "+d+")");
        robot.moveForward(v, d);
        return super.visitMoveForward(ctx);
    }
    @Override
    public Value visitPivotAngle(CompleteParser.PivotAngleContext ctx) {
        Value val = this.visit(ctx.expr());
        double angle = val.asDouble();
        System.out.println("GIRA "+angle);
        robot.pivotAngle(angle);
        return super.visitPivotAngle(ctx);
    }   

    @Override
    public Value visitSound(CompleteParser.SoundContext ctx) {
        robot.sound();
        return super.visitSound(ctx);
    }
    @Override
    public Value visitPenDown(CompleteParser.PenDownContext ctx) {
        robot.penDown();
        return super.visitPenDown(ctx);
    }
    @Override
    public Value visitPenUp(CompleteParser.PenUpContext ctx) {
        robot.penUp();
        return super.visitPenUp(ctx);
    }
}
