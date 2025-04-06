package EjemploAntlr_Asignment;

import java.util.HashMap;
import java.util.Map;

public class MyAsignmentVisitor extends AsignmentBaseVisitor<Value> {

    // store variables (there's only one global scope!)
    private Map<String, Value> memory = new HashMap<String, Value>();

    // assignment/id overrides
    @Override
    public Value visitAssignment(AsignmentParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());
        boolean existe = memory.containsKey(id);
        if(existe == true) {
            System.out.println("La variable " + id + " ya existe, se sobrescribe");
        }
        System.out.println("Guardando " + id + " = " + value);
        return memory.put(id, value);
    }
    @Override
    public Value visitFloatExpr(AsignmentParser.FloatExprContext ctx) {
        return new Value(ctx.getText());
    }
    @Override
    public Value visitIntExpr(AsignmentParser.IntExprContext ctx) {
        return new Value(ctx.getText());
    }
    @Override
    public Value visitStringExpr(AsignmentParser.StringExprContext ctx) {
        return new Value(ctx.getText());
    }

}

