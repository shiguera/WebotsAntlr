grammar RoboLang;
@header {
    package lenguaje;
}

prog: statement+ ;
 
statement:  'AVANZA' '(' VALUE ',' VALUE ')' '\n' #Avanza
			| 'GIRA' '(' VALUE ')' '\n' #Gira
			;

VALUE:      INT
        |   FLOAT
        ;

INT : DIGIT+ ;
FLOAT : '-'? DIGIT+ '.' DIGIT*
		| '-'? '.' DIGIT+
		;
fragment DIGIT : [0-9] ;

WS : [ \t\n\r]+ -> skip ;

