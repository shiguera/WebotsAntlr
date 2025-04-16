import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrCompleteLanguage {
    static SimpleVehicle_4 robot;

    public static void main(String[] args) throws Exception {

        Path workingDirectory = Path.of(System.getProperty("user.dir"));
        System.out.println(workingDirectory);

        String worldFileName = "../../worlds/Mundo_1.wbt";

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

        robot = new SimpleVehicle_4(TIME_STEP);
        

        initParser();

    }

    private static void initParser() throws IOException {
        CompleteLexer lexer = new CompleteLexer(CharStreams.fromFileName("../test_complete.txt"));
        CompleteParser parser = new CompleteParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        MyCompleteVisitor visitor = new MyCompleteVisitor(AntlrCompleteLanguage.robot);
        visitor.visit(tree);
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