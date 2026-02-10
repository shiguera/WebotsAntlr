package stddraw;

import lenguaje.RoboLangBaseListener;
import lenguaje.RoboLangParser;
import lenguaje.RoboLangParser.ProgContext;
import sound.StdAudio;

public class StdDrawListener extends RoboLangBaseListener {
    private RobotStdDraw robot;

    public StdDrawListener() {
        robot = new RobotStdDraw();
    }

    @Override
    public void enterProg(ProgContext ctx) {
        super.enterProg(ctx);
    }

    @Override
    public void exitProg(ProgContext ctx) {
        StdAudio.stopInBackground();
        System.out.println("🎮 Simulación finalizada.");
        super.exitProg(ctx);
    }

    @Override
    public void enterAvanza(RoboLangParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA(" + v + "," + d + ")");
        robot.avanzar(v, d);
    }

    @Override
    public void enterGira(RoboLangParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA " + angle);
        robot.girar(angle);
    }

}
