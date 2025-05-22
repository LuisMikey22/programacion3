package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.HomeController;
import controllers.ProductController;
import models.ProductModel;

public class ProductView {

	ProductModel prodModel;
	
	JFrame frame;
	
	String [] column;
	
	String [][] row;
	
	ProductController prodView;
	HomeController hm;
	
	public ProductView() {
		prodModel = new ProductModel();
		
		column = prodModel.getColumnName();
		row = prodModel.getRow();
		
		frame = new JFrame();
		frame.setTitle("Producto");
		frame.setBounds(0, 0, 700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void products(JSONArray data) {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(255, 255, 255));
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);

		JLabel productLbl = new JLabel("Producto");
		productLbl.setForeground(Color.black);
		productLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		productLbl.setHorizontalAlignment(JLabel.CENTER);
		backgroundPnl.add(productLbl, BorderLayout.NORTH);
		
		//tabla
		JPanel tablePnl = new JPanel();
	    tablePnl.setOpaque(false);
	    tablePnl.setLayout(new BorderLayout());
	    backgroundPnl.add(tablePnl, BorderLayout.CENTER);
	    
	    JTable productTable = new JTable(row, column);
	    productTable.setOpaque(false);
	    
	    JScrollPane scrollPane = new JScrollPane(productTable);
	    scrollPane.setOpaque(false);
	    tablePnl.add(scrollPane, BorderLayout.CENTER);
	    
	    //panel de botones
	    JPanel buttonPnl = new JPanel();
	    buttonPnl.setOpaque(false);
	    buttonPnl.setLayout(new GridLayout(1, 3, 20, 0));
	    backgroundPnl.add(buttonPnl, BorderLayout.SOUTH);
	    
	    JButton backBttn = new JButton("Back");
	    backBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backBttn.setBackground(Color.white);
	    backBttn.setForeground(Color.black);
		buttonPnl.add(backBttn);
		
		backBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hm = new HomeController();
				hm.home();
			}
		});
	    
		JButton deleteBttn = new JButton("Delete product");
		deleteBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		deleteBttn.setBackground(Color.decode("#A81B0C"));
		deleteBttn.setForeground(Color.white);
		buttonPnl.add(deleteBttn);
		
		deleteBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = JOptionPane.showInputDialog("Product ID:");
		        if(id!=null) { //número válido
		        	int idIndex = Integer.parseInt(id);
		        	if(column!=null && row!=null) { //si existen datos en el JSON
		        		prodModel.remove(idIndex);
		        		frame.dispose();
						prodView = new ProductController();
						prodView.products();
		        	}else {
		        		String message = "Empty JSON";
						JOptionPane.showMessageDialog(null, message, "Empty table", JOptionPane.WARNING_MESSAGE); //ventana emergente
		        	}
		        }else {
		        	String message = "Invalid input";
					JOptionPane.showMessageDialog(null, message, "Invalid input", JOptionPane.WARNING_MESSAGE); //ventana emergente
		        }
			}
			
		});
		
		JButton addBttn = new JButton("Add product");
		addBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addBttn.setBackground(Color.decode("#2A6B01"));
		addBttn.setForeground(Color.white);
		buttonPnl.add(addBttn);
		
		addBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				prodView = new ProductController();
				prodView.addProduct();
			}
			
		});
		frame.setVisible(true);
	}
	
	public void addProducts() {

		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(255, 255, 255));
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);

		JLabel addProductLbl = new JLabel("Add product");
		addProductLbl.setForeground(Color.black);
		addProductLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		addProductLbl.setHorizontalAlignment(JLabel.CENTER);
		backgroundPnl.add(addProductLbl, BorderLayout.NORTH);
		
		//panel de formulario
	    JPanel infoPnl = new JPanel();
	    infoPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
	    infoPnl.setOpaque(false);
	    infoPnl.setLayout(new GridLayout(4, 2));
	    backgroundPnl.add(infoPnl, BorderLayout.CENTER);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setBounds(390, 120, 90, 30);
		idLbl.setOpaque(false);
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		idLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(idLbl);
		
		JTextField idTxtFld = new JTextField();
		idTxtFld.setBackground(Color.white);
		idTxtFld.setOpaque(true);
		idTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(idTxtFld);

		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setOpaque(false);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(nameLbl);
		
		JTextField nameTxtFld = new JTextField();
		nameTxtFld.setBackground(Color.white);
		nameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(nameTxtFld);
		
		JLabel priceLbl = new JLabel("Price:");
		priceLbl.setOpaque(false);
		priceLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		priceLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(priceLbl);
		
		JTextField priceTxtFld = new JTextField();
		priceTxtFld.setBackground(Color.white);
		priceTxtFld.setOpaque(true);
		priceTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(priceTxtFld);

		JLabel stockLbl = new JLabel("Stock:");
		stockLbl.setOpaque(false);
		stockLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		stockLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(stockLbl);
		
		JTextField stockTxtFld = new JTextField();
		stockTxtFld.setBackground(Color.white);
		stockTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(stockTxtFld);
		
		//panel de botones
	    JPanel buttonPnl = new JPanel();
	    buttonPnl.setOpaque(false);
	    buttonPnl.setLayout(new GridLayout(1, 2, 20, 0));
	    backgroundPnl.add(buttonPnl, BorderLayout.SOUTH);
	    
	    JButton backBttn = new JButton("Back");
	    backBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backBttn.setBackground(Color.white);
	    backBttn.setForeground(Color.black);
		buttonPnl.add(backBttn);
		
		backBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				prodView = new ProductController();
				prodView.products();
			}			
		});
	    
		JButton addBttn = new JButton("Add product");
		addBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addBttn.setBackground(Color.decode("#2A6B01"));
		addBttn.setForeground(Color.white);
		buttonPnl.add(addBttn);
		
		addBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTxtFld.getText();
				String name = nameTxtFld.getText();
				String price = priceTxtFld.getText();
				String stock = stockTxtFld.getText();
				
				if (!id.equals("") && !name.equals("") && !price.equals("") && !stock.equals("")) {
					prodModel.addProduct(id, name, price, stock);
					frame.dispose();
					prodView = new ProductController();
					prodView.products();
				}else {
					String message = "Empty input";
					JOptionPane.showMessageDialog(null, message, "Empty input", JOptionPane.WARNING_MESSAGE); //ventana emergente
				}
				
			}		
		});
		
		frame.setVisible(true);
		 
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