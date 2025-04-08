## Ejemplos de Webots usando lenguajes ANTLR

En este repositorio hay varios ejemplos para aprender a combinar Webots y Antlr. 

Mediante Antlr se crea un lenguaje específico que sirva para manejar un robot de Webots.

Todos los programas están desarrollados en Java.

Hay varios grupos de programas ejemplo. En los directorios hay ficheros `README.md` que explican cómo usar los distintos ejemplos. 

- **HelloWebotsAntlr**. Ofrece dos ejemplos: *SimpleController* y *AntlrController*.
- **ejemplos_antlr**. Son ejemplos de gramáticas ANTLR, con ejemplo de cómo hacer una intrucción log, que permite sacar mensajes por pantalla, cómo hacer asignaciones y cómo hacer bifurcaciones tipo *if* y bucles tipo *while*.
- **external_controller**. Son ejemplos de controladores externos para Webots. Hay tres: *BasicExternalController*, solo con instrucciones Webots, *AntlrExternalController*, que utiliza instrucciones sencillas de un lenguaje hecho con ANTLR y *AntlrCompleteLanguage* que incorpora un lenguaje completo con asignaciones, bifurcaciones y bucles.
