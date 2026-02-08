package interpretes;

import java.nio.file.Path;

import lenguaje.RoboLangBaseListener;
import robolang_webots.WebotsListener;


public class InterpreteWebots {
   
   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());
      
      String fileName = "instrucciones.txt";
      RoboLangBaseListener listener = new WebotsListener();      

      Interprete interprete = new Interprete(listener);
      interprete.ejecutaPrograma(fileName);     
   }


}