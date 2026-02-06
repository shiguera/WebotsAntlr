package main;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import lenguaje.RoboLangBaseListener;
import lenguaje.RoboLangLexer;
import lenguaje.RoboLangParser;


public class Interprete {
	
	private RoboLangBaseListener listener;

	public Interprete(RoboLangBaseListener listener) {
		this.listener = listener;
	}

	/**
    * Ejecuta el programa cuyo código fuente está en el fichero de nombre
    * fileName utilizando el listener.
    * @throws IOException Si no puede acceder al fichero fileName
    */
   public void ejecutaPrograma(String fileName) throws IOException {
      CharStream input = CharStreams.fromFileName(fileName);
      RoboLangLexer lexer = new RoboLangLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      RoboLangParser parser = new RoboLangParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, tree);
   }

}
