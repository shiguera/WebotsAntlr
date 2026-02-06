Para compilar la gramática, situado en el directorio `parser`:

```shell
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar org.antlr.v4.Tool Robot.g4
```

Para compilar, situado en el directorio del controlador (`controllers/AdapterController)`:

```shell
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar:/usr/local/webots/lib/controller/java/Controller.jar  *.java robot_webots/*.java robot_consola/*.java parser/*.java
```

Para ejecutar, situado en el directorio del controlador (`controllers/AdapterController)`:

```shell
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar:/usr/local/webots/lib/controller/java/Controller.jar  -Djava.library.path=/usr/local/webots/lib/controller/java/ AdapterController
```

Está probado con la versión 17 de java y javac


