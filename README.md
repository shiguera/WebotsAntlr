## Ejemplos de Webots usando lenguajes ANTLR

En este repositorio hay varios ejemplos para aprender a combinar Webots y Antlr. 

Mediante Antlr se crea un lenguaje específico que sirva para manejar un robot de Webots.

Todos los programas están desarrollados en Java.

Hay varios grupos de programas ejemplo. En los directorios hay ficheros `README.md` que explican cómo usar los distintos ejemplos. 

- **HelloWebotsAntlr**. Ofrece dos ejemplos de controladores. El fichero mundo es el mismo para los dos controladores: `MiniMundo.wbt`. El mundo tiene un nodo `Robot`. Para cambiar el controlador, hay que elegir el nombre de controlador adecuado desde *Webots* en el nodo `controller` del robot.
  - ***SimpleController:*** es un controlador que no utiliza ANTLR, solo utiliza clases de Webots. Muestra cómo separar el robot del controlador en dos clases Java diferentes. La clase `SimpleVehicle_0` muestra un vehículo que deriva de la clase `Robot` e implementa métodos personalizados para manejarlo. La clase `SimpleController` es un ejemplo de controlador que tiene un método `main()` en el que se instancia y se maneja el vehículo.
  - **ControllerAntlr:** es un controlador que utiliza un lenguaje desarrollado con ANTLR.  Se trata de un lenguaje muy sencillo con dos instrucciones: `AVANZA` y `GIRA`. La gramática es el fichero `Webots.g4`, que está en el directorio `controllers`. También están ahí el lexer, el parser y el listener generados con ANTLR a partir de la gramática. El listener es el fichero `WebotsMyListener.java`. El robot es el fichero `SimpleVehicle_1.java`, similar o igual que el robot `SimpleVehicle`del ejemplo anterior. El controlador está en el fichero `ControllerAntlr.java` y tiene un método `main()` similar al del ejemplo anterior, pero que ejcuta órdenes del lenguaje.

- **ejemplos_antlr**. Son ejemplos de gramáticas ANTLR, con ejemplos de cómo hacer una intrucción log, que permite sacar mensajes por pantalla, cómo hacer asignaciones y cómo hacer bifurcaciones tipo *if* y bucles tipo *while*.

- **external_controller**. Son ejemplos de controladores externos para Webots. Hay tres: *BasicExternalController*, solo con instrucciones Webots, *AntlrExternalController*, que utiliza instrucciones sencillas de un lenguaje hecho con ANTLR y *AntlrCompleteLanguage* que incorpora un lenguaje completo con asignaciones, bifurcaciones y bucles.

- **LenguajeMultiRobot:** es un ejemplo de cómo utilizar un mismo lenguaje ANTLR para manejar distintos tipos de Robots. Se aplica a un robot de consola, un robot desarrollado con StdDraw y un robot de Webots.
