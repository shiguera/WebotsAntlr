package robolang_stddraw;

import main.Interprete;

public class InterpreteStdDraw {
    
    public static void main(String[] args) {
        StdDrawListener listener = new StdDrawListener();
        Interprete interprete = new Interprete(listener);
        try {
            interprete.ejecutaPrograma("instrucciones.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
