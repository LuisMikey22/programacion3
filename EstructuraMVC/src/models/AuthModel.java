package models;

public class AuthModel {
	 
	public AuthModel() {
 		
 	}
 	
 	public boolean access(String userEmai, String password) {
 		if(userEmai.equals("admin") ) {
 			if(password.equals("1234")) {
 				return true; 
 			}else {
 				return false;
 			}
 		}else {
 			return false; 
 		}
 		
 	}
 	
 	public String register(String userEmai, String bio, String preferences, int terms, String neighborhood) {
 		return "Email: " + userEmai + "\n" +
 			   "Biografía: " + bio + "\n" + 
 			   "Preferencias: " + preferences + "\n" +
 			   (terms==1?"Acepto términos":"No acepto términos") + "\n" + 
 			   "Colonia: " + neighborhood;
 	}
}
