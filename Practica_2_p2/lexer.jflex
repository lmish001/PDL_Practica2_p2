package lex.generado; // paquete en el que se genera el fichero java
import lex.manual.SimbolosTerminales; //Simbolos terminales definidos
import lex.manual.Symbol;

%%

%class Lexer
%implements SimbolosTerminales
%public
%unicode

%line
%column
%char

%function next_token // Nombre del método que escanea la entrada y
 // devuelve el siguiente token
%type Symbol // Tipo de retorno para la función de scan

Whitespace = [ \t\f] | {LineTerminator}
LineTerminator = \r|\n|\r\n



InputCharacter = [^\r\n]

/*Palabras reservadas*/
True = [Tt][Rr][Uu][Ee]
False = [Ff][Aa][Ll][Ss][Ee]
Entero = [Ee][Nn][Tt][Ee][Rr][Oo]
Real = [Rr][Ee][Aa][Ll]
Finmientras = [Ff][Ii][Nn][Mm][Ii][Ee][Nn][Tt][Rr][Aa][Ss]
Not = [Nn][Oo][Tt]
Booleano = [Bb][Oo][Oo][Ll][Ee][Aa][Nn][Oo]
Vector = [Vv][Ee][Cc][Tt][Oo][Rr]
Caracter = [Cc][Aa][Rr][Aa][Cc][Tt][Ee][Rr]
Mientras = [Mm][Ii][Ee][Nn][Tt][Rr][Aa][Ss]
Si = [Ss][Ii]
Entonces = [Ee][Nn][Tt][Oo][Nn][Cc][Ee][Ss]
Sino = [Ss][Ii][Nn][Oo]
Finsi = [Ff][Ii][Nn][Ss][Ii]
And = [Aa][Nn][Dd]
Or = [Oo][Rr]


/*Numeros*/
NumLiteral = [0-9]*
HexLiteral = [0-9a-fA-F]*
OctLiteral = [0-7]*
Int_Number = {NumLiteral}
Dec_Number = {NumLiteral}"."{NumLiteral} | "."{NumLiteral}
Hex_Number = 0 [xX] [1-9a-fA-F] {HexLiteral}
Oct_Number = 0 [xX] 0 {OctLiteral}

/*Comentarios*/
Comentario = "#" {InputCharacter}* {LineTerminator}?
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

%eofval{
 return new Symbol(EOF);
%eofval}

/* Macros para expresiones regulares (para simplificar reglas) */

%% 

/* Reglas para detectar los tokens y acciones asociadas */
<YYINITIAL> {
	  {Whitespace} {}
	  {True}	    { return new Symbol (BOOLEAN_LITERAL, Boolean.TRUE); }
	  {False} 		{ return new Symbol (BOOLEAN_LITERAL, Boolean.FALSE); }
	  {Entero}		{ return new Symbol (ENTERO, "ENTERO"); }
	  {Real} 		{ return new Symbol (REAL, "REAL"); }
	  {Finmientras} { return new Symbol (FINMIENTRAS, "FINMIENTRAS"); }
	  {Not} 		{ return new Symbol (NOT, "NOT"); }
	  {Booleano} 	{ return new Symbol (BOOLEANO, "BOOLEANO"); }
	  {Vector} 		{ return new Symbol (VECTOR, "VECTOR"); }
	  {Caracter} 	{ return new Symbol (CARACTER, "CARACTER"); }
	  {Mientras} 	{ return new Symbol (MIENTRAS, "MIENTRAS"); }
	  {Si} 			{ return new Symbol (SI, "SI"); }
	  {Entonces} 	{ return new Symbol (ENTONCES, "ENTONCES"); }
	  {Sino} 		{ return new Symbol (SINO, "SINO"); }
	  {Finsi} 		{ return new Symbol (FINSI, "FINSI"); }
	  {And} 		{ return new Symbol (AND, "AND"); }
	  {Or} 			{ return new Symbol (OR, "OR"); }
	  "="          	{ return new Symbol(EQ, "EQ"); }
 	  ";"          	{ return new Symbol(SEMI, "SEMI"); }
  	  "+"          	{ return new Symbol(PLUS, "PLUS"); }
   	  "-"          	{ return new Symbol(MINUS, "MINUS"); }
  	  "*"          	{ return new Symbol(TIMES, "TIMES"); }
  	  "=="		   	{ return new Symbol(EQEQ, "EQEQ"); }
  	  "<="		   	{ return new Symbol(LTEQ, "LTEQ"); }
  	  ">="		   	{ return new Symbol(GTEQ, "GTEQ"); }
  	  "!="		   	{ return new Symbol(NOTEQ, "NOTEQ"); }
  	  "<"		   	{ return new Symbol(LT, "LT"); }
  	  ">"		   	{ return new Symbol(GT, "GT"); }
  	  "<-"			{ return new Symbol(ASIG, "ASIG"); }
  	  {Commentario} { }
  	  {Int_Number} 	{ return new Symbol(INT_NUMBER, Integer.parseInt(yytext())); }
  	  {Dec_Number} 	{ return new Symbol(DEC_NUMBER, Float.parseFloat(yytext())); }
      {Hex_Number} 	{ return new Symbol(INT_NUMBER, Integer.parseInt(yytext().substring(2, yytext().length()), 16));}
      {Oct_Number} 	{ return new Symbol(INT_NUMBER, Integer.parseInt(yytext().substring(3, yytext().length()), 8));}

}



// error fallback
.|\n {System.err.println("warning: Unrecognized character '"
 + yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " +
 (yycolumn+1) + " " + yychar); }
