package robolang_webots.controllers.robolang_controller;

import java.nio.file.Path;
import java.util.Scanner;

import lenguaje.Interprete;
import lenguaje.RoboLangBaseListener;


public class robolang_controller {
   
   private static Scanner scanner;
   public static void main(String[] args) throws Exception {

      Path workingDirectory = Path.of(System.getProperty("user.dir"));
      System.out.println("Working Directory = " + workingDirectory.toAbsolutePath());
      
      scanner = new Scanner(System.in);

      String fileName = readNombreFichero();
      RoboLangBaseListener listener = readRobot();      

      Interprete interprete = new Interprete(listener);
      interprete.ejecutaPrograma(fileName);
      
      scanner.close();
   }

   private static RoboLangBaseListener readRobot() {
      RoboLangBaseListener listener = null;
      
      System.out.println("\nOpciones de Robot");
      System.out.println("   1.- Robot Webots");
      System.out.println("   2.- Robot de consola");
      System.out.print("Su opción: ");
      int opcion = scanner.nextInt();
      switch (opcion) {
         case 1:
            listener = new AdaptadorWebots();
            break;
         case 2:
            //listener = new RobotConsolaListener();
            break;
         default:
            //listener = new RobotConsolaListener();
            break;
      }
      return listener;
   }   

   private static String readNombreFichero() {
      System.out.print("\nNombre del fichero con el código fuente: ");
      String fileName = scanner.nextLine();
      return fileName;
   }

}