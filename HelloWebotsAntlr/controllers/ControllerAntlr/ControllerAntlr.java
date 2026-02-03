import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ControllerAntlr {
   static SimpleVehicle_1 robot;

   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());

      String fileName = "instrucciones.txt";
      
      int TIME_STEP = 32;
 
      robot = new SimpleVehicle_1(TIME_STEP);
      
      ejecutaPrograma(fileName);
           
   }

   /**
    * Ejecuta el programa cuyo código fuente está en el fichero de nombre
    * fileName.
    * @param fileName Nombre del fichero con el código fuente a ejecutar
    * @throws IOException Si no puede acceder al fichero fileName
    */
   static void ejecutaPrograma(String fileName) throws IOException {
      CharStream input = CharStreams.fromFileName(fileName);
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new WebotsMyListener(robot), tree);
   }
}