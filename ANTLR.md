# ANTLR

## Repositorio en Github

[GitHub - ANTLR ](https://github.com/antlr/antlr4)

http://lab.antlr.org/ : para probar grmáticas en la web

[Errata for The Definitive ANTLR 4 Reference](https://pragprog.com/cms/errata/tpantlr2-errata/)

## Descarga e instalación

https://www.antlr.org/

 [Runtime Libraries and Code Generation Targets](https://github.com/antlr/antlr4/blob/master/doc/targets.md)

[ANTLR v4 Runtime API](https://www.antlr.org/api/)

**Instalación en el Titan:** `/usr/local/lib/antlr-4.13.1-complete.jar`

**Ejemplos y ejercicios:** `/home/shiguera/ownCloud/AAA_Teleco/2024-25/3_TFG/ws/ANTLR`

**Ejecutar:** se puede ejecutar directamente como `jar` o mediante la clase `Tool`:

- `java -jar /usr/local/lib/antlr-4.13.2-complete.jar`

- `java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar org.antlr.v4.Tool`

He creado un script para llamarlo en `/usr/local/bin/antlr`, con el siguiente contenido:

```shell
#!/bin/sh
java -cp 
   "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" 
   org.antlr.v4.Tool $*
```

## Tutoriales

- [ANTLR Tutorial - Hello Word](https://meri-stuff.blogspot.com/2011/08/antlr-tutorial-hello-word.html)

- [ANTLR Tutorial - Expression Language](https://meri-stuff.blogspot.com/2011/09/antlr-tutorial-expression-language.html)

- [The ANTLR Mega Tutorial](https://tomassetti.me/antlr-mega-tutorial/)

- Ejemplos de gramáticas: [GitHub - antlr/grammars-v4: Grammars written for ANTLR v4; expectation that the grammars are free of actions.](https://github.com/antlr/grammars-v4)

- [ANTLR4 Grammar: A Quick Tutorial (Antlr Python)](https://medium.com/@kv391/antlr4-grammar-a-quick-tutorial-e1f0fb6ca4ff)

- [# Parsing your own language with ANTLR4](https://medium.com/@fwouts/a-quick-intro-to-antlr4-5f4f35719823)

- 

## La herramienta TestRig

La herramienta `TestRig` sirve para probar las gramáticas. Permite obtener los tokens creados y el árbol sintáctico en formato texto o en formato gráfico. Para invocar la herramienta:

```shell
java -cp /usr/local/lib/antlr-4.13.2-complete.jar 
     org.antlr.v4.gui.TestRig
     <nombre_gramatica> <regla_de_entrada> par
```

He creado un script en `/usr/local/bin/grun` para ejecutarlo con comodidad, con el siguiente contenido:

```shell
#!/bin/sh
java -cp "/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH" 
   org.antlr.v4.gui.TestRig $*
```

Tecleando `grun`sin parámetros se obtiene ayuda.

El siguiente ejemplo muestra su uso:

1. Hay que crear una gramática:

```shell
grammar Hello;            // Define a grammar called Hello
r : 'hello' ID ;          // match keyword hello followed by identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines, \r (Windows)
```

2. Ejecutar `antlr Hello.g4`, para procesar la gramática y crear el *Parser* y el *Lexer*. El resultado serán varios ficheros:

```shell
HelloLexer.java
HelloListener.java
HelloParser.java

Hello.interp
HelloLexer.interp
HelloLexer.tokens
Hello.tokens
```

3. Compilar las clases Java:

```shell
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar *.java
```

4. Ejecutar la herramienta de test `TestRig`. Esto arrancará el lexer y el parser. Tendremos que teclear una instrucción en nuestro lenguaje. Para finalizar la entrada `CTRL+D` (EOF, en Windows CTRL+Z). 
5. Para obtener los tokens:

```shell
grun Hello r -tokens
```

Al ejecutar la herramienta de test, teclearemos una instrucción en nuestro lenguaje y veremos los tokens que se generan:

```shell
> grun Hello r -tokens    // Comenzar TestRig en la gramática Hello
                        // por la regla r
hello Santiago          // Teclear una instrucción (hello + ID)
CTRL+D                  // Teclear EOF

[@0,0:4='hello',<'hello'>,1:0]  // Salida de grun
[@1,6:13='santiago',<ID>,1:6]
[@2,15:14='<EOF>',<EOF>,2:0]
```

6. Para obtener el árbol sintáctico en forma textual (estilo *Lisp*):

```shell
> grun Hello r -tree
hello santiago
CTRL+D
(r hello santiago)
```

7. También podemos ver el árbol de forma gráfica:

```shell
grun Hello r -gui
hello santiago
CTRL+D
```

![](img/grun_gui.png)

## Lexers and Parsers

**Análisis léxico:**  consiste en agrupar caracteres en palabras, que se llaman *tokens* o símbolos. El proceso lo hace el *lexer*.

**Análisis sintáctico:** consiste en reconocer la estrutura de una sentencia compuesta por uno o más tokens. El proceso lo hace el parser.

Ejemplo:

Una regla de una gramática para una asignación podría ser:

```shell
assign : ID '=' expr ';' ;
```

Una instrucción en ese lenguaje podría ser:

```shell
sp = 100 ;
```

Lexer: los tokens son: "sp", "=", "100", ";"

Parser: genera un árbol

![](img/arbol_sintactico_1.png)

En el árbol, los nodos internos son referencias a reglas y las hojas son referencias a tokens. Podríamos interpretar los nodos interiores como etiquetas de la parte de árbol por debajo de él.

El camino desde el nodo raíz hasta otro nodo representa la pila de reglas de invocaciones de ese elemento, llamada *pila de llamada* en el analizador sintáctico recursivo descendente de ANTLR.

![](img/parsing_terms.png)

## Grammars

Una gramática es un conjunto de *reglas* que describen la sintaxis de un lenguaje. Hay dos tipos de reglas:

- **Reglas sintácticas:** empiezan con minúscula.

- **Reglas lexicográficas:** definen los *tokens*. Empiezan con mayuscula.

Una gramática *ANTLR* está formada por una línea de cabecera con el nombre de la gramática, que tiene que coincidir con el del fichero `.g4` y una serie de reglas que se pueden invocar unas a otras. Es preciso que haya una regla inicial, análoga al método *main()* de los lenguajes de programación.

```antlr4
grammar MyG
regla1: <<contenido>> ;
regla2: <<contenido>> ;
...
```

Para razonar la gramática, se puede utilizar la descripción de las reglas en pseudocódigo. Por ejemplo, para describir una gramática para interpretar CSV, se podría partir de la regla que define un fichero e ir detallando hacia abajo:

```antlr4
fichero: <<secuencia de filas terminadas por cambio de línea
fila: <<Secuencia de campos, separados por comas y 
        terminados en cambio de línea>>
campo: <<Número o cadena de caracteres>>
```

Una regla puede estar formada por varias *subreglas*, que son reglas indicadas inline, encerradas entre paréntesis y, opcionalmente, marcadas con los bucles `?, *, +, ` o con el operador OR para subreglas `|`.

La notación de ANTLR:

| Sintaxis                    | Descripción                               |
| --------------------------- | ----------------------------------------- |
| //                          | Comentarios                               |
| **x**                       | Token, referencia a regla o subregla x    |
| **x y ... z**               | Match a sequence of rule elements.        |
| **(... \| ... \| ...)**     | Subrule with multiple alternatives.       |
| **x?**                      | Match x or skip it (cero o una vez)       |
| **x***                      | Match x zero or more times.               |
| **x+**                      | Match x one or more times.                |
| **r : ... ;**               | Define rule r.                            |
| **r : ... \| ... \| ... ;** | Define rule r with multiple alternatives. |

El operador opcional `?` se puede sustituir con una subregla utilizando el operador opcional `|`:

```antlr4
decl: ID ('=' expr)? ;   // Utilizando ?
decl: ID ('=' expr | ) ; // Utilizando |
```

Hay cuatro patrones en los que se enmarcan las reglas de las gramáticas:

- Secuencias

- Elección

- Dependencia entre tokens

- Frases anidadas

### Patrón secuencia

Es una secuencia de tokens o subfrases. Por ejemplo, las declaraciones de variables (tipo seguido de un identificador) o una lista de enteros.

```antlr4
x y ... z               // x followed by y, ..., z
'[' INT+ ']'            // '[' seguido de uno o más enteros seguido de ']'
retr: 'RETR' INT '\n' ; // 'RETR' seguido de entero seguido de '\n' 
```

Los literales entrecomillados se deben cumplir exactamente. *INT* es un token que deberá estár definido más adelante.

**Secuencias con un número indeterminado de elementos**:

```antlr4
(fila)* ;      // cero o más filas
(campo)* ;     // cero o más campos
```

**Secuencia de elementos terminados en un terminador:** por ejemplo, una secuencia de sentencias acabadas en ';' en un lenguaje:

```antlr4
(statement ';')*  // Lista de declaraciones
(row '\n')*       // Líneas separadas por '\n'
```

**Secuencia de elementos con separador:**

```antlr4
expr (',' expr)* ;    // function call arguments
( expr (',' expr)* )? // optional function call arguments
'/'? name ('/' name)* // simplified directory name
```

### Patrón elección (alternativas)

Se trata de un conjunto de frases alternativas. Cada vez que al describir una estructura decimos: *esta estructura puede ser esto o lo otro*, estamos ante una elección.

```antlr4
type: 'float' | 'int' | 'void' ; // user-defined types
stat : ifstat | whilestat | 'return' expr ';' ;
expr : '(' expr ')' | INT | ID ;
tag : '<' Name attribute* '>' | '<' '/' Name '>' ;
```

### Patrón: tokens interdependientes

La presencia de uno de ellos implica que más adelante debe aparecer el otro. Se trata de tokens que aparecen por parejas, por ejemplo, los paréntesis, los corchetes,  las llaves y las comillas.

```antlr4
'(' expr ')'         // nested expression
ID '[' expr ']'      // array index
'{' stat* '}'        // statements grouped in curlies
'<' ID (',' ID)* '>' // generic type specifier
```

Otro ejemplo podría ser el operador ternario: `a?b:c`

### Patrón: frase anidada

Una frase anidada tiene una estructura lingüística autosimilar, cuyas subfrases se ajustan a esa misma estructura. Se expresan mediante reglas recursivas. 

```antlr4
expr : '(' expr ')' | ID ;
classDef : 'class' ID '{' (classDef|method|field) '}' ;
```

## Precedencia, recursión a izquierda y asociatividad

```antlr4
expr  : expr '*' expr
      | expr '+' expr
      | INT
      ;
```

La definición anterior es ambígua para expresiones como `1+2*3`, pues no se indica si hay que hacer antes la suma o la multiplicación. En ANTLR se resuelve la ambigüedad a favor de la regla que aparece primero, en este caso la multiplicación.

Por defecto, ANTLR asocia los operadores de izquierda a derecha, pero hay ocasiones en las que hace falta asociar de derecha a izquierda, por ejemplo en la exponenciación. Por ejemplo, `1^2^3` es `9`, no `1`. En ANTLR hay que especificarlo:

```antlr4
expr  : <assoc=right> expr '^' expr // Operator ^ asocia por la dcha
      | INT
      ;
```

> **Nota:** En el libro de Parr la regla de asociatividad izquierda se pone de la siguiente manera:
> 
> ```antlr4
> expr  : expr '^' <assoc=right> expr
> ```
> 
> Esto ha cambiado, ahora hay que ponerla al principio de la regla.

Por ejemplo, podríamos crear la siguiente gramática para operar expresiones con sumas, multiplicaciones y exponenciaciones:

```antlr4
expr : <assoc=right> expr '^' expr // ^ operator is right associative
     | expr '*' expr // match subexpressions joined with '*' operator
     | expr '+' expr // match subexpressions joined with '+' operator
     | INT           // matches simple integer atom
;
```

En esta gramática, el operador `^` tiene precedencia sobre  los otros, porque aparece antes en la regla gramatical. Además, se indica que es asociativo por la derecha. De esta forma, si probamos la expresión `1+2*2^2^3`, el resultado será 513:

![](img/grun_gui.png)

> **NOTA:** En ANTLR 3 no se soportaba la recursividad por la izquierda de las regllas, mientras que en ANTLR 4 sí que se soporta la recursividad DIRECTA por la izquierda. Es válido poner:
> 
> ```antlr4
> expr: expr '*' expr
>      ´
> ```
> 
> No obstante, no es válida la recursión si se hace indirecta, por ejemplo:
> 
> ```antlr4
> expr : expo // ERROR: indirectly left recursively via expo
> | ...
> ;
> expo : expr '*' expr ;
> ```

## Estructuras lexicográficas comunes

Los analizadores sintácticos (*parsers*) reconocen la estructura gramatical en una corriente de tokens y los analizadores lexicográficos (*lexers*) reconocen la estrucrtura gramatical en una corriente de caracteres.

En los fichero de gramáticas de ANTLR, las reglas lexicográficas empiezan con mayúscula y las reglas sintácticas con minúsculas.

Las reglas lexicográficas son muy parecidas de unos lenguajes a otros. Los operadores, palabras clave y signos de puntuación, se pueden utilizar directamente entre comillas simples (por ejemplo, ' * ') o se les puede asignar un token (por ejemplo, *MULT*), de forma que si varían de una gramática a otra solo haya que modificar la definición del token, sin afectar a las reglas sintácticas.

Las reglas lexicográficas más frecuentes son:

- Identificadores

- Números

- Literales entrecomillados

- Comentarios y espacios en blanco

- Signos de puntuación

- Palabras clave

**Identificadores:** 

Una regla lexicográfica básica para definir identificador compuesto solo de uno o más caracteres en mayúsculas o minúsculas podría ser el siguiente:

```antlr4
ID : [a-zA-Z]+ ; # Una o más letras, mayúsculas o minúsculas
```

Si en vez de nomenclatura de expresiones regulares utilizamos la nomenclatura ANTLR, esta misma regla se pondría:

```antlr4
ID : ('a'..'z'|'A''..'Z')+ ; // Una o más letras, mayúsculas o minúsculas
```

Una regla más compleja que incluya la posibilidad de utilizar números y el guion bajo en el identificador podría ser:

```antlr4
ID : LETTER (LETTER|DIGIT)*;
fragment LETTER : [a-zA-Z_] ;
fragment DIGIT : [0-9] ;
```

Esta regla para los identificadores coincidiría con algunas palabras clave, como '*enum*' o '*while*'. ANTLR separa todos los literales entrecomillados y los pone después de las reglas sintácticas, pero antes de las reglas gramáticales explícitas. Además, ANTLR da prioridad a las reglas que aparecen antes. 

**Números enteros:**

```antlr4
INT: '0'..'9'+;  // Con notación antlr
INT: [0..9]+;    // Con expresiones regulares
```

**Números en coma flotante:** la siguiente es una definición sin exponentes

```antlr4
FLOAT: DIGIT+ '.' DIGIT* // match 1. 39. 3.14159 etc...
     | '.' DIGIT+        // match .1 .14159
     ;
fragment DIGIT : [0-9] ; // match single digit
```

Un ejemplo completo con exponentes se puede ver en la gramática para C de la carpeta de ejemplos de gramáticas.

**Literales entrecomillados:** a string is a sequence of any characters between double quotes.

```antlr4
STRING: '"' (ESC|.)*? '"' ;
fragment
ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\
```

**Nota 1:** doble barra, porque el propio antlr necesita escapear la barra

**Nota2:** `*?` el número de veces que sea hasta que se encuentre el siguiente token. (nongreedy rule)

**Comentarios y espacios en blanco:**

```antlr4
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // Match "//" stuff '\n'
COMMENT : '/*' .*? '*/' -> skip ; // Match "/*" stuff "*/"
WS : [ \t\r\n]+ -> skip ; // match 1-or-more whitespace but discard
```

**Signos de puntuación y palabras clave:** se pueden señalar directamente entre comillas o definir una etiqueta:

```antlr4
// Directamente entre comillas
call : ID '(' exprList ')' ;

// Definiendo un token
call : ID LP exprList RP ;
LP : '(' ;
RP : ')' ;

// Palabras clave
returnStat : 'return' expr ';'
```

---

## Creación del parser y el lexer con antlr

Para crear las clases Lexer y Parser a partir de una gramática llamada *mygrammar* utilizando ANTLR:

```shell
java -cp antlr-4.13.1-complete.jar:$CLASSPATH org.antlr.v4.Tool mygrammar
```

En mi caso, he copiado la librería *antlr-4.13.1-complete.jar* en */usr/local/lib* y he creado un script  */usr/local/bin/antlr* con el siguiente contenido:

```shell
#!/bin/sh
java 
    -cp "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" 
    org.antlr.v4.Tool $*
```

Por tanto, para *parsear* la gramática *mygrammar*:

```shell
antlr mygrammar
```

## Flujo de trabajo

1. Crear la gramática, por ejemplo, `Hello.g4`

2. Crear el parser de la gramática:
   
   ```shellsession
   antlr Hello.g4
   ```
   
   A consecuencia de ello, se crean varios ficheros java:
   
   - `HelloLexer.java`: es el lexer que se utiliza para tokenizar los programas que hagamos en el lenguaje.
   
   - `HelloParser.java`: es el analizador sintáctico del lenguaje. Será el que cree el árbol sintáctico.
   
   - `HelloListener.java`: es el interface para implementar listeners que permitan recorrer el árbol sintáctico generado por el parser.
   
   - `HelloBaseListener.java`: es una clase que implementa el interface *HelloListener* con los métodos vacíos. Es la que usaremos para indicar qué hacen los métodos cada vez que se entra o se sale en una instrucción.

3. Crear una clase que derive de `HelloBaseListener`, con los métodos haciendo lo que queramos que hagan.

4. Crear el código fuente de nuestro programa en nuestro lenguaje
   
   1. Crear el programa que interpreta el código fuente en nuestro lenguaje. Dentro del programa, habrá que completar los siguientes pasos:
      
      1. Establecer el input del Lexer. Puede ser un fichero con el código fuente en nuestro lenguaje o se puede dar entrada desde la consola.
         
         ```java
         // Desde un fichero:
         CharStream input = CharStreams.fromFileName("pp.pp");
         // Desde la consola:
         CharStream input = CharStreams.fromStream(System.in);
         ```
      
      2. Crear un lexer que se alimente de esa entrada:
         
         ```java
         // create a lexer that feeds off of input CharStream
         ArrayInitLexer lexer = new ArrayInitLexer(input);
         ```
      
      3. Crear un buffer de tokens extraídos del analizador léxico.
         
         ```java
         // create a buffer of tokens pulled from the lexer
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         ```
      
      4. Crear un analizador sintáctico que se alimente del buffer de tokens:
         
         ```java
         // create a parser that feeds off the tokens buffer
         ArrayInitParser parser = new ArrayInitParser(tokens);
         ```
      
      5. Crear el árbol sintáctico empezando en la primera regla. En el código siguiente, la primera regla de la gramática se llamaba *init*.
         
         ```java
         ParseTree tree = parser.init();
         ```
      
      6. Crear un rastreador del árbol sintáctico que pueda ir lanzando las llamadas a los procedimientos. A continuación, iniciar el recorrido del rastreador, pasando como argumentos nuestra clase derivada del BaseListener y el árbol que ha creado el  parser.
         
         ```java
         // Create a generic parse tree walker 
         // that can trigger callbacks
         ParseTreeWalker walker = new ParseTreeWalker();
         // Walk the tree created during the parse, trigger callbacks
         walker.walk(new MyBaseListener("Prueba con parámetro"), tree);
         ```

Después del paso 5, se puede imprimir el árbol en formato Lisp con:

```java
System.out.println(tree.toStringTree(parser));
```

---

Gramática: conjunto de reglas que describen la sintaxis de un lenguaje.

- Reglas sintácticas: empiezan en minúsculas

- Reglas lexicográficas: empiezan en mayúsculas

- `|`operador or

- Subreglas: ('*' |  '+')

- Reglas recursivas: *expr: expr OP expr* (recursiva a la izquierda)

- `*` cero o más ocurrencias

- `+`una o más ocurrencias

- `?`una o ninguna

- `.` cualquier carácter

- `.*` cualquier secuencia de cero o más caracteres. Consume hasta el final del fichero

- `.*? ' " '` consume cualquier secuencia de cero o más caracteres hasta que encuentre unas comillas.

**Estructuras lexicográficas comunes:**

- **Signos de puntuación:**

Se pueden definir entrecomilolando o definiendo tokens:

```shell
// Entrecomillando
call: ID '(' exprList ')';
---------------------------
// Definiendo tokens
call: ID LP exprList RP ;
LP: '(';
RP: ')';
```

- **Palabras reservadas:** se pueden entrecomillar o definir tokens, como con los signos de puntuación.
  
  ```shell
  // Entrecomillando
  returnStat: 'return' expr ';';
  -------------------------------
  // Definiendo tokens
  RETURN: 'return';
  returnStat: RETURN expr ';';
  ```

- **Identificadores:** se pueden establecer reglas acerca de qué primer carácter se permite o si se permiten caracteres unicode.

```shell
// Usando notación ANTLR
ID: ID_LETTER (ID_LETTER|DIGIT)*;
fragment ID_LETTER: 'a'..'z'|'A'..'Z'|'_';
fragment DIGIT: '0'..'9';
-------------------------------------------
// Usando notación regex
fragment ID_LETTER: ([a-zA-Z]|''_');
fragment DIGIT: [0-9];
```

- **Números:** definiciones para enteros y float simples.

```shell
INT: DIGIT+;

FLOAT: DIGIT+ '.' DIGIT*
     | '.' DIGIT+
     ;
```

- **Strings:**

```shell
STRING: '"' (ESC|.)*? '"';
fragment ESC: '\\' [btnr\\];
```

- **Comentarios:**

```shell
LINE_COMMENT: '//' .*? '\n' -> skip
COMMENT: '/*' .*? '*/' -> skip
```

- **Espacios:**

```shell
WS: [ \t\n\r]+ -> skip
------------------------
// En notaci
```

## Importar gramáticas

Dentro de una gramática, se pueden incluir sentencias para importar otras gramáticas. Por ejemplo, podríamos separar las reglas del analizador léxico en un fichero idependiente y luego importarlas en el analizador sintáctico. Por ejemplo, el fichero *CommonLexerRules.g4* podría ser:

```antlr4
lexer grammar CommonLexerRules; // note "lexer grammar"
ID : [a-zA-Z]+ ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (end-statement signal)
WS : [ \t]+ -> skip ; // toss out whitespace
```

Y el fichero *LibExpr.g4*:

```antlr4
grammar LibExpr;
import CommonLexerRules; // includes all rules from CommonLexerRules.g4
/** The start rule; begin parsing here. */
prog: stat+ ;
...
```

## Añadir información de paquete en las gramáticas

`ANTLR provides a header tool which allows you to include package and imports. You include this in your *.g grammar file:

```java
@header {
    package org.xmlcml.cml.converters.antlr;
    import java.util.HashMap;
}
```

And you may need it in the Lexer as well:

```java
@lexer::header {package org.xmlcml.cml.converters.antlr;}
```

and in case you need to add some members and code:

```java
@members {
    HashMap<String, Object> objectMap = new HashMap<String, Object>();
    //...

    private void addArrayValue(String content) {
    //... code required by snippets in the grammar

    }
}
```

## Incluir métodos en las gramáticas

Los ejemplos que siguen se refieren a una grmática para leer ficheros de propiedades tipo *clave-valor*, como el siguiente:

```shell
user="parrt"
machine="maniac"
```

```shell
grammar PropertyFile;
@members {
    void startFile() { } // blank implementations
    void finishFile() { }
    void defineProperty(Token name, Token value) { }
}

file : {startFile();} prop+ {finishFile();} ;
prop : ID '=' STRING '\n' {defineProperty($ID, $STRING);} ;

ID: [a-z]+ ;
STRING : '"' .*? '"' ; 
```

Se puede poner código, no solo métodos vacíos, pero quizás es mejor dejarlos vacíos en el parser generado por ANTLR y luego derivar una clase propia que sobrescriba los métodos con el código que interese. De esta forma, la misma gramática sirve para diferentes aplicaciones.

Con la gramática anterior, ANTLR genera la clase `PropertyFileParser.java` y, dentro de ella, los métodos siguientes:

```java
public class PropertyFileParser extends Parser {
   ...
   void startFile() { } // blank implementations
   void finishFile() { }
   void defineProperty(Token name, Token value) { }
   ...
}
```

Se puede derivar una clase `PropertyFilePrinter` que sobrescriba los métodos que se quieran utilizar en la aplicación. El siguiente ejemplo imprime la lista de propiedades del fichero:

```java
public class PropertyFilePrinter extends PropertyFileParser {
    public PropertyFilePrinter(TokenStream input) {
        super(input);
    }
    void defineProperty(Token name, Token value) {
        System.out.println(name.getText()+"="+value.getText());    
    }
}
```

En este caso, solo se ha sobrescrito el método `defineProperty()`.

Para lanzar la aplicación, habrá que utilizar el *parser* creado para nuestra aplicación:

```java
PropertyFilePrinter parser = new PropertyFilePrinter(tokens);
parser.file();
```

Si ahora quisiéramos hacer otra aplicación que, en vez de imprimir las propiedades, las almacenara en un *Map*, solo habría que derivar otro parser que sobrescribiera el método *defineProperty()*:

```java
public class PropertyFileLoader extends PropertyFileParser {
   Map<String, String> props = new OrderedHashMap<String, String>();
   public PropertyFileLoader(TokenStream input) {
      super(input);
   }
   void defineProperty(Token name, Token value) {
      props.put(name.getText(), value.getText());    
   }
}
```

Estas soluciones, con acciones embebidas en la gramática tiene el inconveniente de que la gramática solo nos sirve para el lenguaje Java, no está desacoplada del lenguaje de la aplicación, aunque para aplicaciones Java puede dar servicio a diferentes aplicaciones.

## Aplicaciones basadas en Listeners

Una forma de evitar incluir código en la gramática es utilizar el mecanismo de los *Listeners* que genera ANTLR.

Vamos a usar la gramática del apartado anterior, pero quitando todo el código:

```shell
grammar PropertyFile;

file : prop+ ;
prop     : ID '=' STRING '\n' ;

ID   : [a-z]+ ;
STRING : '"' .*? '"' ;
```

El fichero que se va a analizar se ha llamado *t.properties* y es el siguiente:

```shell
user="parrt"
machine="maniac"
```

Podemos generar el árbol correspondiente a este fichero utilizando las siguientes instrucciones:

```shell
antlr PropertyFile.g4 
javac -cp /usr/local/lib/antlr-4.13.1-complete.jar:. PropertyFile*.java
grun PropertyFile file -gui t.properties
```

<img title="" src="img/antlr4_parse_tree.png" alt="" data-align="center" width="395">

A partir del fichero *PropertyFile.g4* de la gramática anterior, ANTLR genera los siguientes ficheros:

- *PropertyFile.interp*, *PropertyFile.tokens*, *PropertyFileLexere.interp* y *PropertyFileLexxer.tokens*: ficheros auxiliares que utilizan el lexer y el parser para dar código a los tokens y las reglas.

- *PropertyFileLexer.java:* analizador lexicográfico, el *Lexer*.

- *PropertyFileParser.java:* analizador sintáctico, el *Parser*.

- *PropertyFileListener.java:* el interface para los listeners de esta gramática. Tiene un método *enter()* y un método *exit()* para cada regla sintáctica, que son llamados al recorrer el árbol sintáctico que se puede crear con el *Parser*. En este caso, los métodos creados son: *enterFile(), exitFile(), enterProp()* y *exitProp()*.

- *PropertyFileBaseListener.java:* clase base para los listeners, que implementa el interface *PropertyFileListener* proporcionando métodos por defecto (los métodos están vacíos).

El Parser creado por ANTLR dispone de una clase derivada *ParserRuleContext* para cada regla sintáctica de la gramática. La clase *ParserRuleContext* deriva en última instancia de la clase *ParseTree*. En este caso, las clases creadas son *FileContext* y *PropContext*. Los argumentos que reciben los métodos *enter()* y *exit()* del listener son objetos de esas clases.

En las reglas sintácticas que utilicen *tokens*, la clase *Context* correspondiente dispondrá de unos métodos que devuelven un objeto de la clase *TerminalNode* con una referencia a dicho *Token*. En el ejemplo, la clase *PropContext* dispone de unos métodos *ID()* y *STRING()* que devuelven los *tokens*.

Para probar el listener del ejemplo, se podría crear una clase llamada *MyPropertyFileListener* derivada de *PropertyFileBaseListener* y sobrescribir alguno de los métodos:

```java
public class MyPropertyFileListener extends PropertyFileBaseListener {
    @Override
    public void enterFile(PropertyFileParser.FileContext ctx) {
        System.out.println("enterFile()");
    }
    @Override
    public void exitFile(PropertyFileParser.FileContext ctx) {
        System.out.println("exitFile()");
    }
    @Override
    public void enterProp(PropertyFileParser.PropContext ctx) {
        System.out.println("enterProp(): " 
            + "ID: " + ctx.ID().getText()
            + " STRING: " + ctx.STRING());
    }
    @Override
    public void exitProp(PropertyFileParser.PropContext ctx) {
        System.out.println("exitProp(): " + ctx.getText());
    }    
}
```

Ahora, habría que crear el programa principal:

      robot.moveForward(1.0, 0.3);
      robot.pivotRight(25.0);
      robot.moveForward(1.0, 0.3);
      robot.pivotRight(25.0);
      robot.moveForward(1.0, 0.3);
      robot.pivotRight(25.0);
      robot.moveForward(1.0, 0.3);
      robot.pivotRight(25.0);
      robot.moveForward(1.0, 0.3);
      robot.pivotRight(25.0);

```java
public class TestPropertyFileListener {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        CharStream input = CharStreams.fromStream(is);

        PropertyFileLexer lexer = new PropertyFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokens);
        ParseTree tree = parser.file(); // parse
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyPropertyFileListener(), tree);
    }
}
```

Para compilar:

```shell
javac -cp /usr/local/lib/antlr-4.13.1-complete.jar:. *.java -d ../bin
```

Para ejecutar:

```shell
java -cp /usr/local/lib/antlr-4.13.1-complete.jar:. 
    TestPropertyFileListener t.properties 
```

La salida por pantalla debería ser similar a la siguiente:

```shell
enterFile()
enterProp(): ID: user STRING: "parrt"
exitProp(): user="parrt"

enterProp(): ID: machine STRING: "maniac"
exitProp(): machine="maniac"

exitFile()
```

## Subreglas sintácticas etiquetadas

Cuando una regla sintáctica tiene varias subreglas con el operador OR, es difícil distinguir en el listener qué regla concreta se está explorando al recorrer el árbol. Una opción es *etiquetarlas*. De esta forma, el parser que genera ANTLR dispondrá de métodos *enter()* y *exit()* individuales para cada subregla. 

Observe la siguiente gramática, que es una variación de la grmática *PropertyFile.g4* que se utilizó en el apartado anterior:

```shell
grammar LabeledFP;

file : prop+ ;

prop     : ID '=' STRING '\n'  #String
        | ID '=' INT '\n'     #Int
        ;

ID   : [a-z]+ ;
STRING : '"' .*? '"' ;
INT : [0-9]+ ;
```

Ahora, la regla *prop* tiene dos opciones: cuando la parte valor de la propiedad es una cadena de texto y cuando es un número entero. Se han puesto dos etiquetas: *String* y *Int*. Si generamos el parser con ANTLR, se puede observar que, además de los contxtos *FileContext* y *PropContext*, ahora existen otros dos: *StringContext* e *IntContext*.

Se podría probar la gramática con el siguiente fichero, que se ha llamado *t2.properties*:

```shell
x=3
machine="maniac"
z=2
```

Para ello, creamos un listener llamado *MyLabeledFPListener*, derivado de *LabeledFPBaseListener*:

```java
public class MyLabeledFPListener extends LabeledFPBaseListener {
    @Override
    public void exitString(LabeledFPParser.StringContext ctx) {
        System.out.println("Exiting String: " + 
            ctx.ID().getText() + "=" + ctx.STRING().getText());
    }
    @Override
    public void exitInt(LabeledFPParser.IntContext ctx) {
        System.out.println("Exiting Int: " + 
            ctx.ID().getText() + "=" + ctx.INT().getText());
    }
}
```

El programa principal sería el mismo, cambiando las clases a las correspondientes a *LabeledFP*. La salida por pantalla sería la siguiente:

```shell
Exiting Int: x=3
Exiting String: machine="maniac"
Exiting Int: z=2
```

Existe otra forma de etiquetar. Observe la siguiente variación de la gramática anterior:

```shell
grammar LabeledFP_2;

file : prop+ ;
prop     : ID '=' op=STRING '\n'  
        | ID '=' op=INT '\n'     
        ;
ID   : [a-z]+ ;
STRING : '"' .*? '"' ;
INT : [0-9]+ ;
```

Ahora, el parser que genera ANTLR solo tiene métodos *enter()* y *exit()* para las reglas *file* y *prop*, pero la clase *PropContext* dispone de una variable miembro del tipo *Token* llamada *op* que permite discernir cuál es la subregla que se está recorriendo. El listener se podría codificar de la siguiente forma:

```java
public class MyLabeledFP_2Listener extends LabeledFP_2BaseListener{
    @Override
    public void exitProp(LabeledFP_2Parser.PropContext ctx) {
        if(ctx.op.getType() == LabeledFP_2Parser.STRING) {
            System.out.println("Subrule: STRING");
        } else {
            System.out.println("Subrule: INT");
        }
    }
}
```

El programa principal podría ser el mismo adaptando el nombre de las clases lexer, parser y listener. La salida por pantalla:

```shell
Subrule: INT
Subrule: STRING
Subrule: INT
```

## Aplicaciones basadas en Visitors

Para utilizar un visitor en vez de un listener, hay que decirle a ANTLR que cree el interface Visitor y la clase base correspondiente. Se puede hacer de la siguiente forma:

```shell
antlrc -no-listener -visitor MyGrammar.g4
```

Utilizando la orden *antlr* de esta manera, no se creará el interface para el listener, creándose en cambio interface y clase base para el visitor.

Refiriendose a la gramática *PropertyFile.g4* utilizada anteriormente, se crearía el interface  *ProperttyFileVisitor*  y la clase *PropertyFileBaseVisitor*.

El interface *PropertyFileVisitor* tiene el siguiente código:

```java
public interface PropertyFileVisitor<T> extends ParseTreeVisitor<T> {
    T visitFile(PropertyFileParser.FileContext ctx);
    T visitProp(PropertyFileParser.PropContext ctx);
}
```

Se puede ver que declara dos métodos *visit()*, uno para cada regla sintáctica de la gramática. Se vé también que el tipo devuelto por estos métodos es genérico. Habrá que establecer el tipo concreto en el Visitor concreto que creemos.

Por su parte, la clase *PropertyFileBaseVisitor* que crea ANTLR tiene el siguiente código:

```java
public class PropertyFileBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PropertyFileVisitor<T> {
    @Override
    public T visitFile(PropertyFileParser.FileContext ctx) {
        return visitChildren(ctx);
    }
    @Override
    public T visitProp(PropertyFileParser.PropContext ctx) {
        return visitChildren(ctx);
    }
}
```

Los métodos *visit()* de cada regla sintáctica reciben como argumento un objeto de alguna de las clases contexto creadas por ANTLR dentro del Parser e invocan al método *visitChildren()* que proporciona el interface *ParseTreeVisitor*, que es del que deriva nuestro interface *Visitor*.

Podríamos crear nuestro Visitor de la siguiente forma:

```java
public class MyPropertyFileVisitor extends PropertyFileBaseVisitor<Void> {
    @Override
    public Void visitProp(PropertyFileParser.PropContext ctx) {
        System.out.println("Visitting " 
            + ctx.ID().getText() 
            + ctx.STRING().getText());
        return null;
    }    
}
```

El programa principal podría quedar de la siguiente forma:

```java
   public static void main(String[] args) throws Exception {
        ...
        CharStream input = CharStreams.fromStream(is);
        PropertyFileLexer lexer = new PropertyFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokens);
        ParseTree tree = parser.file();

        MyPropertyFileVisitor visitor = new MyPropertyFileVisitor();
        visitor.visit(tree);
    }
}
```

La salida por pantalla al procesar el fichero *t.properties*:

```shell
Visitting user="parrt"
Visitting machine="maniac"
```

Es posible utilizar aquí también la técnica del etiquetado de reglas sintácticas. En ese caso, ANTLR generará un contexto para cada subregla en el parser y un método *visit()* para cada una de ellas en el interface *Visitor*.

Por ejemplo, si se utiliza la gramática *LabeledFP*, la clase visitor se podría codificar de la siguiente forma:

```java
public class MyLabeledFPVisitor extends LabeledFPBaseVisitor<Void>{
    @Override
    public Void visitString(LabeledFPParser.StringContext ctx) {
        System.out.println("Visitting String subrule: " 
            + ctx.ID().getText() + "=" 
            + ctx.STRING().getText());
        return null;
    }    
    @Override
    public Void visitInt(LabeledFPParser.IntContext ctx) {
        System.out.println("Visitting Int subrule: " 
            + ctx.ID().getText() + "=" 
            + ctx.INT().getText());
        return null;
    }    
}
```

El programa principal sería muy similar, cambiando a las clases de *LabeledFP*. La salida por pantalla al procesar el fichero *t2.properties* sería:

```shell
Visiting Int subrule: x=3
Visiting String subrule: machine="maniac"
Visiting Int subrule: z=2
```

## Compartir información entre métodos de eventos

Se va a explicar cómo hacer que los métodos de los eventos de los listeners o de los visitors puedan devolver información o almacenarla de forma que otros métodos o el programa puedan utilizarla.

Para este ejemplo se va a trabajar en una calculadora basada en la siguiente grmática:

```shell
grammar LExpr;

s : e ;

e : e MULT e         # Mult
  | e ADD e         # Add
  | INT                # Int
  ;

MULT: '*' ;
ADD : '+' ;
INT : [0-9]+ ;
WS : [ \t\n]+ -> skip ;
```

### Cálculos usando visitors

Se puede utilizar el valor devuelto por los métodos del visitor para hacer los cálculos requeridos por la calculadora. Para ello, el tipo genérico del visitor se puede establecer como un valor *Integer*. Cuando se visite la subregla *Add* o la *Mult*, se puede devolver el resultado de la operación correspondiente y cuando se visite la subregla *Int*, el valor entero asociado. El visitor quedaría así:

```java
public class MyLExprVisitor extends LExprBaseVisitor<Integer> {
    @Override
    public Integer visitInt(LExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
    @Override
    public Integer visitMult(LExprParser.MultContext ctx) {
        int left = Integer.valueOf(ctx.e(0).getText());
        int right = Integer.valueOf(ctx.e(1).getText());
        return left*right;
    }
    @Override
    public Integer visitAdd(LExprParser.AddContext ctx) {
        int left = visit(ctx.e(0));
        int right = visit(ctx.e(1));
        return left+right;
    }
}
```

Debe observarse que se han utilizado dos técnicas diferentes para resolver los métodos *visitMult()* y *visitAdd()*.

El programa principal podría ser el siguiente:

```java
public class TestMyLExprVisitor {
    public static void main(String[] args) throws Exception {
        ...
        CharStream input = CharStreams.fromStream(is);

        LExprLexer lexer = new LExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LExprParser parser = new LExprParser(tokens);
        ParseTree tree = parser.s(); 

        MyLExprVisitor visitor = new MyLExprVisitor();
        int result = visitor.visit(tree);
        System.out.println("Resultado= " + result);
        System.out.println(tree.toStringTree(parser));
    }
}
```

Con la gramática *LExpr.g4* solo se puede procesar una línea de texto en cada ejecución del programa, pero en la línea puede haber varias operaciones encadenadas. Tras hacer la compilación, el siguiente podría ser un ejemplo de ejecución:

```shell
$> java -cp .../antlr-4.13.1-complete.jar:. TestMyLExprVisitor 
3+5*6
Resultado= 33
(s (e (e 3) + (e (e 5) * (e 6))))
$> java -cp .../antlr-4.13.1-complete.jar:. TestMyLExprVisitor 
3*5+6         
Resultado= 21
(s (e (e (e 3) * (e 5)) + (e 6)))
```

Observe que el orden de las reglas en la gramática impone la precedencia de la multiplicación sobre la suma.

## Clases deprecated

En el libro de Parr utilizan la clase `ANTLRFileStream`, que ya está deprecated. Hay que usar `CharStreams`.

[ANTLRInputStream and ANTLRFileStream are deprecated, what are the alternatives?](https://stackoverflow.com/questions/50541321/antlrinputstream-and-antlrfilestream-are-deprecated-what-are-the-alternatives)

You can use the `CharStreams` class instead of the deprecated classes as below.

```java
CharStream codePointCharStream = CharStreams.fromFileName("myfile.testlang");
TESTLANGLexer lexer = new TESTLANGLexer(codePointCharStream);
TESTLANGParser parser = new TESTLANGParser(new CommonTokenStream(lexer));
parser.addParseListener(new TESTLANGEventListener());

// Start parsing
parser.testlangFile(); 
```

### Implement an if statement

[java - If/else statements in ANTLR using listeners - Stack Overflow](https://stackoverflow.com/questions/15610183/if-else-statements-in-antlr-using-listeners)

[GitHub - bkiers/tiny-language-antlr4: Tiny Language with ANTLR 4](https://github.com/bkiers/tiny-language-antlr4?tab=readme-ov-file)

[antlr4 - How to do Priority of Operations (+ * - /) in my grammars? - Stack Overflow](https://stackoverflow.com/questions/39469383/how-to-do-priority-of-operations-in-my-grammars/39470030#39470030)

## La cláusula EOF

You should include an explicit `EOF` at the end of your entry rule any time you are trying to parse an entire input file. If you do not include the `EOF`,
 it means you are not trying to parse the entire input, and it's 
acceptable to parse only a portion of the input if it means avoiding a 
syntax error.

For example, consider the following rule:

```
file : item*;
```

This rule means "Parse as many `item` elements as possible, and then stop." In other words, this rule will *never* attempt to recover from a syntax error because it will *always* assume that the syntax error is part of some syntactic construct that's beyond the scope of the `file` rule. Syntax errors will not even be reported, because the parser will simply stop.

If instead I had the following rule:

```
file : item* EOF;
```

In means "A file consists exactly of a sequence of zero-or-more `item` elements." If a syntax error is reached while parsing an `item` element, this rule *will* attempt to recover from (and report) the syntax error and continue because the `EOF` is required and has not yet been reached.

**Fuente:** (https://stackoverflow.com/questions/17844248/when-is-eof-needed-in-antlr-4)

## JVM

- [Open Source ByteCode Libraries in Java](https://java-source.net/open-source/bytecode-libraries)

- [**ASM** is an all purpose Java bytecode manipulation and analysis framework.](https://asm.ow2.io/)

- [Byte Buddy - runtime code generation for the Java virtual machine](https://bytebuddy.net/#/)

- [# Runtime Code Generation with Byte Buddy](https://blogs.oracle.com/javamagazine/post/runtime-code-generation-with-byte-buddy)

- [A Guide to Byte Buddy | Baeldung](https://www.baeldung.com/byte-buddy)

- [GitHub - square/javapoet: A Java API for generating .java source files.](https://github.com/square/javapoet)
