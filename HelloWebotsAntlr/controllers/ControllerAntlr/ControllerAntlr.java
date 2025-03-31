import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ControllerAntlr {
   static SimpleVehicle robot;

   public static void main(String[] args) throws Exception {

      int TIME_STEP = 32;
 
      robot = new SimpleVehicle(TIME_STEP);
      
      initParser();
           
   }

   static void initParser() throws IOException {
      CharStream input = CharStreams.fromFileName("instrucciones.txt");
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new WebotsMyListener(robot), tree);
   }
}