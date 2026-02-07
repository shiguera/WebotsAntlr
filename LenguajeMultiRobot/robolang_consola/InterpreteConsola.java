package robolang_consola;

import main.Interprete;

public class InterpreteConsola {
    public static void main(String[] args) {
        ConsolaListener listener = new ConsolaListener();
        Interprete interprete = new Interprete(listener);
        try {
            interprete.ejecutaPrograma("instrucciones.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
