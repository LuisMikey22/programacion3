package models;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel {

	String url;
	
	JSONArray productList;
	JSONObject jsonObject;
	
	public ProductModel() {
		url = "src/files/products.json";
	}
	
	public JSONArray get() {
		
		
		JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader(url)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
  
            if(obj instanceof JSONArray) {
            	 productList = (JSONArray) obj;
    		}
            System.out.println(productList);
              
            return productList;
  
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
		
	}
	
	
	public String[] getColumnName() { //nombre de columna/campo
	    return new String[] { "Id","Name", "Price", "Stock"};
	}

	public String[][] getRow() { //producto
		productList = get();
		
	    if(productList==null) {
	    	return new String[0][0];
	    }
	     
	    try {
	    	String[][] rows = new String[productList.size()][4];

		    for (int i=0; i<productList.size(); i++) {
		        jsonObject = (JSONObject) productList.get(i);
		        rows[i][0] = String.valueOf(jsonObject.get("id"));
		        rows[i][1] = (String) jsonObject.get("name");
		        rows[i][2] = String.valueOf(jsonObject.get("price"));
		        rows[i][3] = String.valueOf(jsonObject.get("stock"));
		    }

		    return rows;
		    
	    }catch(Exception e) {
	    	 e.printStackTrace();
	    }
	    
	    return null;
	}
	
	public boolean addProduct(String id, String name, String price, String stock )
	{
		
		productList = get();
		jsonObject = new JSONObject();
	
		jsonObject.put("id", id);
		jsonObject.put("name", name);
		jsonObject.put("price", price);
		jsonObject.put("stock", stock);
		
		productList.add(jsonObject);
		
		try (FileWriter file = new FileWriter(url)) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        }catch(Exception e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	
	
	public void remove(int id) {
		
		try {
			productList = get();
			
			productList.remove(id);
			 
			System.out.println(productList); 
		}catch(Exception e) {
		     e.printStackTrace();
		}
		 
		// Write the JSON array to a file
		try(FileWriter file = new FileWriter(url)) {
			file.write(productList.toString()); // Use toString(2) for pretty printing
			file.flush();
			file.close();
			System.out.println("JSON array written to file successfully!");
		}catch(Exception e) {
		     e.printStackTrace();
		}
         
	}
	
	private static void parseTestData(JSONObject product) {
		// Obtener valores directamente del objeto producto
		String id = (String) product.get("id");   
		System.out.println("id: " + id);
		
	    String name = (String) product.get("name");   
	    System.out.println("Name: " + name);
	      
	    String price = (String) product.get("price");   
	    System.out.println("Price: " + price);
	      
	    String stock = (String) product.get("stock"); 
	    System.out.println("Stock: " + stock); 
		    
	}
}