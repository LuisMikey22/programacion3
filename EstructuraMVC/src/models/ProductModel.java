package models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ProductModel {

	JSONArray productList;
	String url;
	
	public ProductModel() {
		
	}
	
	public JSONArray get() {
		JSONParser jsonParser = new JSONParser();
		String url = AuthModel.class.getResource("/files/products.json").getPath();
        
        try(FileReader reader = new FileReader(url)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
  
            JSONArray productList = (JSONArray) obj;
            System.out.println(productList);
              
            return productList;
  
        }catch(Exception e) {
            e.printStackTrace();
        } 
	
        return null;
		
	}
	
	public void remove(String id) {
		productList = get();
		
		url = AuthModel.class.getResource("/files/products.json").getPath();
        
		productList.remove(id); 
         
        System.out.println(productList); 
         
        // Write the JSON array to a file
        try(FileWriter file = new FileWriter(url)) {
	        file.write(productList.toString()); // Use toString(2) for pretty printing
	        file.flush();
	        file.close();
	        System.out.println("JSON array written to file successfully!");
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public boolean addProduct(String name, String desc, String category, String price) {
		productList = get();
		JSONObject jsonObject = new JSONObject();
		
		url = AuthModel.class.getResource("/files/products.json").getPath();
		
		
		jsonObject.put("name", name);
		jsonObject.put("title", name);
		
		jsonObject.put("description", name);
		jsonObject.put("category", name);
		jsonObject.put("price", name);
		
		productList.add(jsonObject);
		
		try(FileWriter file = new FileWriter(url)) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        }catch(Exception e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	private static void parseTestData(JSONObject product) {
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}