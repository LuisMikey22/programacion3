package controllers;

import models.UserModel;
import views.UserView;

public class UserController {

	public UserView view;
	
	public UserController() {
		view = new UserView();
	}
	
	public void users() {
		UserModel um = new UserModel();
		String [] column = um.getColumnName();;
		String [][] row = um.getRow();;
		
		view.users(column, row);
	}
	
	
}