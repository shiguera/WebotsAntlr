package EjemploAntlr_Log;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleLogLexer lexer = new SimpleLogLexer(CharStreams.fromFileName("test.mu"));
        SimpleLogParser parser = new SimpleLogParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse(); // parse es el punto de entrada en la gramática
        MySimpleLogVisitor visitor = new MySimpleLogVisitor();
        visitor.visit(tree);
    }
}
