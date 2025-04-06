grammar Asignment;

@header {
    package EjemploAntlr_Asignment;
}

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : ID ASSIGN expr PUNTO_Y_COMA
 ;

expr
 : INT     #intExpr
 | FLOAT   #floatExpr
 | STRING  #stringExpr
 ;

PUNTO_Y_COMA : ';';
ASSIGN : '=';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : . 
 ;