grammar SimpleLog;

@header {
    package EjemploAntlr_Log;
}

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : log
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

log
 : LOG expr PUNTO_Y_COMA
 ;

expr
 : INT     #intExpr
 | FLOAT   #floatExpr
 | STRING  #stringExpr
 ;

PUNTO_Y_COMA : ';';

LOG : 'log';

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
 