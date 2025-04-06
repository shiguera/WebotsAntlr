Ejemplo de una grmática que gestiona una instrucción `log`. La gramática está en el fichero *SimpleLog.g4*. Incluye una cabecera para que las clases java generadas incluyan el nombre del paquete *EjemploAntle_Log*.

(Lo he creado usando las enseñanzas de la gramática Mu del siguiente enlace)
https://stackoverflow.com/questions/15610183/if-else-statements-in-antlr-using-listeners

El ejemplo completo de la gramática Mu está en `../EjemploAntlr_IFWHILE`


Para procesar la gramática:
```
antlr SimpleLog.g4 -visitor
```

Hay que crear el visitor. El código fuente está en *MySimpleLogVisitor.java*. Además, se crea un programa para hacer la prueba en *Main.java*.

Hay que compilarlo todo:
```shell
javac -cp ../../libraries/antlr-4.13.2-complete.jar -d bin *.java
```
Para probarlo, se utiliza el fichero *test.mu*:
```shell
log 32;
log .75;
log 3.14;
log "Prueba de texto";
log "Done!";
```
La instrucción para ejecutar:
```shell
java -cp bin:../../libraries/antlr-4.13.2-complete.jar EjemploAntlr_Log.Main
```



