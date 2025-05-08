package controllers;

import org.json.simple.JSONArray;

import models.ProductModel;
import views.ProductView;

public class ProductController {

	public ProductView view;
	public ProductModel pm;
	public JSONArray data;
	
	public ProductController() {
		view = new ProductView();
	}
	
	public void products() {
		pm = new ProductModel();
		data = pm.get();
		
		view.products(data);
		
	}
	
	public void add() {
		view.add();
	}
	
	

}