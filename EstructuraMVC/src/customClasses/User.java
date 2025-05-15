package customClasses;

public class User{
	
	public int id;
	public String name;
	public String email;
	public String role;
	public String phone;
	public String createdAt;
	public String updatedAt;
	
	public User(int id, String name, String email, String role, String phone, String createdAt, String updatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getPhone() {
		return phone;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	
}