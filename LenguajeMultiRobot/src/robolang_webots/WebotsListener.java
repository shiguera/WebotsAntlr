package robolang_webots;

import lenguaje.RoboLangBaseListener;
import lenguaje.RoboLangParser;

public class WebotsListener extends RoboLangBaseListener {

    static RobotWebots robot;

    public WebotsListener() {
        
        int TIME_STEP = 32;
        robot = new RobotWebots(TIME_STEP);
    }

    @Override
    public void enterAvanza(RoboLangParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA("+v+", "+d+")");
        robot.moveForward(v, d);
    }
    @Override
    public void enterGira(RoboLangParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.pivotAngle(angle);
    }
   
}
