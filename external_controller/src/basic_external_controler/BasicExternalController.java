import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.file.Path;
import java.util.Scanner;

public class BasicExternalController {
    static SimpleVehicle robot;

    public static void main(String[] args) throws IllegalStateException {

        Path workingDirectory = Path.of(System.getProperty("user.dir"));
        System.out.println(workingDirectory);

        String worldFileName = "../../worlds/Mundo_1.wbt";

        // Comprobar si Webots ya está arrancado
        boolean isWebotsRunning = !available(1234);
        if (isWebotsRunning == false) {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec("webots --stdout " + worldFileName);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int TIME_STEP = 32;
        robot = new SimpleVehicle(TIME_STEP);

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