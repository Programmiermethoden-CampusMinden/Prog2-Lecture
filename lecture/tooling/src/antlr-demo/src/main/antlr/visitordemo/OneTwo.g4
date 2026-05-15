grammar OneTwo;

@header {
package visitordemo;
}

s  : a EOF ;

a  : '1' a '1'
   | '2'
   ;
