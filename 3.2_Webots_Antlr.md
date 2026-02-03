# Webots + ANTLR

El proyecto `HelloWebotsAntlr` tiene un controlador básico llamado `ControllerAntlr`que muestra como utilizar un lenguaje desarrollado en ANTLR para manejar un robot de Webots. En el directorio `controllers` del proyecto están todas las clases Java necesarias. El esquema es el siguiente:

- **Gramática:** el fichero `Webots.g4` es la gramática del lenguaje. Es un lenguaje simple que solo tiene dos instrucciones: `AVANZA`y `GIRA`. Esta gramática hay que compilarla con ANTLR para generar el lexer, el parser y el listener.

      Para compilar la gramática, habra que hacer:

```shell
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar 
    org.antlr.v4.Tool 
    Webots.g4
```

En la instrucción de compilación anterior, el parámetro `-cp` tendrá que indicar la ruta a la librería ANTLR y, si se trabaja en Windows, las rutas hay que separarlas con punto y coma en vez de usar dos puntos.

Al compilar la gramática se crearán clases para el lexer (`WebotsLexer.java`), para el parser (`WebotsParser.java`) y para el listener (`WebotsListener.java`. Además, se crea una clase base abstracta, `WebotsBaseListener.java`, que es de la que derivaremos nuestro listener y en la que sobrescribiremos los métodos que consideremos. 

- **Listener:** en nuestro caso, hemos derivado la clase `WebotsMyListener.java`y hemos sobrescrito los métodos *enterAvanza()* y *enterGira()*, que permitirán actuar cuando se interpreten las instrucciones `AVANZA` y `GIRA` cuando se interprete el código fuente de nuestro lenguaje.

      Esta clase utiliza una instancia del robot `SimpleVehicle_1` , que es a la que le manda la interpretación de las instrucciones `AVANZA` y `GIRA`.

- **Controlador:** el controlador Webots está en la clase `ControllerAntlr.java`. Esta clase utiliza una instancia del robot `SimpleVehicle_1` y se encarga de:
  
  - Inicializar la variable del entorno Webots `TIME_STEP`, que fija el intervalo de reproducción de la simulación.
  
  - Inicializar el robot *SimpleVehicle_1*.
  
  -  leer el fichero con el código fuente de nuestro lenguaje, inicializar y ejecutar el lexer, el parser y el listener del lenguaje. Al listener, le pasa la instancia del robot. 



 y una clase base abstracta para el listener (`)

En el directorio del controlador hay que crear un fichero `runtime.ini`poniendo el path a la librería de ANTLR. La ruta debe ser absoluta.

```shell
[environment variables with paths]
CLASSPATH = /home/shiguera/ownCloud/AAA_Teleco/2024-25/3_TFG/
    ws/TestWebotsLanguage/libraries/antlr-4.13.1-complete.jar
```

El listener tiene que recibir una referencia al robot que se va a mover. Los métodos del listener llamarán a métodos del robot.

```java
import grammar.WebotsBaseListener;
import grammar.WebotsParser.SetVelocidadContext;


public class MyListener extends WebotsBaseListener {

    static SimpleVehicle robot;

    public MyListener(SimpleVehicle robot) {
        MyListener.robot = robot;
    }

    @Override
    public void enterSetVelocidad(SetVelocidadContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("Velocidad: " + v);
        robot.setVelocity(v);
    }
}
```

El controlador deberá arrancar el walker para leer el fichero con las instrucciones:

```java
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.WebotsLexer;
import grammar.WebotsParser;

public class SimpleController {
   static SimpleVehicle robot;

   public static void main(String[] args) throws Exception {
      // Con valores menores dde 32 he tenido errores 
      // que no conseguía comprender
      int TIME_STEP = 32;
      robot = new SimpleVehicle(TIME_STEP);

      initParser();

      //while (robot.step(TIME_STEP) != -1);  
   }
   static void initParser() throws IOException {
      CharStream input = CharStreams.fromFileName("instrucciones.txt");
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new MyListener(robot), tree);
   }
   static void printAngle() {
      System.out.println(robot.getBearingInDegrees());
   }
}
```

La estructura de ficheros:

![](/home/shiguera/ownCloud/Apuntes/img/tree_1.png)

Para crear el lexer y el parser, situado en el directorio `grammar`:

```shell
$> antlr Webots.g4
$> javac -cp .:/usr/local/webots/lib/controller/java/Controller.jar:
      /usr/local/lib/antlr-4.13.2-complete.jar *.java
```

Para compilar el Listener, que está en el directorio del controller:

```shell
$> javac -cp .:/usr/local/webots/lib/controller/java/Controller.jar:
      /usr/local/lib/antlr-4.13.2-complete.jar *.java
```

Para ejecutar el `TestRawListener`que he creado para pruebas, hay que situarse en el directorio del controller e invocar la ejecución con `grammar.TestRawListener`.
