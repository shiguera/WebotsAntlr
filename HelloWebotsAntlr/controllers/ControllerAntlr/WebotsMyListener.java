public class WebotsMyListener extends WebotsBaseListener {

    static SimpleVehicle robot;

    public WebotsMyListener(SimpleVehicle robot) {
        WebotsMyListener.robot = robot;
    }

    @Override
    public void enterAvanza(WebotsParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA("+v+", "+d+")");
        robot.moveForward(v, d);
    }
    @Override
    public void enterGira(WebotsParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.pivotAngle(angle);
    }
   
}
