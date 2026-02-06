package robot_webots;

import java.io.IOException;

import parser.RobotBaseListener;
import parser.RobotParser;

public class RobotWebotsListener extends RobotBaseListener {

    static RobotWebots robot;

    public RobotWebotsListener() {
        
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("webots", "--stdout");
            processBuilder.redirectErrorStream(true); // Redirige errores al flujo estándar
            processBuilder.start();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        int TIME_STEP = 32;
        robot = new RobotWebots(TIME_STEP);

    }

    @Override
    public void enterAvanza(RobotParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA("+v+", "+d+")");
        robot.moveForward(v, d);
    }
    @Override
    public void enterGira(RobotParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.pivotAngle(angle);
    }
   
}
