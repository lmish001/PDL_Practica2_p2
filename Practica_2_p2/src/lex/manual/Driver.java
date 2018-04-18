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
					 System.out.println("Encontrado: {" + token.type() + " - "+SimbolosTerminales.terminalNames[token.type()]+ "} >> " + token.value());
					 simbolos ++;
					 }    
				 } 
			 catch (Exception x) {     
				 System.out.println("Ups... algo ha ido mal");     
				 x.printStackTrace();    }   } 
		 
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

