Este proyecto muestra cómo usar un mismo lenguaje para manejar distintos tipos de robots. Se utiliza el patrón *Adapter*.

El lenguaje se ha llamado **RoboLang** y está desarrollado en el directorio (paquete) `lenguaje`. La gramática es `RoboLang.g4`. Se trata de un lenguaje elemental que solo tiene dos órdenes: 
- `AVANZA(v, d)`: donde `v`es la velocidad y `d`la distancia.
- `GIRA(angulo)`: donde `angulo`es el ángulo en grados que se quiere que gire el robot. 

La biblioteca `antlr-4.13.2-complete.jar` se ha guardado en el directorio `lib`.

Para compilar la gramática en Linux hay que situarse en el directorio `lenguaje` y teclear:

```shell
java -cp ../lib/antlr-4.13.2-complete.jar org.antlr.v4.Tool RoboLang.g4
```

Como resultado de la compilación de la gramática, se crearán:

- `RoboLangLexer.java`: es el analizador léxico del lenguaje (*lexer*). 
- `RoboLangParser.java`: es el analizador sintáctico (*parser*).
- `RoboLang.tokens` y `RoboLangLexer.tokens`: archivos auxiliares necesarios durante la interpretación del código fuente.
- `RoboLang.interp`y `RoboLangLexer.interp`: archivos auxiliares que se utilizan si se crean LexerInterpreter y ParserInterpretes. Son herramientas de debugging que permiten probar cambios en las gramáticas sin tener que recompilar todo. Yo no lo uso. Se podrían borrar.
- `RoboLangListener.java`: es el interface que deben implementar los interpretes del lenguaje. Los métodos son llamados al recorrer el árbol sintáctico generado. Contiene un método de entrada y otro de salida para cada regla no terminal del lenguaje.
- `RoboLangBaseListener.java`: es una clase que implementa el interface anterior y tiene una implementación vacía de los métodos. Los interpretes del lenguaje que desarrollemos tendrán que derivar de esta clase y sobrescribir los métodos que quiera utilizar.

En nuestro caso, queremos implementar un intérprete del lenguaje que ejecute el código fuente en distintos tipos de robots: RobotWebots, RobotStdDraw y RobotConsola.

Vamos a utilizar el patrón de diseño *Adaptador de objeto*:

![](img/patron_adaptador.png)

En nuestro caso, el cliente es el intérprete del lenguaje que es la clase `main/Interprete.java`. El *Target* es el interface `RoboLangListener` o la clase `RoboLangBaseListener`. El objeto que queremos adaptar es `RobotWebots`, `RobotStdDraw` o `RobotConsola`. Los adaptadores que hemos implementado son `WebotsListener.java`, `StdDrawListener.java` y `ConsolaListener.java`. 

![](img/patron_adaptador_robolang.png)

Para poder compilar el proyecto más cómodamente, se han copiado en el directorio `lib` todas las bibliotecas que se necesitan:
- Biblioteca estática para ANTLR: `antlr-4.13.2-complete.jar`.
- Biblioteca estática para Webots: `Controller.jar`.
- Bibliotecas dinámicas de Webots: `libController.so`, `libCppController.so` y `libJavaController.so`.

Para compilar, situados en el directorio principal del proyecto, hay que teclear:

```shell
javac -cp "lib/Controller.jar:lib/antlr-4.13.2-complete.jar" \
    -d bin \
    src/main/*.java src/lenguaje/*.java src/interpretes/*.java src/sound/*.java \
    src/robolang_webots/*.java src/robolang_stddraw/*.java src/robolang_consola/*.java 
```

Para ejecutar el intérprete con un robot concreto, habrá que ejecutar la clase interprete del lenguaje para ese robot. Son las clases `InterpreteWebots`, `InterpreteStdDraw` y `InterpreteConsola`. Estas clases admiten un parámetro con el nombre del fichero con el código fuente RoboLang que se quiere ejecutar. Si se instancian sin parámetros, ejecutan `programa_1.rbl`.

Para ejecutar el `InterpreteWebots` se necesita fijar la variable de entorno `LD_LIBRARY_PATH` en Linux o `PATH` en Windows, apuntando al directorio `lib` o a `$WEBOTS_HOME/lib/controller`.

He creado unos scripts utilitarios para Linux (Los usuarios de Windows deberán adaptar los scripts):
- `compilar`: compila todo el proyecto.
- `InterpreteWebots`: ejecuta el interprete de Webots. El propio script establece el valor de la variable `LD_LIBRARY_PATH` y abre el programa Webots. Si Webots ya estaba abierto, no lo vuelve a abrir. Inicialmente, el programa Webots abre el mundo `robolang_webots/MiniMundo.wbt` y utiliza la clase `InterpreteWebots` como controlador externo.
- `InterpreteStdDraw`: se ejecuta el código fuente *RoboLang* con un robot 2D creado usando la biblioteca Java `StdDraw`.
- `InterpreteConsola`: se ejecuta el código fuente *RoboLang* en la consola, con un robot que gestiona la posición del robot y muestra los valores en pantalla, pero sin salida gráfica.

Además, he creado un pequeño programa, `mainMenu.java`, que pide al usuario el nombre del fichero fuente *RoboLang* que quiere ejecutar y le muestra un menú para elegir el interprete con el que quiere ejecutarlo. Este programa se puede ejecutar con el script `ejecutar`.

Se ofrecen dos ficheros fuente para realizar pruebas: `programa_1.rbl` y `programa_2.rbl`.

Los intérpretes para *StdDraw* y para la consola implementan efectos de sonido utilizando la biblioteca *StdAudio*.



