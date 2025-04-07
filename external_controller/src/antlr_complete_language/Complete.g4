grammar Complete;

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | log
 | avanza
 | gira
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : ID ASSIGN expr PUNTO_Y_COMA
 ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : ABRE_LLAVE block CIERRA_LLAVE
 | stat
 ;

while_stat
 : WHILE expr stat_block
 ;

log
 : LOG expr PUNTO_Y_COMA
 ;

avanza
 : 'AVANZA' '(' expr ',' expr ')' PUNTO_Y_COMA #moveForward
 ;

gira
 : 'GIRA' '(' expr ')' PUNTO_Y_COMA #pivotAngle
 ;

expr
 : <assoc=right>expr POW expr           #powExpr
 | MINUS expr                           #unaryMinusExpr
 | NOT expr                             #notExpr
 | expr op=(MULT | DIV | MOD) expr      #multiplicationExpr
 | expr op=(PLUS | MINUS) expr          #additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr #relationalExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | atom                                 #atomExpr
 ;

atom
 : ABRE_PARENTESIS expr CIERRA_PARENTESIS #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NIL            #nilAtom
 ;

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';

PUNTO_Y_COMA : ';';
ASSIGN : '=';
ABRE_PARENTESIS : '(';
CIERRA_PARENTESIS : ')';
ABRE_LLAVE : '{';
CIERRA_LLAVE : '}';

TRUE : 'true';
FALSE : 'false';
NIL : 'nil';
IF : 'SI';
ELSE : 'SINO';
WHILE : 'MIENTRAS';
LOG : 'log';

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

COMMENT
 : '#' ~[\r\n]* -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : . 
 ;