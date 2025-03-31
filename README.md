# HelloWebotsAntlr

## Controlador en lenguaje Java

**Paso 1:** en Webots, `File->New->New project directory`. En nuestro caso, hemos elegido de nombre `HelloWebotsAntlr`. En el diálogo que aparece, hemos elegido como nombre del mundo `MiniMundo` y hemos activado la opción `Add a rectangle arena`.

En Webots, se abrirá el mundo recién creado. La imagen será similar a la siguiente:

![](/home/shiguera/ownCloud/Apuntes/img/webots_1.png)

Webots ha creado el directorio de nuestro proyecto y, dentro de él, las carpetas que necesita un proyecto Webots, según la siguiente estructura:

![](/home/shiguera/ownCloud/Apuntes/img/tree_2.png)

El único fichero que se crea es `MiniMundo.wbt`, que es el fichero del mundo recién creado. Su contenido es el siguiente:

```shell
#VRML_SIM R2025a utf8
EXTERNPROTO "https://raw.githubusercontent.com/cyberbotics/webots/
   R2025a/projects/objects/backgrounds/protos/TexturedBackground.proto"
EXTERNPROTO "https://raw.githubusercontent.com/cyberbotics/webots/
   R2025a/projects/objects/backgrounds/protos/TexturedBackgroundLight.proto"
EXTERNPROTO "https://raw.githubusercontent.com/cyberbotics/webots/
   R2025a/projects/objects/floors/protos/RectangleArena.proto"
WorldInfo {
}
Viewpoint {
  orientation -0.5773 0.5773 0.5773 2.0944
  position 0 0 10
}
TexturedBackground {
}
TexturedBackgroundLight {
}
RectangleArena {
}
```

Como se ve, el fichero consta de la línea inicial obligatoria para declarar la versión del fichero `.wbt`, tres declaraciones de importación de prototipos desde la dirección web de Webots y los cinco nodos que componen el proyecto inicialmente: *WorldInfo*, *ViewPoint*, *TexturedBackground*, *TexturedBackgroundLight* y *RectangleArena*. Inicialmente, solo el nodo *ViewPoint* tiene atributos para fijar el punto de vista inicial del mundo, en este caso, una vista cenital (desde arriba).

Vamos a aumentar un poco el tamaño del rectángulo arena. Para ello, abre el nodo correspondiente en el árbol de la escena y modifica los valores de la propiedad `floorsize`, poniendo por ejemplo `10 10`. También puedes modificar el aspecto del rectángulo actuando sobre la propiedad `foorAppearance->type` y elegir, por ejemplo, `light strip`, que permitirá que se vea un poco más el Robot sobre el suelo. Tras hacer estas modificaciones debes pulsar el botón `Guardar`para que queden grabadas en el fichero del disco.

**Paso 2:** ahora, vamos a añadir un robot a la escena. Se trata de un robot sencillo creado por nosotros. Para ello, abre el fichero `MiniMundo.wbt` con el editor de texto y copia y pega al final del fichero el siguiente código (el código lo tienes en el fichero `robot.txt`):

```shell
Robot {
  translation 0 0 0.05
  rotation 0 0 1 1.5708
  children [
    GPS {
      translation -0.05 0 0.03
      children [
        Shape {
          appearance PBRAppearance {
            baseColor 0.109804 0.443137 0.847059
            roughness 1
            metalness 0.5
          }
          geometry Box {
            size 0.02 0.02 0.01
          }
        }
      ]
    }
    Compass {
      translation 0.05 0 0.03
      children [
        Shape {
          appearance PBRAppearance {
            baseColor 0.964706 0.827451 0.176471
            roughness 1
            metalness 0
          }
          geometry Cylinder {
            height 0.01
            radius 0.025
          }
        }
      ]
    }
    Pen {
      translation 0 0 0.01
      children [
        Shape {
          appearance PBRAppearance {
          }
          geometry Cylinder {
            height 0.1
            radius 0.015
          }
        }
      ]
      inkColor 0 0 1
      inkDensity 1
      leadSize 0.02
    }
    DEF BODY Shape {
      appearance PBRAppearance {
        baseColor 0.388235 0.270588 0.172549
        roughness 1
        metalness 0
      }
      geometry Box {
        size 0.2 0.1 0.05
      }
    }
    DEF WHEEL1 HingeJoint {
      jointParameters HingeJointParameters {
        axis 0 1 0
        anchor 0.05 0.06 0
      }
      device [
        RotationalMotor {
          name "ruedaDelanteraIzquierda"
        }
      ]
      endPoint Solid {
        translation 0.05 0.06 0
        rotation 1 0 0 1.5708
        children [
          DEF WHEEL Shape {
            appearance PBRAppearance {
              baseColor 0 0 0
              roughness 1
              metalness 0
            }
            geometry Cylinder {
              height 0.02
              radius 0.04
              subdivision 24
            }
          }
        ]
        boundingObject USE WHEEL
        physics Physics {
        }
      }
    }
    DEF WHEEL2 HingeJoint {
      jointParameters HingeJointParameters {
        axis 0 1 0
        anchor 0.05 -0.06 0
      }
      device [
        RotationalMotor {
          name "ruedaDelanteraDerecha"
        }
      ]
      endPoint Solid {
        translation 0.05 -0.06 0
        rotation 1 0 0 1.5708
        children [
          USE WHEEL
        ]
        name "solid(1)"
        boundingObject USE WHEEL
        physics Physics {
        }
      }
    }
    DEF WHEEL3 HingeJoint {
      jointParameters HingeJointParameters {
        axis 0 1 0
        anchor -0.05 0.06 0
      }
      device [
        RotationalMotor {
          name "ruedaTraseraIzquierda"
        }
      ]
      endPoint Solid {
        translation -0.05 0.06 0
        rotation 1 0 0 1.5708
        children [
          USE WHEEL
        ]
        name "solid(2)"
        boundingObject USE WHEEL
        physics Physics {
        }
      }
    }
    DEF WHEEL4 HingeJoint {
      jointParameters HingeJointParameters {
        axis 0 1 0
        anchor -0.05 -0.06 0
      }
      device [
        RotationalMotor {
          name "ruedaTraseraDerecha"
        }
      ]
      endPoint Solid {
        translation -0.05 -0.06 0
        rotation 1 0 0 1.5708
        children [
          USE WHEEL
        ]
        name "solid(3)"
        boundingObject USE WHEEL
        physics Physics {
        }
      }
    }
    DEF DS_RIGHT DistanceSensor {
      translation 0.1 -0.03 0
      rotation 0 0 1 -0.3
      children [
        Shape {
          appearance PBRAppearance {
            baseColor 0.184314 0.596078 0.847059
            roughness 1
            metalness 0
          }
          geometry Box {
            size 0.01 0.01 0.01
          }
        }
      ]
      name "ds_right"
    }
    DEF DS_LEFT DistanceSensor {
      translation 0.1 0.03 0
      rotation 0 0 1 0.3
      children [
        Shape {
          appearance PBRAppearance {
            baseColor 0.184314 0.596078 0.847059
            roughness 1
            metalness 0
          }
          geometry Box {
            size 0.01 0.01 0.01
          }
        }
      ]
      name "ds_left"
    }
  ]
  boundingObject USE BODY
  physics Physics {
    density -1
    mass 1
  }
  controller "SimpleController"
}

```

Esto añade un nodo `Robot`a nuestro mundo. Se trata de un Robot dotado de cuatro ruedas, con sus correspondientes motores, dos sensores de distancia situados en la parte delantera,  un GPS, una brújula y un lápiz. El GPS nos va a hacer falta para poder medir las distancias recorridas por el Robot y la brújula (*Compass*) permitirá medir los ángulos girados por el Robot.

Una vez que modifiques el fichero `wbt`, para ver los cambios en Webots, tendrás que volver a abrir el mundo con `File->Open World`.

Se marcarán unos errores en la consola de la parte inferior, indicando que no se encuentra el controlador `SimpleController`. Si observas la última línea del código anterior, verás que pone `controller: SimpleController`. Lo que hace Webots es buscar una clase java compilada llamada `SimpleController.class`dentro del directorio `controllers/SimpleController`del proyecto. 

Vamos a dividir el controlador del robot en dos clases Java: la clase `SimpleVehicle`contiene toda la lógica que permite manejar el Robot y la clase `SimpleController`será el controlador propiamente dicho.

Copia el código del fichero `SimpleVehicle.java`dentro del directorio `controllers/SimpleController` del proyecto. Echa un vistazo al código: `SimpleVehicle`deriva de la clase `Robot`de Webots y añade propiedades y métodos para manejar el Robot. 

Ahora, copia el código del fichero `SimpleController.java` dentro de ese mismo directorio. El código de nuestro controlador es el siguiente:

```java
public class SimpleController {
   static SimpleVehicle robot;

   public static void main(String[] args) {

      int TIME_STEP = 32;
      
      robot = new SimpleVehicle(TIME_STEP);
      
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
      robot.pivotAngle(45.0);
      robot.moveForward(0.8, 1);
   }
}
```

Como ves, lo único que hace el controlador es crear un robot del tipo `SimpleVehicle` y enviarle instrucciones.

Tienes que compilar las dos clases `.java`que hemos copiado en el directorio `controllers/SimpleController` del proyecto. Lo puedes hacer de dos maneras: por consola o desde tu editor (VSCode, IntelliJ,...). En ambos casos vas a necesitar utilizar la librería `Controller.jar`que proporciona Webots (En mi instalación, está en el directorio `webots/controller/java`). La vamos a copiar en el directorio `libraries`del proyecto, para que sea más fácil teclear la ruta en la consola al compilar.

 Para compilar por consola, tienes que abrir un terminal situado en el directorio `controller/SimpleController`del proyecto (Recueda que para abrir un terminal en un directorio determinado, puedes navegar hasta él con el explorador de archivos, pinchar con el botón derecho del ratón y elegir *abrir en terminal*). Tendrás que teclear la siguiente instrucción:

```shell
javac -cp .:../../libraries/Controller.jar *.java
```

**Nota:** Si estás en Windows, es posible que tengas que utilizar la barra invertida `\` como separador de carpetas en la instrucción anterior.

Una vez compiladas las clases `SimpleVehicle` y `SimpleController` sin errores, prueba a recargar la simulación en Webots y deberías ver al robot moviéndose por el rectángulo, siguiendo las instrucciones que le hemos dado en el controlador.

**Nota:** con este tipo de suelo, no se ve el trazo que va dejando la pluma.

## Controlador en el nuestro lenguaje

Ahora, vamos a hacer lo mismo, pero dando al robot las instrucciones a través de un fichero escrito en nuestro propio lenguaje.

Crea un nuevo directorio dentro del directorio `controllers` del proyecto, llamado `ControladorAntlr` y copia dentro de él el fichero `SimpleVehicle.java`.

En lo que sigue, vamos a necesitar la librería de `antlr`. En mi caso es el fichero `antlr-4.13.2-complete.jar`. Copialo en el directorio *libraries* del proyecto.

**Paso 1:** crear la gramática del proyecto. Por facilidad, la vamos a crear en el mismo directorio del controlador. Crea un fichero llamado `Webots.g4` y copia el siguiente contenido dentro de él:

```shell
grammar Webots;

prog: statement+ ;
 
statement:  'AVANZA' '(' VALUE ',' VALUE ')' '\n' #Avanza
			| 'GIRA' '(' VALUE ')' '\n' #Gira
			;

VALUE:      INT
        |   FLOAT
        ;

INT : DIGIT+ ;
FLOAT : '-'? DIGIT+ '.' DIGIT*
		| '-'? '.' DIGIT+
		;
fragment DIGIT : [0-9] ;

WS : [ \t\n\r]+ -> skip ;

```

La gramática solo incluye dos posibles instrucciones: `AVANZA` y `GIRA`. La primera recibe dos parámetros (velocidad y distancia) y activará el método `moveForward` del `SimpleVehicle`. La segunda recibe un solo parámetro (ángulo) y activará el método `pivotAngle` del `SimpleVehicle`.

Ahora vamos a crear con *ANTLR* el lexer y el parser correspondientes a esta gramática. Para ello, abre un terminal en el directorio `controllers/ControllerAntlr` del proyecto, el directorio donde está la gramática y teclea la siguiente orden:

```shell
java -cp ../../libraries/antlr-4.13.2-complete.jar org.antlr.v4.Tool 
   Webots.g4
```

**Nota:** si estás trabajando con IntelliJ, esta instrucción equivale a activar la opción `Generate Antlr recognizer`del menú que aparece al pinchar con el botón derecho del ratón sobre el fichero de la gramática.

Si todo ha ido bien, se crearán varios ficheros. Los que nos interesan son los ficheros `.java`y, en particular, el fichero `WebotsBaseListener.java`, que es del que derivaremos nuestra clase para interpretar el lenguaje.

Tenemos que compilar todos estos ficheros. Una vez más, necesitaremos usar la librería `antlr`. La instrucción para compilar es:

```shell
javac -cp .:../../libraries/antlr-4.13.2-complete.jar Webots*.java
```

**Nota 1:** en el parámetro `-cp` (*classpath*), que es donde va a buscar el compilador *javac* las clases,  hemos puesto dos rutas: el directorio actual (`.`) y la librería de *antlr*. En windows, el separador de estas rutas es `;`, en lugar de dos puntos y la separación de carpetas se hace con la barra invertida `\`.

**Nota 2:** si estás trabajando con IntelliJ, es posible que la compilación se haga automáticamente. 

Ahora vamos a crear nuestra clase intérprete del lenguaje. Crea un fichero llamado `WebotsMyListener.java`  y copia el siguiente código dentro de él:

```java
public class WebotsMyListener extends WebotsBaseListener {

    static SimpleVehicle robot;

    public WebotsMyListener(SimpleVehicle robot) {
        WebotsMyListener.robot = robot;
    }

    @Override
    public void enterAvanza(WebotsParser.AvanzaContext ctx) {
        double v = Double.parseDouble(ctx.VALUE().get(0).getText());
        double d = Double.parseDouble(ctx.VALUE().get(1).getText());
        System.out.println("AVANZA("+v+", "+d+")");
        robot.moveForward(v, d);
    }
    @Override
    public void enterGira(WebotsParser.GiraContext ctx) {
        double angle = Double.parseDouble(ctx.VALUE().getText());
        System.out.println("GIRA "+angle);
        robot.pivotAngle(angle);
    }
}
```

Para compilar, tendremos que utilizar las dos librerías: la de *antlr* y la de *webots*. La instrucción de consola es la siguiente:

```shell
javac -cp .:../../libraries/antlr-4.13.2-complete.jar:
   ../../libraries/Controller.jar 
   WebotsMyListener.java
```

Si estás trabajando con IntelliJ, para que compile, deberás decirle que use la librería de *webots Controller.jar*, además de la de *antlr*.

Ahora vamos a crear el controlador. Crea el fichero `ControllerAntlr.java` y copia el siguiente contenido dentro de él:

```java
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ControllerAntlr {
   static SimpleVehicle robot;

   public static void main(String[] args) throws Exception {

      int TIME_STEP = 32;
 
      robot = new SimpleVehicle(TIME_STEP);
      
      initParser();
           
   }

   static void initParser() throws IOException {
      CharStream input = CharStreams.fromFileName("instrucciones.txt");
      WebotsLexer lexer = new WebotsLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      WebotsParser parser = new WebotsParser(tokens);
      ParseTree tree = parser.prog();
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new WebotsMyListener(robot), tree);
   }
}
```

Tienes que compilar la clase del controlador:

```shell
javac -cp .:../../libraries/antlr-4.13.2-complete.jar:
    ../../libraries/Controller.jar 
    ControllerAntlr.java
```

Solo queda un paso: hay que decirle a Webots donde encontrar la librería de *antlr*. Para ello, crea un fichero llamado `runtime.ini` dentro del directorio `ControllerAntlr` del controlador y copia el siguiente contenido:

```shell
[environment variables with paths]
CLASSPATH = /home/shiguera/ownCloud/AAA_Teleco/2024-25/3_TFG/ws/
    HelloWebotsAntlr/libraries/antlr-4.13.2-complete.jar
```

La ruta del código anterior es la que corresponde a mi instalación. En tu caso, tendrás que poner la ruta completa a tu librería *antlr*.

Hay que crear el fichero `instrucciones.txt` con la intrucciones que queremos que realice el robot. En mi caso, he rerpoducido las intrucciones del ejemplo del `SimpleController`:

```shell
AVANZA(0.8, 1)
GIRA(45.0)
AVANZA(0.8, 1)
GIRA(45.0)
AVANZA(0.8, 1)
```

Ahora, en Webots, hay que cambiar el controlador del robot y decirle que use `ControllerAntlr`. Si todo ha ido bien, el robot se debería mover como antes pero, esta vez, siguiendo las instrucciones del fichero `instrucciones.txt`.








