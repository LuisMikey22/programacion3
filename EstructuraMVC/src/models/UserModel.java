package models;

import java.sql.*;
import java.util.ArrayList;

import customClasses.User;

public class UserModel {
	
	private ArrayList<User> users;
		
	public UserModel() {
		users = new ArrayList<User>();
	}
	
	public ArrayList<User> get() {
		
		String query = "select * from users";
		Connection connection = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) { //mientras exista otro registro después
				
				Integer id = rs.getInt(1); //obtener valores
				String name = rs.getString(2);
				String email = rs.getString(3); 
				String role = rs.getString(4); 
				String phone = rs.getString(5);
				String createdAt = rs.getString(6);
				String updatedAt = rs.getString(7);
				
				users.add(new User(id, name, email, role, phone, createdAt, updatedAt)); //agregar al ArrayList
				
			}
			
			rs.close();
			
			return users; 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return users; 
		
	}
	
	public boolean deleteUser(User user) {
		String query = "DELETE FROM users WHERE `users`.`id` = "+user.id+"";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	public boolean addUser(String name, String email, String role, String phone) {
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES (NULL, '"+name+"', '"+email+"', '"+role+"', '"+phone+"', NULL, NULL);";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs>0) //si regresa un número de filas mayor a 0
				return true; 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	public boolean update(User user) {
		String query = "UPDATE `users` SET `name` = '"+user.name+"',`email` = '"+user.email+"', `role` = '"+user.role+"', `phone` = '"+user.phone+"' WHERE `users`.`id` = "+user.id+"";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	public String[] getColumnName() { //nombre de columna/campo
	    return new String[] { "Id","Name", "Email", "Role", "Phone", "Created_at", "Updated_at"};
	}

	/*public String[][] getRow() { //producto
		users = get(); //ArrayList se asigna a si mismo
		
	    if(users==null) { //si la base de datos no tiene registros
	    	return new String[0][0];
	    }
	     
	    try {
	    	String[][] rows = new String[users.size()][7]; //registros de la base de datos y 7 campos

		    for(int i=0; i<users.size(); i++) { //recorrer el ArrayList y obtener los valores
		        rows[i][0] = String.valueOf(users.get(i).getId());
		        rows[i][1] = String.valueOf(users.get(i).getName());
		        rows[i][2] = String.valueOf(users.get(i).getEmail());
		        rows[i][3] = String.valueOf(users.get(i).getRole());
		        rows[i][4] = String.valueOf(users.get(i).getPhone());
		        rows[i][5] = String.valueOf(users.get(i).getCreatedAt());
		        rows[i][6] = String.valueOf(users.get(i).getUpdatedAt());
		    }

		    return rows;
		    
	    }catch(Exception e) {
	    	 e.printStackTrace();
	    }
	    
	    return null;
	}*/
}
