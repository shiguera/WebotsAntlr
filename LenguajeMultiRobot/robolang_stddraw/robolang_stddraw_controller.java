package robolang_stddraw;

import main.Interprete;

public class robolang_stddraw_controller {
    
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
