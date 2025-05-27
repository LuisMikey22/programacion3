package controllers;

import java.util.ArrayList;

import customClasses.User;
import models.UserModel;
import views.UserView;

public class UserController {

	public UserView view;
	
	public UserController() {
		view = new UserView();
	}
	
	public void users() {
		UserModel um = new UserModel();
		String [] column = um.getColumnName();
		ArrayList<User> users = um.get();
		
		view.users(column, users);
	}
	
	public void addUser() {
		view.addUser();
	}
	
	public void updateUser(User user) {
		view.updateUser(user);
	}
}