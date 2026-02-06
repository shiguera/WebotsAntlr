import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.RobotBaseListener;
import parser.RobotLexer;
import parser.RobotParser;

public class Interprete {
	
	private RobotBaseListener listener;

	public Interprete(RobotBaseListener listener) {
		this.listener = listener;
	}

	/**
    * Ejecuta el programa cuyo código fuente está en el fichero de nombre
    * surceProgramFileName utilizando el listener.
    * @throws IOException Si no puede acceder al fichero fileName
    */
   public void ejecutaPrograma(String fileName) throws IOException {
      CharStream input = CharStreams.fromFileName(fileName);
      RobotLexer lexer = new RobotLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      RobotParser parser = new RobotParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, tree);
   }

}
