package EjemploAntlr_Log;
public class MySimpleLogVisitor extends SimpleLogBaseVisitor<Value> {

    @Override
    public Value visitLog(SimpleLogParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        System.out.println(value);
        return value;
    }
    @Override
    public Value visitFloatExpr(SimpleLogParser.FloatExprContext ctx) {
        return new Value(Double.parseDouble(ctx.getText()));
    }
    @Override
    public Value visitIntExpr(SimpleLogParser.IntExprContext ctx) {
        return new Value(Integer.parseInt(ctx.getText()));
    }
    @Override
    public Value visitStringExpr(SimpleLogParser.StringExprContext ctx) {
        return new Value(ctx.getText());
    }
}

