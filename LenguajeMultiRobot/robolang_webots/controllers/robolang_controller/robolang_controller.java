package robolang_webots.controllers.robolang_controller;

import java.nio.file.Path;
import lenguaje.Interprete;
import lenguaje.RoboLangBaseListener;


public class robolang_controller {
   
   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());
      
      String fileName = "instrucciones.txt";
      RoboLangBaseListener listener = new AdaptadorWebots();      

      Interprete interprete = new Interprete(listener);
      interprete.ejecutaPrograma(fileName);     
   }


}