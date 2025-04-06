import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrExternalController {
   static SimpleVehicle robot;

   public static void main(String[] args) throws Exception {

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

      initParser();

   }

   private static void initParser() throws IOException {
      CharStream input = CharStreams.fromFileName("../instrucciones.txt");
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new WebotsMyListener(robot), tree);
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