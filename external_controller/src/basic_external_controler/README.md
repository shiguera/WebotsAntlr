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

Para arrancarlo, situándose en el directorio del controlador (donde se han enviado los ficheros compilados):
```shell
[WEBOTS_HOME]/webots-controller BasicExternalController.class 
```




