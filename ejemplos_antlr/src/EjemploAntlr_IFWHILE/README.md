Ejemplo de una gramática que proporciona asignaciones, if, while y log.

La gramática se llama `Mu` y está en el fichero *Mu.g4*.

El *visitor* generado hace uso de una clase llamada `Value.java` que permite crear valores en forma de `Object` que luego se pueden convertir en *boolean*, *String* o *Double*. 

Para procesar la gramática:
```shell
antlr Mu.g4 -visitor
```

Hay que crear el visitor *EvalVisitor.java*. Observa la técnica para guardar en memoria las variables que se asignen, mediante un *HashMap<String, Valu>*. Además, se crea un programa *Main.java* para probar el fichero *test.mu*.

Para compilar todo:
```shell
javac -cp ../../libraries/antlr-4.13.2-complete.jar -d bin *.java
```
Para ejecutar la prueba:
```shell
java -cp bin:../../libraries/antlr-4.13.2-complete.jar EjemploAntlr_IFWHILE.Main
```


El ejemplo está sacado de :

https://stackoverflow.com/questions/15610183/if-else-statements-in-antlr-using-listeners

He tenido que corregir algunos deprecated:
- En algunos parámetros usaba la anotación `@NotNull`: la he suprimido
- Utilizaba el método *tokenNames()* del Parser, por ejemplo:
```java
throw new RuntimeException("unknown operator: " + MuParser.tokenNames[ctx.op.getType()]);
```
Lo he sustituido por:
```java
throw new RuntimeException("unknown operator: " + MuParser.VOCABULARY.getDisplayName(ctx.op.getType()));
```
También he cambiado el nombre a algunos *tokens*.

