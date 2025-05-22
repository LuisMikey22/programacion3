package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.HomeController;
import controllers.ProductController;
import controllers.UserController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.UserModel;

public class UserView {
	
	JFrame frame;
	UserModel um;
	UserController uc;
	HomeController hm;
	
	public UserView() {
		frame = new JFrame();
		frame.setTitle("Usuarios BD");
		frame.setBounds(0, 0, 700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void users(String [] column, String [][] row) {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(Color.pink);
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);
		
		JLabel userLbl = new JLabel("USERS");
		userLbl.setForeground(Color.black);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		userLbl.setHorizontalAlignment(JLabel.CENTER);
		userLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLbl.setOpaque(false);
	    backgroundPnl.add(userLbl, BorderLayout.NORTH);
		
		JTable productTable = new JTable(row, column);
	    productTable.setOpaque(false);
	    
	    JScrollPane scrollPane = new JScrollPane(productTable);
	    scrollPane.setOpaque(false);
	    backgroundPnl.add(scrollPane, BorderLayout.CENTER);
	    
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
	    
	    JButton refreshBttn = new JButton("Refresh");
	    refreshBttn.setBackground(Color.black);
	    refreshBttn.setForeground(Color.white);
	    refreshBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(refreshBttn);
	    
	    refreshBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.users();
			}
	    });
	    
	    JButton addBttn = new JButton("Add user");
	    addBttn.setBackground(Color.decode("#2A6B01"));
	    addBttn.setForeground(Color.white);
	    addBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(addBttn);
	    
	    addBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.addUser();;
			}
	    });
		
		frame.setVisible(true);
	}
	
	public void addUser() {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(255, 255, 255));
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);

		JLabel addUserLbl = new JLabel("Add user");
		addUserLbl.setForeground(Color.black);
		addUserLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		addUserLbl.setHorizontalAlignment(JLabel.CENTER);
		backgroundPnl.add(addUserLbl, BorderLayout.NORTH);
		
		//panel de formulario
	    JPanel infoPnl = new JPanel();
	    infoPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
	    infoPnl.setOpaque(false);
	    infoPnl.setLayout(new GridLayout(8, 2));
	    backgroundPnl.add(infoPnl, BorderLayout.CENTER);

		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setOpaque(false);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(nameLbl);
		
		JTextField nameTxtFld = new JTextField();
		nameTxtFld.setBackground(Color.white);
		nameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(nameTxtFld);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setOpaque(false);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(emailLbl);
		
		JTextField emailTxtFld = new JTextField();
		emailTxtFld.setBackground(Color.white);
		emailTxtFld.setOpaque(true);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(emailTxtFld);

		JLabel roleLbl = new JLabel("Role:");
		roleLbl.setOpaque(false);
		roleLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		roleLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(roleLbl);
		
		JTextField roleTxtFld = new JTextField();
		roleTxtFld.setBackground(Color.white);
		roleTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(roleTxtFld);
		
		JLabel phoneLbl = new JLabel("Phone:");
		phoneLbl.setOpaque(false);
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(phoneLbl);
		
		JTextField phoneTxtFld = new JTextField();
		phoneTxtFld.setBackground(Color.white);
		phoneTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(phoneTxtFld);
		
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
				uc = new UserController();
				uc.users();
			}
		});
	    
		JButton saveBttn = new JButton("Save");
		saveBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveBttn.setBackground(Color.black);
		saveBttn.setForeground(Color.white);
		buttonPnl.add(saveBttn);
		
		saveBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTxtFld.getText();
				String email = emailTxtFld.getText();
				String role = roleTxtFld.getText();
				String phone = phoneTxtFld.getText();
				
				um = new UserModel();
				if(um.addUser(name, email, role, phone)) {
					frame.dispose();
					uc = new UserController();
					uc.users();
				}
				
			}
			
		});
		
		frame.setVisible(true);
		 
	}
}
