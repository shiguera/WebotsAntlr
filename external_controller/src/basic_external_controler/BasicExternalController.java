import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class BasicExternalController {
    static SimpleVehicle_3 robot;

    public static void main(String[] args) throws IllegalStateException {


        String worldFileName = "../../worlds/Mundo_2.wbt";

        // Comprobar si Webots ya está arrancado
        boolean isWebotsRunning = !available(1234);
        if (isWebotsRunning == false) {
            try {
                ProcessBuilder processBuilder = 
                   new ProcessBuilder("webots", "--stdout", worldFileName);
                processBuilder.redirectErrorStream(true); // Redirige errores al flujo estándar
                processBuilder.start();
                Thread.sleep(2000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        int TIME_STEP = 32;
        robot = new SimpleVehicle_3(TIME_STEP);

        robot.moveForward(0.8, 1);
        robot.pivotAngle(45.0);
        robot.moveForward(0.8, 1);
        robot.pivotAngle(45.0);
        robot.moveForward(0.8, 1);
    }

    /**
     * Sirve para ver si el puerto que usa Webots está en uso
     * 
     * @param port puerto que se quiere comprobar si está en escucha
     * @return true si el puerto está libre
     * @throws IllegalStateException
     */
    private static boolean available(int port) throws IllegalStateException {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (ConnectException e) {
            return true;
        } catch (IOException e) {
            throw new IllegalStateException("Error while trying to check open port", e);
        }
    }
}