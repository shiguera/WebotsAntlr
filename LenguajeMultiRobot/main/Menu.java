package main;

import java.nio.file.Path;
import java.util.Scanner;

import lenguaje.RoboLangBaseListener;
import robolang_stddraw.StdDrawListener;
import robolang_webots.controllers.robolang_webots_controller.WebotsListener;


public class Menu {
   
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
      System.out.println("   2.- Robot StdDraw");
      System.out.print("Su opción: ");
      int opcion = scanner.nextInt();
      switch (opcion) {
         case 1:
            listener = new WebotsListener();
            break;
         case 2:
            listener = new StdDrawListener();
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