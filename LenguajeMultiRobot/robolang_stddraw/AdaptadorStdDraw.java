package robolang_stddraw;

import lenguaje.RoboLangBaseListener;
import lenguaje.RoboLangParser;

public class AdaptadorStdDraw extends RoboLangBaseListener {
    private RobotStdDraw robot;

    public AdaptadorStdDraw() {
        robot = new RobotStdDraw();
    }

    @Override
    public void enterAvanza(RoboLangParser.AvanzaContext ctx) {
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA(" + d + ")");
        robot.avanzar(d);
    }
    @Override
    public void enterGira(RoboLangParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.girar(angle);
    }

    
}
