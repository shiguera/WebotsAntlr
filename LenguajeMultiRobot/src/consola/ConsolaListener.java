package consola;

import lenguaje.RoboLangBaseListener;
import lenguaje.RoboLangParser;

public class ConsolaListener extends RoboLangBaseListener {
    
    private RobotConsola robot;

    public ConsolaListener() {
        robot = new RobotConsola();
    }

    @Override
    public void enterAvanza(RoboLangParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA(" + v + "," + d + ")");
        robot.hacerAvance(v, d);
    }
    @Override
    public void enterGira(RoboLangParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.hacerGiro(angle);
    }
}
