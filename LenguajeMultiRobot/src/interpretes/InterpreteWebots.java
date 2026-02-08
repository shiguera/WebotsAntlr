package interpretes;

import lenguaje.RoboLangBaseListener;
import robolang_webots.WebotsListener;

public class InterpreteWebots {

   public static void main(String[] args) throws Exception {

      String programaFuente = "programa_1.rbl";
      if (args.length == 1) {
         programaFuente = new String(args[0]);
      }

      RoboLangBaseListener listener = new WebotsListener();
      Interprete interprete = new Interprete(listener);

      System.out.println("🚀 InterpreteWebots ejecutando: " + programaFuente);
      interprete.ejecutaPrograma(programaFuente);
   }

}