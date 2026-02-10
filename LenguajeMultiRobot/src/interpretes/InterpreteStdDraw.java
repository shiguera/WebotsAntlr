package interpretes;

import java.io.IOException;
import stddraw.StdDrawListener;

public class InterpreteStdDraw {

    public static void main(String[] args) throws IOException {

        String programaFuente = "programa_1.rbl";
        if (args.length == 1) {
            programaFuente = new String(args[0]);
        }

        StdDrawListener listener = new StdDrawListener();
        Interprete interprete = new Interprete(listener);

        System.out.println("🚀 InterpreteStdDraw ejecutando: " + programaFuente);
        interprete.ejecutaPrograma(programaFuente);
    }
}
