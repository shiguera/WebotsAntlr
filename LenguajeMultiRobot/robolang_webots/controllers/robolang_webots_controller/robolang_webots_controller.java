package robolang_webots.controllers.robolang_webots_controller;

import java.nio.file.Path;

import lenguaje.RoboLangBaseListener;
import main.Interprete;


public class robolang_webots_controller {
   
   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());
      
      String fileName = "instrucciones.txt";
      RoboLangBaseListener listener = new WebotsListener();      

      Interprete interprete = new Interprete(listener);
      interprete.ejecutaPrograma(fileName);     
   }


}