public class SimpleController {
   static SimpleVehicle robot;

   public static void main(String[] args) {

      int TIME_STEP = 32;
      
      robot = new SimpleVehicle(TIME_STEP);
      
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
   }
}