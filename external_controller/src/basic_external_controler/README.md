### BasicExternalController

Controlador externo básico. Arranca *Webots* con el fichero mundo `Mundo_1.wbt` y llama a varios métodos del robot `SimpleVehicle`. Es necesario que el nodo `Robot` del fichero del mundo tenga establecido el atributo `controller` en `extern`. Antes de arrancar *Webots*, comprueba si ya está arrancado.

Consta de dos ficheros fuente:
- `BasicExternalController.java`: es el controlador propiamente dicho.
- `SimpleVehicle.java`: es el robot que se utilizará en la simulación.  

Para compilar, situandose en el directorio con los ficheros fuente del proyecto:
```shell
javac -cp ../../libraries/Controller.jar 
      -d ../../controllers/BasicExternalController 
      *.java
```
Para ejecutar hay dos procedimientos:

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



