package lex.manual;

import lex.generado.*;

import java.io.BufferedReader;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList; 

public class Driver {
	public static void main(String args[]) throws IOException{
		// Entrada de datos: por fichero 
		InputStream dataStream = new FileInputStream("grupo_50_prueba1OK.txt");
		
		  // Creamos el objeto scanner    
		 Lexer scanner = new Lexer(dataStream);   
		 ArrayList<Symbol> symbols = new ArrayList<Symbol>(); 
		 
		 ArrayList<Object> identificadores = new ArrayList();
		 ArrayList<Object> palabrasReservadas = new ArrayList();
		 ArrayList<Object> opAritmeticos = new ArrayList();
		 ArrayList<Object> opComparacion = new ArrayList();
		 ArrayList<Object> asignacion = new ArrayList();
		 ArrayList<Object> separadores = new ArrayList();
		 ArrayList<Object> constantes = new ArrayList();
		 
		 int i;
		 
		 
		 
		 // Mientras no alcancemos el fin de la entrada    
		 boolean end = false;
		 Symbol token;
		 int simbolos = 0;
		 while (!end) {    
			 try {  
				 //leemos siguiente token
				 token = scanner.next_token();     
				 symbols.add(token);     
				 end = (token.value() == null);     
				 if (!end) {                                         
					 //System.out.println("Encontrado: {" + token.type() + " - "+SimbolosTerminales.terminalNames[token.type()]+ "} >> " + token.value());
					 if (token.type()==2){
						 identificadores.add(token.value());
					 }
					 if (token.type()>2&&token.type()<18){
						 palabrasReservadas.add(token.value());
					 }
					 if (token.type()>17&&token.type()<23){
						 opAritmeticos.add(token.value());
					 }
					 if (token.type()>22&&token.type()<29){
						 opComparacion.add(token.value());
					 }
					 if (token.type()>28&&token.type()<31){
						 asignacion.add(token.value());
					 }
					 if (token.type()>30&&token.type()<36){
						 separadores.add(token.value());
					 }
					 if (token.type()>35&&token.type()<39) {
						 constantes.add(token.value());
					 }
					 
					 simbolos ++;
					 }    
				 } 
			 catch (Exception x) {     
				 System.out.println("Ups... algo ha ido mal");     
				 x.printStackTrace();    }   } 
		
		 
		 //Impresion de los resultados por pantalla
		 System.out.println("PALABRAS RESERVADAS");
		 for (i=0; i<palabrasReservadas.size(); i++){
			 System.out.print(palabrasReservadas.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("IDENTIFICADORES");
		 for (i=0; i<identificadores.size(); i++){
			 System.out.print(identificadores.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("CONSTANTES");
		 for (i=0; i<constantes.size(); i++){
			 System.out.print(constantes.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("OPERADORES ARITMETICOS");
		 for (i=0; i<opAritmeticos.size(); i++){
			 System.out.print(opAritmeticos.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("OPERADORES DE COMPARACION");
		 for (i=0; i<opComparacion.size(); i++){
			 System.out.print(opComparacion.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("ASIGNACION");
		 for (i=0; i<asignacion.size(); i++){
			 System.out.print(asignacion.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("SEPARADORES");
		 for (i=0; i<separadores.size(); i++){
			 System.out.print(separadores.get(i)+" ");
		 }
		 System.out.println();
		 System.out.println();

		 
		 
		 symbols.trimToSize();  
		 System.out.println("___________________________________________");
		 //todo: incluir el código adicional para mostrar por pantalla el número de líneas, caracteres y símbolos encontrados en el programa.
		 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("grupo_50_prueba1OK.txt")));
		 int lineas = 0;
		 int caracteres = 0;
		 String lectura = br.readLine();
		 while (lectura!=null) {
			 lineas++;
			 caracteres = caracteres + lectura.length();
			 lectura = br.readLine();
		 }
		 System.out.println("Líneas: "+lineas );
		 System.out.println("Símbolos: "+simbolos );
		 System.out.println("Caracteres: "+caracteres );
		 
		 System.out.println("\n\n ---------------FIN--------------- "); 
		 
	}
}

