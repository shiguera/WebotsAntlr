package robot_consola;

import parser.RobotBaseListener;
import parser.RobotParser;

public class RobotConsolaListener extends RobotBaseListener {

    public RobotConsolaListener() {
        
    }

    @Override
    public void enterAvanza(RobotParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA("+v+", "+d+")");
    }
    @Override
    public void enterGira(RobotParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
    }
   
}
