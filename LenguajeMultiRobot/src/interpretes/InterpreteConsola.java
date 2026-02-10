package interpretes;

import java.io.IOException;

import consola.ConsolaListener;

public class InterpreteConsola {

    public static void main(String[] args) throws IOException{

        String programaFuente = "programa_1.rbl";
        if (args.length > 0) {
            programaFuente = args[0];
        }


        ConsolaListener listener = new ConsolaListener();
        Interprete interprete = new Interprete(listener);

        System.out.println("🚀 InterpreteConsola ejecutando: " + programaFuente);
        interprete.ejecutaPrograma(programaFuente);
    }
}
