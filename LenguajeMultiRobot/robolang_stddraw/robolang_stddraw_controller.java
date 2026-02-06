package robolang_stddraw;

import lenguaje.Interprete;

public class robolang_stddraw_controller {
    
    public static void main(String[] args) {
        AdaptadorStdDraw adapter = new AdaptadorStdDraw();
        Interprete interprete = new Interprete(adapter);
        try {
            interprete.ejecutaPrograma("instrucciones.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
