package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import controllers.ProductController;
import models.ProductModel;

public class ProductView {

	JFrame frame;
	
	public ProductView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void products(JSONArray data) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton add = new JButton("añadir producto");
		add.setBounds(635, 70, 200, 40);
		panel.add(add);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ProductController pc = new ProductController();
				pc.add();
			}
			
		});
		
		JLabel productsLbl = new JLabel("PRODUCTOS");
		productsLbl.setForeground(new Color(0, 0, 0));
		productsLbl.setFont(new Font("Kefa", Font.PLAIN, 24));
		productsLbl.setBounds(107, 35, 210, 26);
		productsLbl.setHorizontalAlignment(JLabel.CENTER);
		panel.add(productsLbl);
		
		int x = 90;
		
		for (Object product1 : data) {
			
			JSONObject product = (JSONObject) product1; 
			
			JLabel productoTitle = new JLabel((String) product.get("title"));
			productoTitle.setForeground(new Color(0, 0, 0)); 
			productoTitle.setBounds(107, x, 210, 26);
			productoTitle.setHorizontalAlignment(JLabel.CENTER);
			panel.add(productoTitle); 
			
			JButton remove = new JButton("Eliminar");
			remove.setName((Long) product.get("id")+"");
			remove.setBounds(257, x, 210, 26);
			remove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 
					
					((JButton) e.getSource()).getName();
					
					System.out.println("Hola: "+((JButton) e.getSource()).getName());
				
					ProductModel pm = new ProductModel();
					
					String id = (String) product.get("id");
					pm.remove(id);
					
					frame.dispose();
					
					ProductController pc = new ProductController();
					pc.products();
				}
				
			});
			
			panel.add(remove);
			
			x+=35;
			
			frame.setVisible(true);
		}
	}
	
	public void add() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel nameTag = new JLabel("Nombre del producto");
		nameTag.setBounds(100, 100, 200, 40);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setBounds(100, 160, 200, 40);
		panel.add(nameInput);
		
		//*
		JLabel description = new JLabel("Descripcion: ");
		description.setBounds(100, 220, 200, 40);
		panel.add(description);
		
		JTextField descInput = new JTextField();
		descInput.setBounds(100, 280, 200, 40);
		panel.add(descInput);
		
		//*
		JLabel category = new JLabel("Categoria");
		category.setBounds(100, 340, 200, 40);
		panel.add(category);
		
		JTextField categoryInput = new JTextField();
		categoryInput.setBounds(100, 400, 200, 40);
		panel.add(categoryInput);
		
		//*
		JLabel price = new JLabel("Precio");
		price.setBounds(100, 460, 200, 40);
		panel.add(price);
		
		JTextField priceInput = new JTextField();
		priceInput.setBounds(100, 520, 200, 40);
		panel.add(priceInput);
		
		
		JButton add = new JButton("añadir producto");
		add.setBounds(100, 450, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = nameInput.getText();
				String desc = descInput.getText();
				String category = categoryInput.getText();
				String price = priceInput.getText();
				
				ProductModel pm = new ProductModel();
				pm.addProduct(name, desc, category, price);
				
				frame.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}});
		panel.add(add); 
		
		frame.setVisible(true);
	}
	
	private static void parseTestData(JSONObject product){
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}