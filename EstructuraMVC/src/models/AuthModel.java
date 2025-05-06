package models;

import java.io.*;

import controllers.HomeController;
import views.HomeView;

public class AuthModel {
	 
	public AuthModel() {
 		
 	}
 	
 	public boolean access(String userEmail, String password) {
 		BufferedReader reader = null;
 		
 		try {
            reader = new BufferedReader(new FileReader("src/files/users.txt")); //leer el archivo
            String row;
            String userEmailTxt; 
        	String passwordTxt;

        	while((row = reader.readLine())!=null) {
            	//lee la línea del archivo txt, corta cuando encuentra una ',' y asigna la palabra a un índice del arreglo
            	System.out.println(row);
                String[] fields = row.split(","); 
                System.out.println(""+fields.length);

                //recorta espacios que existan en las cadenas
                if(fields.length==8) {
                	userEmailTxt = fields[6].trim();
                	System.out.println(userEmailTxt);
                	passwordTxt = fields[7].trim();
                	System.out.println(passwordTxt);
                	
                	//valida si el usuario y contrseña coinciden
	                if(userEmail.equals(userEmailTxt) && password.equals(passwordTxt)) {
	                	reader.close();
	                    return true;
	                }
                }
            }
        	
        	reader.close();
            
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
 		
 		return false;
 	}
 	
 	public void register(String name, String surname, String company, String field, String position, String username, String userEmail, String password) {
 		FileWriter archivo = null;
 		PrintWriter escritor = null;
 		String linea;
 		System.out.println(name+", "+surname+", "+company+", "+field+", "+position+", "+username+", "+userEmail+", "+password);
 		
 		try {
 			archivo = new FileWriter("src/files/users.txt", true);
 			escritor = new PrintWriter(archivo);
 			linea = name+", "+surname+", "+company+", "+field+", "+position+", "+username+", "+userEmail+", "+password;
 			escritor.println(linea);
 			
 			archivo.close();  
 		}catch(Exception e) {
 			e.printStackTrace();
            System.out.println("Error");
 		}
 	}
 	
 	
 	public boolean registerCompany(String name, String surname, String company, String position) {
 		if(word(name) && word(surname) && compoundWord(company) && word(position)) {
 			return true;
 		}
 		
 		return false;
 	}
 	
 	public boolean registerUser(String username, String email, String password, String confirmation) {
 		if(compoundWord(username) && !blankSpace(email) && safePassword(password) && confirmation.equals(password)) {
 			return true;
 		}
 		
 		return false;
 	}
 	
 	
 	//métodos para validar carácteres en palabras
 	public boolean word(String text) {
        for(char character:text.toCharArray()) {
            if(character!=' ' && !Character.isLetter(character)) { //si es diferente a espacios y letras
                return false;
            }
        }
        
        return true;
    }
 	
 	
 	public boolean compoundWord(String text) {
        for(char character:text.toCharArray()) {
            if(character!=' ' && !Character.isLetter(character) && !Character.isDigit(character)) { //si es diferente a espacios, números y letras
                return false;
            }
        }
        
        return true;
    }
 	
 	public boolean blankSpace(String text) {
        for(char character:text.toCharArray()) {
            if(character!=' ') { //si es diferente a espacios
                return false;
            }
        }
        
        return true;
    }
 	
 	public boolean safePassword(String text) {
 		String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).*$";
 		
 		if(text.matches(regex)) { //si coincide y tiene al menos un carácter del patrón de búsqueda (regex)
 			return true;
 		}
        
        return false;
    }
}
