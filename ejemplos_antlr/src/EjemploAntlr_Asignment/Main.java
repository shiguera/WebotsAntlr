package EjemploAntlr_Asignment;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;

public class Main {
    public static void main(String[] args) throws Exception {
        // Deprecated: MuLexer lexer = new MuLexer(new ANTLRFileStream("test_asignment.mu"));
        SimpleAsignmentLexer lexer = new SimpleAsignmentLexer(CharStreams.fromFileName("test_asignment.mu"));
        AsignmentParser parser = new AsignmentParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        MyAsignmentVisitor visitor = new MyAsignmentVisitor();
        visitor.visit(tree);
    }
}
