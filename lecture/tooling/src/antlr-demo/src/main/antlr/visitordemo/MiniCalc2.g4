grammar MiniCalc2;

// Package declaration
@header {
package visitordemo;
}


prog  : stmt* EOF ;

stmt  : ID '=' expr ';'
      | expr ';'
      ;

// Ausdruck: eine oder mehrere Zahlen, addiert oder subtrahiert
expr  : INT ((PLUS | MINUS) INT)* ;


PLUS  : '+' ;
MINUS : '-' ;

ID    : [a-z][a-zA-Z0-9_]* ;
INT   : [0-9]+ ;

WS    : [ \t\r\n]+ -> skip ;
