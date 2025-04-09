### AntlrExternalController

Controlador externo que utiliza el lenguaje creado con *Antlr*. Arranca *Webots* con el fichero mundo `Mundo_1.wbt` y ejecuta las instrucciones del fichero que indique el usuario. Es necesario que el nodo `Robot` del fichero del mundo tenga establecido el atributo `controller` en `extern`. Antes de arrancar *Webots*, comprueba si ya está arrancado.

Para poder arrancar el controlador desde la consola:
```shell
export WEBOTS_HOME=/usr/local/webots
export LD_LIBRARY_PATH=/usr/local/webots/lib/controller/:$LD_LIBRARY_PATH
java -cp .:../../libraries/antlr-4.13.2-complete.jar
     :/usr/local/webots/lib/controller/java/Controller.jar 
     -Djava.library.path=/usr/local/webots/lib/controller/java/ 
     AntlrCompleteLanguage
```
> **NOTA:** Para que funcione, en el *classpath* hay que usar la librería *Controller.jar* de la instalación de webots, no sirve la que he copiado yo en el directorio *libraries* del proyecto mundo webots. Si no lo hago así, luego no encuentra bien las otras librerías nativas referenciadas.

> **NOTA:** La variable de entorno *LD_LIBRARY_PATH* es específica de Linux, en otros entornos no creo que funcione.

> **NOTA:** Antes de conseguir configurar correctamente el *-classpath* y la variable de entorno *LD_LIBRARY_PATH*, para conseguir que funcionara invocándolo desde la consola, lo que hacía era descomprimir la librería `antlr.jar` dentro del directorio del controlador.

Los pasos para construir:

**Crear la gramática**. Está en el fichero `Webots.g4`. Solo usa dos instrucciones: `AVANZA` y `GIRA`. La primera recibe dos parámetros: la velocidad relativa a la máxima del robot y la distancia que tiene que avanzar en unidades del mundo. La instrucción `GIRA` recibe un parámetro: el angulo en grados que se quiere girar, medido en sentido horario.

**Procesar la gramática**. Situado en el directorio del código fuente:
```shell
antlr Webots.g4
```

**Crear el fichero listener**. El código fuente está en el fichero `WebotsMyListener.java`. Solo procesa las dos instrucciones `AVANZA` y `GIRA`, llamando a los métodos `moveForward()` y `pivotAngle()` del robot.

**Compilar**. Hay que poner en el classpath las librerías de Webots y de Antlr.
```shell
javac -cp ../../libraries/antlr-4.13.2-complete.jar:../../libraries/Controller.jar 
       -d ../../controllers/AntlrExternalController 
       *.java
```
**Descomprimir el jar de Antlr**. No he conseguido que me reconozca el path a la librería si lo arranco desde la consola. Sí que lo reconoce si arranco el controlador desde dentro de Webots. La solución que he encontrado es descomprimir el *jar* de *anlr* dentro del directorio del controlador y, así, sí que me arranca desde la consola.
```shell
jar -xf antlr-4.13.2-complete.jar
```


