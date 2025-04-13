public class SimpleController {
   static SimpleVehicle_0 robot;

   public static void main(String[] args) {

      int TIME_STEP = 32;
      
      robot = new SimpleVehicle_0(TIME_STEP);
      
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
   }
}