import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ControllerAntlr {
   static SimpleVehicle_0 robot;

   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());

      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the name of instructions file: ");
      String fileName = scanner.nextLine();
      System.out.println(fileName);

      int TIME_STEP = 32;
 
      robot = new SimpleVehicle_0(TIME_STEP);
      
      initParser(fileName);
           
   }

   static void initParser(String fileName) throws IOException {
      CharStream input = CharStreams.fromFileName(fileName);
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new WebotsMyListener(robot), tree);
   }
}