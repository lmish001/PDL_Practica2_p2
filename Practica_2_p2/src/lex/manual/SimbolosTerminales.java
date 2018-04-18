package lex.manual;

public interface SimbolosTerminales {
	 /* terminals */
	 public static final int EOF = 0;
	 public static final int error = 1;
	 //Identificador
	 public static final int IDENTIFICADOR=2;
	 //Palabras reservadas
	 public static final int BOOLEAN_LITERAL = 3; //para los valores de true, false
	 public static final int ENTERO = 4;
	 public static final int REAL = 5;
	 public static final int FINMIENTRAS = 6;
	 public static final int NOT = 7;
	 public static final int BOOLEANO = 8;
	 public static final int VECTOR = 9;
	 public static final int CARACTER = 10;
	 public static final int MIENTRAS = 11;
	 public static final int SI = 12;
	 public static final int ENTONCES = 13;
	 public static final int SINO = 14;
	 public static final int FINSI = 15;
	 public static final int AND = 16;
	 public static final int OR = 17;
	 //Operadores aritmeticos
	 public static final int EQ = 18;
	 public static final int PLUS = 19;
	 public static final int MINUS = 20;
	 public static final int TIMES = 21;
	 public static final int DIVIDEBY = 22;
	 //Operadores de comparación
	 public static final int NOTEQ = 23;
	 public static final int EQEQ = 24;
	 public static final int LTEQ = 25;
	 public static final int GTEQ = 26;
	 public static final int GT = 27;
	 public static final int LT = 28;
	 //Asignacion
	 public static final int ASIG = 29;
	 public static final int SAL = 30;
	 //Separadores
	 public static final int SEMI = 31;
	 public static final int LPAREN = 32;
	 public static final int RPAREN = 33;
	 public static final int LBRACK = 34;
	 public static final int RBRACK = 35;
	 //Numeros
	 public static final int INT_NUMBER = 36;
	 public static final int DEC_NUMBER = 37;
	 
	 //Otros
	 public static final int CHAR = 38;
	 
	// …

	 /* lista de nombres, util para devolver información por pantalla */
	 public static final String[] terminalNames = new String[] {
	 "EOF",
	 "error",
	 "IDENTIFICADOR",
	 "BOOLEAN_LITERAL",
	 "ENTERO",
	 "REAL",
	 "FINMIENTRAS",
	 "NOT",
	 "BOOLEANO",
	 "VECTOR",
	 "CARACTER",
	 "MIENTRAS",
	 "SI",
	 "ENTONCES",
	 "SINO",
	 "FINSI",
	 "AND",
	 "OR",
	 "EQ",
	 "PLUS",
	 "MINUS",
	 "TIMES",
	 "DIVIDEBY",
	 "NOTEQ",
	 "EQEQ",
	 "LTEQ",
	 "GTEQ",
	 "GT",
	 "LT",
	 "ASIG",
	 "SAL",
	 "SEMI",
	 "LPAREN",
	 "RPAREN",
	 "LBACK",
	 "RBACK",
	 "INT_NUMBER",
	 "DEC_NUMER",
	 "CHAR"
	 };

}