package EjemploAntlr_IFWHILE;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;

public class Main {
    public static void main(String[] args) throws Exception {
        // Deprecated: MuLexer lexer = new MuLexer(new ANTLRFileStream("test.mu"));
        MuLexer lexer = new MuLexer(CharStreams.fromFileName("test.mu"));
        MuParser parser = new MuParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
