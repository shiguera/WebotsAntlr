# Webots

[Página Web - Cyberbotics: Robotics simulation with Webots](https://cyberbotics.com/#cyberbotics)

[User Guide](https://cyberbotics.com/doc/guide/index)

[Reference manual](https://cyberbotics.com/doc/reference/index)

[GitHub - cyberbotics/webots: Webots Robot Simulator](https://github.com/cyberbotics/webots)

[Para compilar los fuentes de Webots: Home · cyberbotics/webots Wiki · GitHub](https://github.com/cyberbotics/webots/wiki)

En Linux, Webots está instalado en: 

`/usr/local/webots`

He clonado el repo de código fuente en el Titan, en `~/webots`.

Ahí hay ficheros fuente y ejemplos.

[ODE: Open Dynamic Engine](http://ode.org/wiki/index.php/Main_Page) Es la librería que usa Webots para definir el funcionamiento de los dispositivos.

### Compilar controladores escritos en java

Hay que dar path a la librería `Controller.jar`. En Linux está situada en:

```shell
/usr/local/webots/lib/controller/java/Controller.jar
```

### Using Controller Arguments

In the ".wbt" file, it is possible to specify arguments that are passed to a controller when it starts. They are specified in the `controllerArgs` field of the [Robot](https://cyberbotics.com/doc/reference/robot) node, and they are passed as parameters of the `main` function. For example, this can be used to specify parameters that vary for each robot's controller. 

For example:

```
Robot {
  ...
  controllerArgs "one two three"
  ...
}
```

### Redirigir la salida a la consola standar

Al arrancar, hay que pasar el parámetro `--stdout`

**No se pueden hacer entradas desde la consola.**

## Compilar controladores

En la orden `javac` hay que fijar el parámetro class path `-cp` apuntando al directorio donde estén las clases Java que queremos compilar y el directorio donde esté la biblioteca `Controller.jar`.

Por ejemplo:

```shell
javac -cp /usr/local/webots/lib/controller/java/Controller.jar *.java
```

Si ell controlador utiliza una biblioteca externa, como ANTLR, habrá que incluir también en el patrámetro class path la ruta del fichero `.jar` de la biblioteca:

Por ejemplo:

```shell
javac -cp /usr/local/webots/lib/controller/java/Controller.jar
      :/usr/local/lib/antlr-4.13.2-complete.jar 
      *.java
```

## Ejecutar controladores

En principio, tenemos dos maneras de ejecutar los controladores:

- **Controlador interno:** el fichero `.class` debe estar en una carpeta con el mismo nombre que la clase controlador, dentro de la carpeta `controllers` del proyecto Webots. Hay que indicar el nombre del controlador en el nodo `controller` del robot.

- **Controlador externo:** en el nodo `controller`  del robot se establece `<extern>`. Hay que ejecutar el controlador con la máquina virtual de Java, siguiendo las indicaciones que se dan a continuación y, al arrancar la simulación en Webots, el robot usará el controlador que se ha arrancado.

---

## Controladores arrancados desde Webots

**Caso 1:** Un controlador sencillo que solo usa clases de Webots. 

- Para compilar, hay que poner la librería `Controller.jar` en el `classpath` de la compilación. Los ficheros `.class` tienen que estar en el directorio `controllers` de la simulación que utilicemos

```bash
javac -cp /usr/local/webots/lib/controller/java/Controller.jar *.java
```

- Para ejecutar, el controlador hay que designarlo en la propiedad `controller` del nodo `Robot` del fichero mundo que estemos utilizando.

*Ejemplo en: `WebotsAntlr/HelloWebotsAntlr/controllers/SimpleController`*

**Caso 2:** El controlador utiliza clases de una liibrería externa, en nuestro caso, ANTLR.

- Para compilar, hay que indicar en el `classpath` las rutas de `Controller.jar` y `antlr.jar`. El `controller.class` hay que crearlo en el directorio `controllers` de la simulación que estemos utilizando.

```bash
javac -cp /usr/local/webots/lib/controller/java/Controller.jar
      :/usr/local/lib/antlr-4.13.2-complete.jar 
      *.java
```

- Para ejecutar:
  
  - Hay que crear un fichero `runtime.ini`, en el directorio del controlador, indicando la ruta de la librería:
    
    ```bash
    [environment variables with paths]
      CLASSPATH = ../../libraries/antlr-4.13.2-complete.jar
    ```
  
  - Para ejecutar, el controlador hay que designarlo en la propiedad `controller` del nodo `Robot` del fichero mundo que estemos utilizando.

> **Nota:** en el fichero `runtime.ini` que se pone en el directorio del controlador:
> 
> - CLASSPATH: la librería que se ponga la añade Webots al parámetro `classpath` de la orden de ejecución `java`.
> 
> - JAVA_LIBRARY_PATH: la librería que se indique, la añade Webots al parámetro `-Djava.library.path` de la orden de ejecución `java`.

## Controladores externos

[# Running Extern Robot Controllers](https://www.cyberbotics.com/doc/guide/running-extern-robot-controllers?)

- **Caso 1: controlador solo con clases Webots.** 
  
  - Para compilar: igual que si fuera un controlador interno: hay que poner en el `classpath` la ruta a la librería `Controller.jar`.
  
  - Para ejecutar hay dos procedimientos:
    
    - Mediante el arrancador `webots-controller`: hay que pasarle el `.class`del controlador:
    
    ```bash
    /usr/local/webots/webots-controller BasicExternalController.class
    ```
    
    - Desde el terminal: hay que poner el path a la libraría `Controller.jar`en la orden de ejecución. Además, hay que fijar el parámetro `-Djava.library.path` apuntando al directorio en el que está la librería `Controller.jar`: `$webots_HOME/lib/controller/java`; También hay que poner la variable de sistema `LD_LIBRARY_PATH` apuntando a las librerías compartidas de C: `$WEBOTS_HOME/lib/controller/`.
    
    ```bash
    java -cp .:/usr/local/webots/lib/controller/java/Controller.jar 
         -Djava.library.path=/usr/local/webots/lib/controller/java
         BasicExternalController
    ```
  
  > Nota: en Windows, en vez de la variable `LD_LLIBRARY_PATH` hay que usar la variable `PATH`.

- **Caso 2: controlador con librería externa.** En este caso vamos a usar la librería `antlr`. 
  
  - Para compilar: hay que poner en el `classpath` la librería `Controller.jar` y la librería `antlr.jar`.
  
  - Para ejecutar: en la orden `java`hay que apuntar el `classpath` a las librerías `Controller.jar` y `antlr.jar`; Además, hay que fijar el parámetro `-Djava.library.path` apuntando a los directorios en los que están las mismas librerías; también hay que poner la variable de sistema `LD_LIBRARY_PATH` apuntando a las librerías compartidas de C: `$WEBOTS_HOME/lib/controller/`.
  
  ```bash
  java -cp .:/usr/local/webots/lib/controller/java/Controller.jar
         :/usr/local/lib/antlr-4.13.2-complete.jar 
       -Djava.library.path=/usr/local/webots/lib/controller/java
         :/usr/local/lib 
       AntlrExternalController
  ```

- **Caso 3: Arrancar varios robots:**
  Cuando hay varios robots con el controlador fijado en `<extern>`, hay que arrancar todos, si no, Webots se queda esperando.
  
  El parámetro `--robot-name` que utiliza el lanzador `webots-controller` de Webots, se fija en la variable de entrono `WEBOTS_CONTROLLER_URL`. Hay que darle valor antes de cada comando `java`para ejecutar un controlador:
  
  ```bash
  export WEBOTS_CONTROLLER_URL="robot_1"
  java -cp...
  export WEBOTS_CONTROLLER_URL="robot_2"
  java -cp...
  ```
  
  El formato completo de la variable de entorno:
  
  ```bash
  export WEBOTS_CONTROLLER_URL=ipc://1234/robot_1
  ```
  
  donde `ipc` es el protocolo, `1234` es el puerto y `robot_1` el nombre del robot.

- **Caso 4:** controlador con librería externa, arranque con `webots-controller`. Hay que poner un fichero `runtime.ini` dando valor a las variables `CLASSPATH` y `JAVA_LIBRARY_PATH`. 
  
  ```bash
  [environment variables with paths]
     CLASSPATH = .:/usr/local/webots/lib/controller/java/Controller.jar
        :../../libraries/antlr-4.13.2-complete.jar
     JAVA_LIBRARY_PATH = /usr/local/webots/lib/controller/java/
        :/usr/local/lib
  ```
  
  Aún así, no he conseguido que funcione, salvo que descomprimna la libraría `antlr`en el directorio del controlador. He probado a compilar y modificar el código fuente del lanzador, pero no lo he conseguido aún.
  
  El objetivo es poder arrancar varios robots con distinto nombre. Una idea la he encontrado en: [Cyberbotics: doc](https://www.cyberbotics.com/doc/guide/running-extern-robot-controllers?version=R2019b-rev1#!), pero debe de estar obsoleto en la versión actual de Webots.

### Utilizar librerías jar externas en el controlador

Además de usarlas en el classpath de la orden de compilación, hay que crear un fichero llamado `runtime.ini` en el directorio del controlador y ahí estabecer la ruta a la librería:

```shell
[environment variables with paths]
CLASSPATH = /home/shiguera/ownCloud/AAA_Teleco/2024-25/3_TFG/ws/
    HelloWebotsAntlr/libraries/antlr-4.13.2-complete.jar
```

[java - How to add external jars to Webots? - Stack Overflow](https://stackoverflow.com/questions/62022335/how-to-add-external-jars-to-webots)

[Cyberbotics: doc](https://cyberbotics.com/doc/guide/controller-programming#languages-settings)

### Arrancar con un controlador externo

Para arrancar el controlador externo desde la consola, en Linux:

- **Al compilar:** hay que dar el path a la librería externa y a la librería `Controller.jar` de Webots:
  
  ```bash
  javac 
     -cp /usr/local/lib/antlr-4.13.2-complete.jar
       :/usr/local/webots/lib/controller/java/Controller.jar 
     -d ../../controllers/SupervisorController 
     *.java
  ```

- **Al ejecutar:** además de dar path a las librerías, hay que establecer la variable `LD_LIBRARY_PATH` al directorio de los controladores de Webots y usar la directiva de compilación `-Djava.library.path` apuntando a las librarías java:
  
  ```bash
  export LD_LIBRARY_PATH=/usr/local/webots/lib/controller
  java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar
            :/usr/local/webots/lib/controller/java/Controller.jar 
       -Djava.library.path="/usr/local/webots/lib/controller/java" 
       SupervisorController
  ```

También se puede arrancar el controlador externo con el arrancador `webots-controller`  que proporciona Webots, invovcando la clase del controlador:

```shell
/usr/local/webots/webots-controller bin/BasicExternalController.class
```

Pero, cuando se enlaza con con una librería `.jar`externa, no me encuentra la ruta. Por ejemplo, con `antlr`. Lo que he tenido que hacer es descomprimir la librería en el directorio del controlador y arrancarlo así.

Una de las ventajas de usar un controlador externo es que se puede usar la consola para hacer entradas del usuario.

## Arrancar un controlador externo de vehicle

```bash
export LD_LIBRARY_PATH=/usr/local/webots/lib/controller/
java -cp .:/usr/local/webots/lib/controller/java/Controller.jar
         :/usr/local/webots/lib/controller/java/vehicle.jar 
     -Djava.library.path=/usr/local/webots/lib/controller/java 
     MyController
```

## Arrancar en modo seguro

```shell
export WEBOTS_SAFE_MODE=true
webots
```

Se arranca con un mundo vacío

## Conceptos

**Webots simulation:**

- *World file (.wbt):* define uno o más robotts y su entorno. Pueden depender de ficheros PROTO externos y de ficheros de texturas.

- *Controladores:* uno o más ficheros con los controladores de los robots.

- Physics plugin:* (opcional) para modificar el comportamiento físico.

**World:**

La descripción 3D de las propiedades de los robots y de su entorno.  Se guarda en un fichero *.wbt* dentro del directorio *worlds* del proyecto. Para cada robot, guarda el nombre del controlador, pero no el controlador en sí mismo.

**Controller:**

Es un programa que controla a un robot específico. Se pueden escribir en cualquiera de los lenguajes admitidos: C, C++, Java, Python, MATLAB. 

Cuendo se inicia la simulación, Webots crea un proceso para cada controlador asociado a un robot. Un mismo controlador puede manejar más de un robot, pero Webots creará un proceso diferente para cada robot.

Los controladores se guardan en el directorio *controllers* del proyecto. Ahí estarán los ficheros fuente o los compilados.

> **Note** [Java]: In the Java case there are two options.  The controller can be placed in a "*.class*" file or in a "*.jar*" file.  If the controller name is "*xyz_controller*" and a "*.class*" file is used, it must be named "*xyz_controller.class*".  If a "*.jar*" file is used it must be named "*xyz_controller.jar*" and it  must contain a class named "*xyz_controller*" that Webots will attempts to  start.

**Supervisor Controller:**

Es el controlador de un Robot en el que el campo *supervisor* se ha puesto en *true*. Los controladores supervisores pueden realizar operaciones especiales: video captura, mover robots a posiciones aleatorias, control de la simulación y otras.

Algunas propiedades de algunos dispositivos no ofrecen funciones específicas que permitan modificar su valor. Si el robot es *Supervisor*, se pueden utilizar las funciones que ofrece para dar valor a campos concretos.

Por ejemplo,  el dispositivo *Pen* no dispone de una función para modificar el grueso de línea. Si el robot es *Supervisor*, se podría hacer así:

```c
    WbDeviceTag pen = wb_robot_get_device("pen");
    WbNodeRef pen_ref = wb_supervisor_node_get_from_device(pen);
    WbFieldRef pen_width = 
       wb_supervisor_node_get_field(pen_ref, "leadSize");
    wb_supervisor_field_set_sf_float(pen_width, 0.05);
```

**Scene Tree:**

Contiene la información necesaria para describir un mundo simulado, que incluye los robots, el entorno y su representación gráfica. Utiliza el lenguaje VRML97.

Es una lista de nodos. Cada nodo contiene campos y, cada campo, valores u otros nodos. Los valores pueden ser numéricos o cadenas de caracteres.

## El directorio del proyecto

El directorio raíz del proyecto tiene que tener al menos un subdirectorio llamado *worlds*, con uno o más ficheros *.wbt*. Además, lo habitual es que haya un directorio *controllers* con los controladores de los robots.

La estructura completa del directorio del proyecto es la siguiente:

- *controllers:* contendrá una carpeta independiente para cada controlador ligado al proyecto. El enlace se hace a través del campo *controller* de cada robot. El contenido del campo *controller* debe coincidir con el nombre de la carpeta del controlador y con el de la clase Java (o el fichero fuente C) del mismo.

- *protos:* contiene todos los ficheros PROTO del proyecto.

- *plugins:* contiene los plugins disponibles en el proyecto. El enlace es a través del campo *physics* del nodo *WorldInfo*.

- *worlds:* este directorio contiene los ficheros *.wbt* de los mundos y las texturas. Las texturas irán normalmente en un subdirectorio llamado *textures*.

Además, cada fichero mundo *.wbt* tendrá asociados dos ficheros que están ocultos:

- *Fichero del proyecto:* se llama igual que el fichero mundo, pero con un punto delante para ocultarlo y la extensión *.wproj*. Contiene datos de perspectiva al abrir el mundo y otros relacionados con el GUI. 

- *Fichero Imagen del proyecto*: se llama igual que el proyecto pero con un punto para oculatar y con  extensión *.jpg*. Por defecto, mide 768px por 432px.

Estos dos ficheros se pueden borrar, en cuyo caso se generarán unos nuevos con  valores por defecto.

## Programming Language Setup

[User guide: Programming Language Setup](https://cyberbotics.com/doc/guide/language-setup)

## Hola mundo en C

```c
#include <webots/robot.h>
#include <stdio.h>

int main() {
   wb_robot_init();

   while(wb_robot_step(32) != -1) {
      printf("Hello World!\n");
   }
   wb_robot_cleanup();
  return 0;
}
```

- En los ficheros de cabecera habrá que poner los que se necesiten de C más uno por cada nodo webots que se use. En el ejemplo se usa *<webots/robot.h>*. La documentación de cada nodo en el manual de referencia: [Webots Reference Manual](https://www.cyberbotics.com/doc/reference/index).

- Al inicio del programa hay que llamar a la función *wb_robot_init()*, para iniciar la sincronización del controlador con Webots. Al final de la simulación, hay que llamar a la función *wb_robot_cleanup()*. En otros lenguajes no hay que llamar a estas funciones.

- Periódicamente, hay que llamar a la función *wb_robot_step()*, pasandole un valor de microsegundos. Este valor corresponde a microsegundos medidos en tiempo de simulación, que puede ser mayor o menor que el tiempo real, dependiendo de la complejidad del código del controlador.

- En el ejemplo, el final del programa se marca cuando la función *wb_robot_step()* devuelva -1, lo que sucede al parar la simulación en el GUI o en otras situaciones similares.

## Hola mundo en Java

```java
import com.cyberbotics.webots.controller.Robot;

public class HelloWorld {

   public static void main(String[] args) {
      final Robot robot = new Robot();
      while (robot.step(32) != -1) {
         System.out.println("Hello World!");
      }
   }
}
```

La principal diferencia con C es que, en vez de llamar a los métodos *wb_robot_init()* y wb_robot_cleanup(), en Java se crea una instancia de la clase Robot.

## Dispositivos

Hay dos tipos de dispositivos: *actuadores* y *sensores*. 

Los actuadores incluyen los motores, luces y otros dispositivos. No es necesario activarlos antes de usarlos, solo fijar el valor de sus propiedades. 

Los sensores pueden ser de muchos tipos. Por ejemplo, el Gps y el Compass son sensores. Para usarlos, hay que activarlos, llamando a la función *enable()* correspondiente. La función *enable()* recibe como argumento el intervalo de tiempo de muestreo que se va a utilizar. 

## Leer datos de un sensor en C

```c
#include <webots/robot.h>
#include <webots/distance_sensor.h>
#include <stdio.h>

#define TIME_STEP 32

int main() {
  wb_robot_init();

  WbDeviceTag sensor = wb_robot_get_device("my_distance_sensor");
  wb_distance_sensor_enable(sensor, TIME_STEP);

  while (wb_robot_step(TIME_STEP) != -1) {
    const double value = wb_distance_sensor_get_value(sensor);
    printf("Sensor value is %f\n", value);
  }

  wb_robot_cleanup();
  return 0;
}
```

En los *#include* hay que incluir cabeceras para el robot y para el sensor que se quiera utilizar.

Lo primero es obtener un identificador para el sensor. Para ello, se obtiene una instancia de `WbDeviceTag`utilizando la función `wb_robot_get_device()`, que recibe como argumento una cadena de caracteres con el valor de la propiedad *name* que identifica al dispositivo en el nodo correspondiente del fichero *.wbt*. Si no existe un dispositivo con ese nombre, la función devuelve 0.

Para utilizar un sensor hay que utilizar su función *wb_XXX_enable()*, que recibe como argumento el intervalo de actualización en milisegundos. Los valores proporcionados por el sensor se actualizan durante la llamada a *wb_robot_step()*, por lo que el tiempo de actualización del sensor tiene que ser el mismo o uno mayor. Por ejemplo, se podría poner el doble y que el sensor se actualice solo cada dos pasos de la simulación. Lo que no tiene sentido es poner un tiempo menor. En sensores muy exigentes, por ejemplo las cámaras, este valor puede ser importante para mantener fluida la simulación.

Cada sensor tiene sus funciones para obtener los datos. En el caso del sensor de distancia, la función que obtiene los datos es *wb_distance_sensor_get_value()*, que recibe como argumento el identificador del sensor y devuelve un valor *double* con la última lectura de distancia del sensor. Para comprender la interpretación del valor que devuelve este sensor, consulte su documentación en [Documentación del DistanceSensor](https://cyberbotics.com/doc/reference/distancesensor#wb_distance_sensor_get_value).

Hay sensores que devuelven un vector de valores double, en vez de un solo valor. En cada caso, hay que consultar la documentación correspondiente. 

## Leer de un sensor en Java

```java
import com.cyberbotics.webots.controller.Robot;
import com.cyberbotics.webots.controller.DistanceSensor;

public class ReadingSensor {

  public static void main(String[] args) {

    final int TIME_STEP = 32;

    final Robot robot = new Robot();

    final DistanceSensor sensor = robot.getDistanceSensor("my_distance_sensor");
    sensor.enable(TIME_STEP);

    while (robot.step(TIME_STEP) != -1) {
      final double value = sensor.getValue();
      System.out.println("Sensor value is: " + value);
    }
  }
}
```

El proceso es parecido a C pero, en vez de obtener un identificador al dispositivo, se obtiene una instancia de la clase del sensor con el método específico de la clase *Robot*, en este caso *getDistanceSensor()*. El argumento sigue siendo la cadena de texto del nombre del dispositivo. El resto del proceso es similar al de C.

## Definir PROTOS

La estructura básica para un PROTO es:

```shell
#VRML_SIM R2023b utf8
PROTO protoName [
  protoFields
]
{
  protoBody
}
```

- *protoName*: debe coincidor con el nombre del fichero *.proto*.

- *protoFields*: son los campos que se podrán modificar en el *PROTO*.

- *protoBody*: es la definición del nodo raíz del PROTO, por ejemplo el Robot.

Para crear campos modificables, hay que definir el campo en la sección *fields* y luego asignarlo en el cuerpo con la cláusula IS. Por ejemplo:

```shell
#VRML_SIM R2023b utf8
PROTO Rueda [
   field SFVec3f    translation  0.05 0.06 0
   field SFRotation rotation     1 0 0 1.5708
]
{ 
   Solid {
      translation IS translation
      rotation IS translation
      children [
          Shape {
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
```

## Definir una rueda con un motor giratorio

Un *HingeJoint* deriva de un *Joint*.

<img src="https://raw.githubusercontent.com/cyberbotics/webots/released/docs/reference/images/hingeJoint.thumbnail.png" title="" alt="hingeJoint.png" data-align="center">

El *RotationalMotor* deriva de *Motor* y se acopla a un *HingeJoint* para producir movimiento rotatorio.

```shell
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
      physics Physics { }
   }
}
```

## Motor (giratorio)

El motor es giratorio y dispone de varias propiedades:

- `Position`: se mide en radianes indica el número máximo de radianes que girará. Se puede fijar en `Double.POSITIVE_INFINITY`.

- `Velocity`: el segundo la velocidad de giro en radianes por segundo.import org.antlr.v4.runtime.CharStream;
  import org.antlr.v4.runtime.CharStreams;
  import org.antlr.v4.runtime.CommonTokenStream;
  import org.antlr.v4.runtime.tree.ParseTree;
  import org.antlr.v4.runtime.tree.ParseTreeWalker;

## DEF and USE

[DEF and USE](https://cyberbotics.com/doc/reference/def-and-use)

```shell
[DEF defName] nodeName { nodeBody }
```

```shell
USE defName
```

## Supervisor

[Cyberbotics: Supervisor](https://cyberbotics.com/doc/reference/supervisor)

[Tutorial:: Supervisor](https://cyberbotics.com/doc/guide/tutorial-8-the-supervisor)

A Supervisor is a special type of [Robot](https://cyberbotics.com/doc/reference/robot) which has additional powers. In fact, any Robot can be turned into a supervisor when its field named `supervisor` is set to TRUE. 

A Supervisor can modify the environment by adding or removing nodes to the scene, it
 can change their properties by modifying the values of parameters in a programmatic way, allowing for instance to move or setup a robot a certain way, it can start the  creation of movies, animations and, last but not least, thanks to its unlimited access it can be used to acquire measurements about the state of the simulation as well as track its evolution.
However, even a Supervisor cannot access the internal information and measurements of devices mounted on a different robot, such as camera images and distance sensor 
measurements.

En Java, la clase *Supervisor:*

```java
public class Supervisor extends Robot {
   // Métodos de la clase
}
```

**Métodos para coger un handle a un nodo del mundo:**

```java
public Node getFromDef(String name);
```

El parámetro *name* se refiere al valor *DEF defName* del nodo. La referencia se puede utilizar para llamar a métodos del nodo. 

Por ejemplo, si tenemos un robot *BB-8* definido en nuestro mundo con:

```shell
DEF robot_1 Robot {
   ...
}
```

Podríamos obtener el valor de su campo traslación y modificarlo con:

```java
Supervisor robot = new Supervisor(); // create Supervisor instance

Node robot_1 = robot.getFromDef("robot_1");
Field translationField = robot_1.getField("translation");
double newValue[] = {2, 0, 0};
translationField.setSFVec3f(newValue);
```
