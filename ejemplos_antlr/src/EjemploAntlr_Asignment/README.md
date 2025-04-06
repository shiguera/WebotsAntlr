Ejemplo de gramática que permite hacer asignación de variables. La gramática está en *Asignment.g4*. Se utiliza la clase *Value.java* que se explicó en el *EjemploAntlr_Log*.

Para procesar la gramática:
```shell
antlr Asignment.g4 -visitor
```
Hay que crear el visitor *MyAsignmentVisitor.java*. Es importante observar el mecanismo que se utiliza para guardar variables en memoria, mediante un *HashMap<String, Value>*. Además, se crea el programa *Main.java* para probar el fichero de instrucciones *test_asignment.mu*.

Para compilar todo:
```shell
javac -cp ../../libraries/antlr-4.13.2-complete.jar -d bin *.java
```

Para ejecutar:
```shell
java -cp bin:../../libraries/antlr-4.13.2-complete.jar EjemploAntlr_Asignment.Main
```
La salida de pantalla:
```shell
Guardando a = 7
Guardando b = 0.455
La variable a ya existe, se sobrescribe
Guardando a = "Prueba de texto"
```



(Lo he creado usando las enseñanzas de la gramática Mu del siguiente enlace)
https://stackoverflow.com/questions/15610183/if-else-statements-in-antlr-using-listeners

El ejemplo completo de la gramática Mu está en `../EjemploAntlr_IFWHILE`


